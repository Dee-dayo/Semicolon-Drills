package supermarket;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity){
        product.setQuantity(quantity);
        products.add(product);
    }

    public int noOfProducts() {
        return products.size();
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
