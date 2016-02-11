/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author airone
 */
class ProductsOrder {
    public Product product;
    public int nb;

    @Override
    public String toString() {
        return "ProductsOrder{" +
                "product=" + product +
                ", nb=" + nb +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return product == ((ProductsOrder)obj).product;
    }
}
