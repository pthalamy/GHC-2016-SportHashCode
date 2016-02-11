import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Order {

    public int x,y,id;
    public LinkedList<ProductsOrder> productsOrder = new LinkedList<>();

	public int numberOfProducts() {
		int pdCount = 0;

		for (ProductsOrder po : this.productsOrder) {
			pdCount += po.nb;
		}

		return pdCount;
	}
	
    @Override
    public String toString() {
        return "Order{" +
                "x=" + x +
                ", y=" + y +
                ", products=" + productsOrder +
                '}';
    }
}
