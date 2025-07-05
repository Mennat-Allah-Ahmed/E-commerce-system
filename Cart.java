import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new LinkedHashMap<>();
    }

    public void add(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock for product: " + product.getName());
        }

        //Add to cart
        int currentQty = items.getOrDefault(product, 0);
        items.put(product, currentQty + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}