import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;
import java.util.Map;

/**
 * Created by guillaume on 11/02/16.
 */
public class Drone {
    public int id,maxLoad,x,y;
    int nbTurn = 0;
    public LinkedList<ProductsOrder> currentLoad = new LinkedList<>();
    public LinkedList<Order> orders = new LinkedList<>();
    public State state = State.INIT;
    public Warehouse targetedWarehouse;
    private boolean stucked;

    public int timeToDest(int xDest, int yDest) {
	double dist = Math.sqrt(Math.pow(Math.abs(xDest - x), 2.0)
				+ Math.pow(Math.abs(yDest - y), 2.0));
	
	return (int)Math.ceil(dist);
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
                ", orders=" + orders +
                '}';
    }
    
    public void update(Data data) {
        if (!stucked) {
            switch (this.state) {
                case INIT:
                    init(data);
                    break;

                case DELIVERING:
                    delivering(data);
                    break;

                case LOADING:
                    loading(data);
                    break;
            }
        }
    }

    private void init(Data data) {
        // on fait séquentiellement
        if (this.orders.isEmpty()) {
            if (data.orders.size() > 0) {
                this.orders.add(data.orders.pop());
            } else {
                log("Plus de commande à satisfaire");
                
                return;
            }
        }
        
        targetedWarehouse = data.closestWarehouseForOrder(this, this.orders.getFirst());
        
        if (targetedWarehouse == null) {
            log(this.orders.getFirst().toString());
            System.out.println(data);
        }

        // On charge uniquement un produit
        boolean exit = false;
        do {
            ProductsOrder po = this.orders.getFirst().productsOrder.getFirst();
            if (po.nb == 1) {
                this.orders.getFirst().productsOrder.pop();
            } else {
                po.nb--;
            }
            //Create product order with same product
            ProductsOrder p = new ProductsOrder();
            p.product = po.product;
            //Search for it
            if(this.currentLoad.contains(p)) {
                ProductsOrder realPO = this.currentLoad.get(this.currentLoad.indexOf(p));
                realPO.nb++;
            } else {
                p.nb=1;
                this.currentLoad.add(p);
            }
            // On retire 1 produit du warehouse
            targetedWarehouse.removeProduct(po.product, 1);
            if(!this.orders.getFirst().productsOrder.isEmpty()) {
                po = this.orders.getFirst().productsOrder.getFirst();
                if (currentLoad() + po.product.weight <= data.maxLoad && targetedWarehouse.hasStockForOrder(this.orders.getFirst())) {
                    exit = false;
                } else {
                    exit = true;
                }
            } else {
                exit = true;
            }
        } while (!exit);

        this.nbTurn = timeToDest(targetedWarehouse.x, targetedWarehouse.y) + currentLoad.size();
        
        if (data.currentTurn + this.nbTurn < data.turns) {
        	for(ProductsOrder product: currentLoad){
        	    LoadCommand loadCmd = new LoadCommand(this, product.product, product.nb, targetedWarehouse);
        	    log("Charge depuis " + targetedWarehouse.id + " 1 " + product.nb + " dans " + this.nbTurn + " tours");
        	    loadCmd.write(data);
        	}

            this.state = State.LOADING;
        } else {
            log("Plus de temps");
            this.stucked = true;
        }

    }

    private void delivering(Data data) {
	nbTurn--;
        if (this.nbTurn == 0) {
            // Arrived at the destination and delivered
            currentLoad.clear();

            Order currentOrder = this.orders.getFirst();
            if (currentOrder.productsOrder.isEmpty()) {
                this.orders.pop();
            }
            
            this.x = currentOrder.x;
	    this.y = currentOrder.y;
            
            log("Commande " + currentOrder + " servie, passage en INIT");
            
            this.state = State.INIT;
            init(data);
	} else {
            log("Delivering : nbTurn = " + this.nbTurn);
        }
    }

    private void loading(Data data) {
        this.nbTurn--;
        if (this.nbTurn == 0) {
            log("Chargé");
            
            this.x = targetedWarehouse.x;
	    this.y = targetedWarehouse.y;

            this.nbTurn = this.timeToDest(this.orders.getFirst().x, this.orders.getFirst().y) + currentLoad.size();
            if (data.currentTurn + this.nbTurn < data.turns) {
            	for(ProductsOrder entry : currentLoad){
            	    Command cmd = new DeliverCommand(this,entry.product,entry.nb,
            	            this.orders.getFirst());
            	    cmd.write(data);
            	}
            } else {
                log("Plus de temps");
                this.stucked = true;
            }

            this.state = State.DELIVERING;
            this.targetedWarehouse = null;
        } else {
            log("Loading : nbTurn = " + this.nbTurn);
        }
    }
    
    public void log(String msg) {
        System.out.println("[Drone " + id + "] " + msg);
    }

    public int currentLoad(){
        int res = 0;
        for (ProductsOrder product : currentLoad) {
            res += product.product.weight * product.nb;
        }
        return res;
    }

    public int getLoadTime(){
        int res = 0;
        for (ProductsOrder product : currentLoad) {
            res ++;
        }
        return res;
    }
}
