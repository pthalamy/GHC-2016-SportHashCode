import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Data {
    public int row,column,turns,maxLoad,nbDrone;

	public int currentTurn = 0;
	
    public LinkedList<Drone> drones = new LinkedList<>();
    public LinkedList<Product> products = new LinkedList<>();
    public LinkedList<Warehouse> warehouses = new LinkedList<>();
    public LinkedList<Order> orders = new LinkedList<>();

    @Override
    public String toString() {
        return "Data{" +
                "row=" + row +
                ", column=" + column +
                ", turns=" + turns +
                ", maxLoad=" + maxLoad +
                ", nbDrone=" + nbDrone +
                ", drones=" + drones +
                ", products=" + products +
                ", warehouses=" + warehouses +
                '}';
    }

	public Warehouse closestWarehouseForOrder(Drone drone, Order order) {
            Warehouse closestWarehouse = null;
            int minTTD = -1;
            int currTTD;

            for (Warehouse w : this.warehouses) {
                    currTTD = drone.timeToDest(w.x, w.y);

                    if (w.hasStockForOrder(order)) {
                        if (minTTD == -1 || minTTD < currTTD) {
                            minTTD = currTTD;
                            closestWarehouse = w;
                        }
                    }
            }
            
            if (closestWarehouse == null) {
                System.err.println("ERRRREEUUURRR : no closestWarehouseForOrder");
            }

            return closestWarehouse;
	}
}
