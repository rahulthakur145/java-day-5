package casestudy3;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(String productName) {
        Iterator<Product> iterator = products.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equalsIgnoreCase(productName)) {
                iterator.remove();
                System.out.println(productName + " removed from cart.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(productName + " not found in cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Products in Cart:");
            for (Product p : products) {
                p.displayProduct();
            }
            System.out.println("Total Cost: " + calculateTotalCost());
        }
        System.out.println("---------------------------");
    }
}

