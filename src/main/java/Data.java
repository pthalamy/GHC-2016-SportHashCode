import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Data {
    public int row,column,turns,maxLoad,nbDrone;

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
                '}';
    }

	public Warehouse closestWarehouseForOrder(Drone drone, Order order) {
		Warehouse closestWarehouse = this.warehouses.getFirst();
		
		for (Warehouse w : this.warehouses) {
			
		}

		return closestWarehouse;
	}
}
