public class VehicleRentalSystem {

    public interface Vehicle {
        String getId();
        double calculateCharge(int days);
        boolean isAvailable();
        void setAvailable(boolean available);
    }

    public static class Sedan implements Vehicle {
        private String id;
        private boolean available = true;

        public Sedan(String id) { this.id = id; }
        public String getId() { return id; }
        public boolean isAvailable() { return available; }
        public void setAvailable(boolean available) { this.available = available; }
        public double calculateCharge(int days) { return days * 50.0; }
    }

    public static class SUV implements Vehicle {
        private String id;
        private boolean available = true;

        public SUV(String id) { this.id = id; }
        public String getId() { return id; }
        public boolean isAvailable() { return available; }
        public void setAvailable(boolean available) { this.available = available; }
        public double calculateCharge(int days) { return days * 80.0; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Rental {
        private Customer customer;
        private Vehicle vehicle;
        private int days;
        private double totalCharge;

        public Rental(Customer customer, Vehicle vehicle, int days) {
            if (!vehicle.isAvailable()) {
                throw new IllegalStateException(vehicle.getId() + " is currently unavailable.");
            }
            this.customer = customer;
            this.vehicle = vehicle;
            this.days = days;
            this.vehicle.setAvailable(false);
            this.totalCharge = vehicle.calculateCharge(days);
        }

        public double getTotalCharge() { return totalCharge; }

        public void returnVehicle() {
            this.vehicle.setAvailable(true);
        }
    }
}