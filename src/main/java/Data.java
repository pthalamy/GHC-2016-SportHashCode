import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Data {
    public int row,column,turns,maxLoad,nbDrone;

    public List<Drone> drones = new LinkedList<>();
    public List<Product> products = new LinkedList<>();
    public List<Warehouse> warehouses = new LinkedList<>();
    public List<Order> orders = new LinkedList<>();

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

	public Warehouse closestWarehouseForOrder(Order order) {
		
		
	}
}
