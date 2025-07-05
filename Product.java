import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Product {
   private String name;
   private double price;
   private int quantity;
   private boolean expirable=false;
   private double weight; // in grams
    LocalDate expireDate;

    public static List<Product> productList = new ArrayList<>();
public static void allProduct() {

    Product p1 = new Product("Cheese", 35.0, 8, true, 500, LocalDate.of(2025, 7, 15));
    Product p2 = new Product("Biscuits", 20.0, 13, true, 80, LocalDate.of(2025, 8, 15));
    Product p3 = new Product("TV", 300.0, 5, false, 1000, LocalDate.of(2025, 1, 1));
    Product p4 = new Product("Mobile", 500.0, 10, false, 350, LocalDate.of(2025, 1, 1));
    Product p5 = new Product("ScratchCard", 10.0, 30, false, 3, LocalDate.of(2025, 1, 1));

    productList.add(p1);
    productList.add(p2);
    productList.add(p3);
    productList.add(p4);
    productList.add(p5);
}

public void reduceQuantity(int qty) {
        if (qty > quantity) {
            throw new IllegalArgumentException("Not enough stock to reduce.");
        }
        this.quantity -= qty;
}

public Product(String name, double price, int quantity, boolean expirable, double weight, LocalDate expireDate){
    this.name = name;
    this.price =price;
    this.quantity = quantity;
    this.expirable=expirable;
    this.expireDate = expireDate;
    this.weight=weight;
}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public double getWeight(){return weight;}
    public boolean isExpirable(){return expirable;}
    public LocalDate getExpireDate() {return expireDate;}
}