import java.util.ArrayList;
import java.util.List;

public class PaymentProcessingSystem {

    public interface PaymentMethod {
        boolean processPayment(double amount);
    }

    public static class CreditCardPayment implements PaymentMethod {
        public boolean processPayment(double amount) {
            return true; 
        }
    }

    public static class PayPalPayment implements PaymentMethod {
        public boolean processPayment(double amount) {
            return false; 
        }
    }

    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        public double getPrice() { return price; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
    }

    public static class Order {
        private Customer customer;
        private List<Product> items = new ArrayList<>();
        private String status = "Pending";

        public Order(Customer customer) {
            this.customer = customer;
        }

        public void addProduct(Product product, int quantity) {
            for (int i = 0; i < quantity; i++) {
                items.add(product);
            }
        }

        public double getTotal() {
            double total = 0;
            for (Product p : items) total += p.getPrice();
            return total;
        }

        public void pay(PaymentMethod method) {
            if (items.isEmpty()) {
                throw new IllegalStateException("Cannot process payment for an empty order.");
            }
            if ("Paid".equals(status)) {
                throw new IllegalStateException("Order is already paid.");
            }
            
            boolean success = method.processPayment(getTotal());
            if (success) {
                this.status = "Paid";
            }
        }

        public String getStatus() { return status; }
    }
}