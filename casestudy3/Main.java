package casestudy3;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mobile", 20000);
        Product p3 = new Product("Headphones", 2000);

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.displayCart();

        cart.removeProduct("Mobile");

        cart.displayCart();
    }
}

