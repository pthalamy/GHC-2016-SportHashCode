import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Command {

    public int x,y;
    public Map<Product,Integer> products = new HashMap<>();

    @Override
    public String toString() {
        return "Command{" +
                "x=" + x +
                ", y=" + y +
                ", products=" + products +
                '}';
    }
}
