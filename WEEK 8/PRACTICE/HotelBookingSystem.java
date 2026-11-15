import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {

    public interface Room {
        String getId();
        double calculatePrice(int nights);
    }

    public static class StandardRoom implements Room {
        private String id;
        public StandardRoom(String id) { this.id = id; }
        public String getId() { return id; }
        public double calculatePrice(int nights) { return nights * 1000.0; }
    }

    public static class DeluxeRoom implements Room {
        private String id;
        public DeluxeRoom(String id) { this.id = id; }
        public String getId() { return id; }
        public double calculatePrice(int nights) { return nights * 2000.0; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
    }

    public static class Reservation {
        private Customer customer;
        private Room room;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isActive = true;

        public Reservation(Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
            this.customer = customer;
            this.room = room;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public boolean overlaps(LocalDate start, LocalDate end) {
            if (!isActive) return false;
            return (start.isBefore(endDate) && end.isAfter(startDate));
        }

        public double getPrice() {
            int nights = (int) ChronoUnit.DAYS.between(startDate, endDate);
            return room.calculatePrice(nights);
        }

        public void cancel(LocalDate currentDate, LocalDate deadline) {
            if (currentDate.isAfter(deadline)) {
                throw new IllegalStateException("Cancellation deadline passed.");
            }
            isActive = false;
        }
        
        public boolean isActive() { return isActive; }
        public Room getRoom() { return room; }
    }

    public static class Hotel {
        private List<Reservation> reservations = new ArrayList<>();

        public boolean isAvailable(Room room, LocalDate start, LocalDate end) {
            for (Reservation res : reservations) {
                if (res.getRoom().getId().equals(room.getId()) && res.overlaps(start, end)) {
                    return false;
                }
            }
            return true;
        }

        public Reservation bookRoom(Customer customer, Room room, LocalDate start, LocalDate end) {
            if (!isAvailable(room, start, end)) {
                throw new IllegalStateException("Room is not available for the selected dates.");
            }
            Reservation res = new Reservation(customer, room, start, end);
            reservations.add(res);
            return res;
        }
    }
}