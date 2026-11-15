import java.util.ArrayList;
import java.util.List;

public class TicketBookingSystem {

    public interface Seat {
        String getId();
        double getPrice();
    }

    public static class RegularSeat implements Seat {
        private String id;
        public RegularSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 150.0; }
    }

    public static class PremiumSeat implements Seat {
        private String id;
        public PremiumSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 250.0; }
    }

    public static class ReclinerSeat implements Seat {
        private String id;
        public ReclinerSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 400.0; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
    }

    public static class Show {
        private String name;
        private boolean isStarted;
        private List<String> bookedSeatIds = new ArrayList<>();

        public Show(String name) { this.name = name; }
        public boolean isStarted() { return isStarted; }
        public void setStarted(boolean started) { isStarted = started; }
        
        public boolean isSeatBooked(String seatId) {
            return bookedSeatIds.contains(seatId);
        }
        
        public void bookSeat(String seatId) {
            bookedSeatIds.add(seatId);
        }
        
        public void releaseSeat(String seatId) {
            bookedSeatIds.remove(seatId);
        }
    }

    public static class Booking {
        private Customer customer;
        private Show show;
        private List<Seat> seats;

        public Booking(Customer customer, Show show, List<Seat> seats) {
            if (seats.size() > 6) throw new IllegalArgumentException("Maximum 6 seats allowed per booking.");
            for (Seat seat : seats) {
                if (show.isSeatBooked(seat.getId())) {
                    throw new IllegalStateException("Seat " + seat.getId() + " is already booked.");
                }
            }
            this.customer = customer;
            this.show = show;
            this.seats = new ArrayList<>(seats);
            for (Seat seat : seats) {
                show.bookSeat(seat.getId());
            }
        }

        public double calculateTotal() {
            double total = 0;
            for (Seat seat : seats) {
                total += seat.getPrice();
            }
            return total;
        }

        public void cancel() {
            if (show.isStarted()) {
                throw new IllegalStateException("Cannot cancel booking after the show has started.");
            }
            for (Seat seat : seats) {
                show.releaseSeat(seat.getId());
            }
            seats.clear();
        }
    }
}