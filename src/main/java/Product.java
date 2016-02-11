/**
 * Created by guillaume on 11/02/16.
 */
public class Product {
    public int id,weight;

    public Product(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
