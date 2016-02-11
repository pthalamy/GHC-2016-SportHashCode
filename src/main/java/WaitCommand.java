/**
 * Created by guillaume on 11/02/16.
 */
public class WaitCommand extends Command {
    @Override
    public char getIdentifier() {
        return 'W';
    }

    @Override
    public String writeabs(Data data) {
        return "" + d.id + " " + getIdentifier() + " " + quantity;
    }
}
