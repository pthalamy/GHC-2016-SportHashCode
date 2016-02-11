import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Drone {
    public int id,maxLoad,x,y,nbTurn;
    public List<Product> currentLoad = new LinkedList<>();
    public List<Command> commands = new LinkedList<>();

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", maxLoad=" + maxLoad +
                ", x=" + x +
                ", y=" + y +
                ", nbTurn=" + nbTurn +
                ", currentLoad=" + currentLoad +
                ", commands=" + commands +
                '}';
    }
}
