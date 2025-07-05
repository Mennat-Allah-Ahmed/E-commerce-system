import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Cheese", 35.0, 8, true, 500, LocalDate.of(2025, 7, 15)));
        productList.add(new Product("Biscuits", 20.0, 13, true, 80, LocalDate.of(2025, 8, 15)));
        productList.add(new Product("TV", 300.0, 5, false, 1000, LocalDate.of(2025, 1, 1)));
        productList.add(new Product("Mobile", 500.0, 10, false, 350, LocalDate.of(2025, 1, 1)));
        productList.add(new Product("ScratchCard", 10.0, 30, false, 3, LocalDate.of(2025, 1, 1)));

        Cart cart = new Cart();

    }
}
