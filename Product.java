import java.time.LocalDate;

public class Product {
   private String name;
   private double price;
   private int quantity;
   private boolean expirable=false;
   private double weight; // in grams
   LocalDate expireDate;

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