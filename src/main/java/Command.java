/**
 * Created by guillaume on 11/02/16.
 */
public abstract class Command {

    public Drone d;
    public Product p;
    public int quantity;

    public Command(Drone d, Product p, int quantity) {
        this.d = d;
        this.p = p;
        this.quantity = quantity;
    }

    public abstract char getIdentifier();


    public abstract String writeabs(Data d);

    public void write(Data d){
        Writer.add(this,d);
    }
}
