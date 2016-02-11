import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

/**
 * Created by guillaume on 11/02/16.
 */
public class Drone {
    public int id,maxLoad,x,y;
    int nbTurn = 0;
    public LinkedList<Product> currentLoad = new LinkedList<>();
    public LinkedList<Order> orders = new LinkedList<>();
    public State state = State.INIT;
    public Warehouse targetedWarehouse;

    public int timeToDest(int xDest, int yDest) {
	double dist = Math.sqrt(Math.pow(Math.abs(xDest - x), 2.0)
				+ Math.pow(Math.abs(yDest - y), 2.0));
	
	return (int)Math.ceil(dist);
    }
    
    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", maxLoad=" + maxLoad +
                ", x=" + x +
                ", y=" + y +
                ", nbTurn=" + nbTurn +
                ", currentLoad=" + currentLoad +
                ", orders=" + orders +
                '}';
    }
    
    public void update(Data data) {
        switch (this.state) {
            case INIT:
                init(data);
                break;
                
            case DELIVERING:
                delivering(data);
                break;
                
            case LOADING:
                loading(data);
                break;
        }
    }

    private void init(Data data) {
        // on fait séquentiellement
        if (this.orders.isEmpty()) {
            if (data.orders.size() > 0) {
                Order currentOrder = data.orders.pop();
                this.orders.add(currentOrder);
                
                targetedWarehouse = data.closestWarehouseForOrder(this, currentOrder);
                
                // On charge uniquement un produit
                ProductsOrder po = this.orders.getFirst().productsOrder.getFirst();
                if (po.nb == 1) {
                    this.orders.getFirst().productsOrder.pop();
                } else {
                    po.nb--;
                }
                this.currentLoad.add(po.product);
                
                // On charge 1 produit
                LoadCommand loadCmd = new LoadCommand(this, po.product, 1, targetedWarehouse);
                loadCmd.write(data);

                this.nbTurn = timeToDest(targetedWarehouse.x, targetedWarehouse.y);
                
                this.state = State.LOADING;
                
                
                log("Charge depuis " + targetedWarehouse + " 1 " + po.product + " dans " + this.nbTurn);
            } else {
                log("Plus de commande à satisfaire");
            }
        }
    }

    private void delivering(Data data) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	if (this.nbTurn > 0) 	// Still going to the dest
	    nbTurn--;
	else if (this.nbTurn == 0) {
            // Arrived at the destination and delivered
            this.currentLoad.clear();
            
            Order currentOrder = this.orders.pop();
            
            this.x = currentOrder.x;
	    this.y = currentOrder.y;
            
            log("Commande " + currentOrder + " servie");
            
            this.state = State.INIT;
            init(data);
	} else
       	    log("ERROR: nbTurn < 0");
    }

    private void loading(Data data) {
        this.nbTurn--;
        if (this.nbTurn == 0) {
            log("Chargé");
            
            this.x = targetedWarehouse.x;
	    this.y = targetedWarehouse.y;
	    Command cmd = new DeliverCommand(this,
					     this.currentLoad.getFirst(), 1,
					     this.orders.getFirst());
	    cmd.write(data);
            this.currentLoad.clear();
            
            this.state = State.DELIVERING;
            this.targetedWarehouse = null;
            this.nbTurn = this.timeToDest(this.orders.getFirst().x, this.orders.getFirst().y);
        }
    }
    
    public void log(String msg) {
        System.out.println("[Drone " + id + "] " + msg);
    }
}
