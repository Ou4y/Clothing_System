import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        customer customer1 = new customer("nour", "001", "nour123");

        Products product1 = new Products("shorts", "11");
        Products product2 = new Products("tshirt", "22");
        customer1.addProductToCart(product1);
        customer1.addProductToCart(product2);

        customer1.viewCurrentCart();

        System.out.println("Enter the name of the product to remove:");
        try (Scanner scanner = new Scanner(System.in)) {
            String productNameToRemove = scanner.nextLine();
            customer1.removeProductFromCart(productNameToRemove);
        }

        try {
            customer1.confirmCart();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            customer1.viewCartsHistory("001");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
