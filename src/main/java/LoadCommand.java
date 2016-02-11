import java.util.Optional;

/**
 * Created by guillaume on 11/02/16.
 */
public class LoadCommand extends Command {
    @Override
    public char getIdentifier() {
        return 'L';
    }

    @Override
    public String writeabs(Data data) {
        String s = "" + d.id + " " + getIdentifier() + " ";
        Optional<Warehouse> h = data.warehouses.stream().filter(w -> w.x == d.x && w.y == d.y).findFirst();
        s += h.get().id + " " + p.id + " "  + quantity;
        return s;
    }
}
