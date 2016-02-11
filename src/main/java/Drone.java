import java.util.LinkedList;
import java.util.List;

/**
 * Created by guillaume on 11/02/16.
 */
public class Drone {
    public int id,maxLoad,x,y,nbTurn;
    public List<Product> currentLoad = new LinkedList<>();
    public List<Command> commands = new LinkedList<>();
    public State state;

    public void timeToWarehouse(Warehouse w) {
	
    }
    
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
    
    public void update(Data data) {
        switch (this.state) {
            case INIT:
                init(data);
                break;
                
            case DELIVERING:
                delivering(data);
                break;
               
            case GOINGBACK:
                goingback(data);
                break;
                
            case LOADING:
                loading(data);
                break;
        }
    }

    private void init(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void delivering(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void goingback(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loading(Data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
