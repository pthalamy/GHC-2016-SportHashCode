import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Warehouse {
    public int x,y,id;
    public LinkedList<ProductsOrder> productsOrder = new LinkedList<>();

    @Override
    public String toString() {
        return "Warehouse{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                ", products=" + productsOrder +
                '}';
    }

	public boolean hasStockForOrder(Order order) {
		if (order == null)
			return true; // We only need closest Warehouse
		
		ProductsOrder pOrder = order.productsOrder.getFirst();

		for (ProductOrder po : this.productsOrder) {
			if (po.product.id == pOrder.product.id) {
				System.out.println("Warehouse " + this.id + " has " + po.product.nb
								   + " products " + po.product.id);
				
				return po.product.nb > 0;
			}
		}
		
		return false;
	}
}
