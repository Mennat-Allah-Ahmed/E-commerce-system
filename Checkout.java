import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    public static boolean isExpired(Product product) {
        if (product.isExpirable()) {
           return product.getExpireDate().isBefore(LocalDate.now());
        } else {
           return false;
        }
    }

    public static boolean isShippable(Product product) {
        return product.getWeight() >= 5; //in grams
    }

    public static void checkout(Customer customer, Cart cart){
        if (cart.isEmpty()) {
            throw new RuntimeException("Cart is empty.");
        }

        double subtotal = 0;
        double totalWeight = 0; // in grams
        double shippingCostPerKg = 20;
        Map<String, Integer> shippingQuantities = new HashMap<>();
        List<Product> shippableItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (isExpired(product)) {
                throw new RuntimeException(product.getName() + " is expired.");
            }

            subtotal += product.getPrice() * quantity;

            if (isShippable(product)) {
                shippableItems.add(product);
                shippingQuantities.put(product.getName(), quantity);
                totalWeight += product.getWeight() * quantity;
            }
        }

        double shippingFee = (totalWeight / 1000.0) * shippingCostPerKg;
        double totalAmount = subtotal + shippingFee;

        // Balance check
        if (customer.getBalance() < totalAmount) {
            throw new RuntimeException("Insufficient balance.");
        }

        customer.deduct(totalAmount);

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        if (!shippableItems.isEmpty()) {
            System.out.println("** Shipment notice **");
            for (Product product : shippableItems) {
                int qty = shippingQuantities.get(product.getName());
                System.out.printf("%dx %-12s %.0fg%n", qty, product.getName(), product.getWeight() * qty);
            }
            System.out.printf("Total package weight %.1fkg%n%n", totalWeight / 1000.0);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%dx %-12s %.0f%n", quantity, product.getName(), product.getPrice() * quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", shippingFee);
        System.out.printf("Amount           %.0f%n", totalAmount);
        System.out.printf("Remaining Balance %.0f%n", customer.getBalance());

        cart.clear();
    }
}