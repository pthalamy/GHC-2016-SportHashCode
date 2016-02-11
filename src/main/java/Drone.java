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
	
	return (int)Math.round(dist);
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
               
            case GOINGBACK:
                goingback(data);
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
                
                this.nbTurn = timeToDest(targetedWarehouse.x, targetedWarehouse.y);
                log("Satisfait " + currentOrder + ", goto warehouse " + targetedWarehouse);
                if (this.nbTurn == 0) {
                    log("Pas besoin de bouger");
                    this.state = State.LOADING;
                }
            } else {
                log("Plus de commande à satisfaire");
            }
        } else if (this.nbTurn == 0) {
            log("Arrivé au warehouse");
            this.state = State.LOADING;
        } else {
            this.nbTurn--;
        }
    }

    private void delivering(Data data) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	if (this.nbTurn > 0) 	// Still going to the dest
	    nbTurn--;
	else if (this.nbTurn == 0) { // Arrived at the destination

	    Command cmd = new UnloadCommand(this, this.orders.getFirst(), 1);
	    cmd.write(data);

	    this.orders.remove(); // Remove the first element
	    this.state = State.GOINGBACK;
	} else 			// ERROR
       	    log("ERROR: nbTurn < 0");
    }

    private void goingback(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loading(Data data) {
        // On charge uniquement un produit
        ProductsOrder po = this.orders.getFirst().productsOrder.getFirst();
        if (po.nb == 1) {
            this.orders.getFirst().productsOrder.pop();
        } else {
            po.nb--;
        }
        this.currentLoad.add(po.product);
        this.state = State.DELIVERING;
        this.targetedWarehouse = null;
        this.nbTurn = this.timeToDest(this.orders.getFirst().x, this.orders.getFirst().y);
        
        log("A chargé depuis " + targetedWarehouse + " 1 " + po.product);
    }
    
    public void log(String msg) {
        System.out.println("[Drone " + id + "] " + msg);
    }
}
