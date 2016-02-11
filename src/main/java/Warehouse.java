import java.util.*;

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

		for (ProductsOrder po : this.productsOrder) {
			if (po.product.id == pOrder.product.id) {
				System.out.println("Warehouse " + this.id + " has " + po.nb
								   + " products " + po.product.id);
				
				return po.nb > 0;
			}
		}
		
		return false;
	}

	public void removeProduct(Product product,int quantity){
		Optional<ProductsOrder> pd = productsOrder.stream().filter(d -> d.product == product).findFirst();
		if(pd.get().nb == quantity){
			for (int i = 0; i < productsOrder.size(); i++) {
				if(productsOrder.get(i) == pd.get()) {
					productsOrder.remove(i);
					break;
				}
			}
		} else {
			pd.get().nb -= quantity;
		}
	}
}
