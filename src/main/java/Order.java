import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Order {

    public int x,y;
    public LinkedList<ProductsOrder> productsOrder = new LinkedList<>();

    @Override
    public String toString() {
        return "Order{" +
                "x=" + x +
                ", y=" + y +
                ", products=" + productsOrder +
                '}';
    }
}
