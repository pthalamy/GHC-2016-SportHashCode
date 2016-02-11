import java.util.Optional;

/**
 * Created by guillaume on 11/02/16.
 */
public class UnloadCommand extends Command{
    public UnloadCommand(Drone d, Product p, int quantity) {
        super(d, p, quantity);
    }

    @Override
    public char getIdentifier() {
        return 'D';
    }

    @Override
    public String writeabs(Data data) {
        String s = "" + d.id + " " + getIdentifier() + " ";
        Optional<Order> h = data.orders.stream().filter(w -> w.x == d.x && w.y == d.y).findFirst();
        s += h.get().id + " " + p.id + " "  + quantity;
        return s;
    }
}
