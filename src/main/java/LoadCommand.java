import java.util.Optional;

/**
 * Created by guillaume on 11/02/16.
 */
public class LoadCommand extends Command {
    Warehouse h;
    public LoadCommand(Drone d, Product p, int quantity,Warehouse h) {
        super(d, p, quantity);
        this.h = h;
    }

    @Override
    public char getIdentifier() {
        return 'L';
    }

    @Override
    public String writeabs(Data data) {
        String s = "" + d.id + " " + getIdentifier() + " ";
        s += h.id + " " + p.id + " "  + quantity;
        return s;
    }
}
