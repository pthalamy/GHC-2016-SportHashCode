import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Drone {
    public int id,maxLoad,x,y;
    int nbTurn = 0;
    public LinkedList<Product> currentLoad = new LinkedList<>();
    public LinkedList<Order> orders = new LinkedList<>();
    public State state;

    public int timeToDest(int xDest, int yDest) {
	double dist = Math.sqrt();

	
	
	return Math.round(dist);
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
                
                Warehouse warehouse = data.closestWarehouseForOrder(currentOrder);
                
                this.nbTurn = timeToDest(warehouse.x, warehouse.y);
                log("Satisfait " + currentOrder + ", goto warehouse " + warehouse.id);
            } else {
                log("Plus de commande à satisfaire");
            }
        } else if (this.nbTurn == 0) {
            this.state = State.LOADING;
            loading(data);
        } else {
            this.nbTurn--;
        }
    }

    private void delivering(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void goingback(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loading(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void log(String msg) {
        System.out.println("[Drone " + id + "]");
    }
}
