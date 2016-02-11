import java.util.Optional;

/**
 * Created by guillaume on 11/02/16.
 */
public class DeliverCommand extends Command{
    Order h;

    public DeliverCommand(Drone d, Product p, int quantity,Order h) {
        super(d, p, quantity);
        this.h = h;
    }

    @Override
    public char getIdentifier() {
        return 'D';
    }

    @Override
    public String writeabs(Data data) {
        String s = "" + d.id + " " + getIdentifier() + " ";
        s += h.id + " " + p.id + " "  + quantity;
        return s;
    }
}
