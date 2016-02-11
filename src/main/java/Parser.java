import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by guillaume on 11/02/16.
 */
public class Parser {

    public static Data parse(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        Data d = new Data();
        d.row = sc.nextInt();
		d.column = sc.nextInt();
        d.nbDrone = sc.nextInt();
        d.turns = sc.nextInt();
        d.maxLoad = sc.nextInt();
        int nb;
        nb = sc.nextInt();
        for (int i = 0; i < nb; i++) {
            Product p = new Product(i,sc.nextInt());
            d.products.add(p);
        }
        int nb2 = sc.nextInt();
        for (int i = 0; i < nb2; i++) {
            Warehouse h = new Warehouse();
            h.id = i;
            h.x = sc.nextInt();
            h.y = sc.nextInt();
            if(i == 0){
                for(int t = 0; t < d.nbDrone;t++){
                    Drone a = new Drone();
                    a.x = h.x;
                    a.y = h.y;
                    d.drones.add(a);
                }
            }
            for (int j = 0; j < nb; j++) {
                int quantity = sc.nextInt();
                if(quantity != 0)
                    h.products.put(d.products.get(j),quantity);
            }
        }
        nb = sc.nextInt();
        for (int i = 0; i < nb; i++) {
            Command c = new Command();
            c.x = sc.nextInt();
            c.y = sc.nextInt();
            nb2 = sc.nextInt();
            for (int j = 0; j < nb2; j++) {
                int product = sc.nextInt();
                int quantity = c.products.getOrDefault(d.products.get(product),0);
                quantity++;
                c.products.put(d.products.get(product),quantity);
            }
        }
		
        return d;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Data d = parse(args[0]);
        System.out.println(d);
    }


}
