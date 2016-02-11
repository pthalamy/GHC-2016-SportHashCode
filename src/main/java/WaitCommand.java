/**
 * Created by guillaume on 11/02/16.
 */
public class WaitCommand extends Command {
    public WaitCommand(Drone d, Product p, int quantity) {
        super(d, p, quantity);
    }

    @Override
    public char getIdentifier() {
        return 'W';
    }

    @Override
    public String writeabs(Data data) {
        return "" + d.id + " " + getIdentifier() + " " + quantity;
    }
}
