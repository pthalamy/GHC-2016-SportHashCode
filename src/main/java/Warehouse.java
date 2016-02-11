import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Warehouse {
    public int x,y,id;
    public Map<Product,Integer> products = new HashMap<>();

    @Override
    public String toString() {
        return "Warehouse{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                ", products=" + products +
                '}';
    }
}
