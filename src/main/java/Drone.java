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
                this.orders.add(data.orders.pop());

            } else {
                log("Plus de commande à satisfaire");
                
                return;
            }
        }
        
        targetedWarehouse = data.closestWarehouseForOrder(this, this.orders.getFirst());

        // On charge uniquement un produit
        ProductsOrder po = this.orders.getFirst().productsOrder.getFirst();
        if (po.nb == 1) {
            this.orders.getFirst().productsOrder.pop();
        } else {
            po.nb--;
        }
        this.currentLoad.add(po.product);
        
        // On retire 1 produit du warehouse
        targetedWarehouse.removeProduct(po.product, 1);
        

        // On charge 1 produit
        LoadCommand loadCmd = new LoadCommand(this, po.product, 1, targetedWarehouse);
        loadCmd.write(data);

        this.nbTurn = timeToDest(targetedWarehouse.x, targetedWarehouse.y) + 1;

        this.state = State.LOADING;

        log("Charge depuis " + targetedWarehouse.id + " 1 " + po.product + " dans " + this.nbTurn + " tours");
    }

    private void delivering(Data data) {
	nbTurn--;
        if (this.nbTurn == 0) {
            // Arrived at the destination and delivered
            this.currentLoad.pop();
            
            Order currentOrder = this.orders.getFirst();
            if (currentOrder.productsOrder.isEmpty()) {
                this.orders.pop();
            }
            
            this.x = currentOrder.x;
	    this.y = currentOrder.y;
            
            log("Commande " + currentOrder + " servie, passage en INIT");
            
            this.state = State.INIT;
            init(data);
	} else {
            log("Delivering : nbTurn = " + this.nbTurn);
        }
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
            
            this.state = State.DELIVERING;
            this.targetedWarehouse = null;
            this.nbTurn = this.timeToDest(this.orders.getFirst().x, this.orders.getFirst().y) + 1;
        } else {
            log("Loading : nbTurn = " + this.nbTurn);
        }
    }
    
    public void log(String msg) {
        System.out.println("[Drone " + id + "] " + msg);
    }
}
