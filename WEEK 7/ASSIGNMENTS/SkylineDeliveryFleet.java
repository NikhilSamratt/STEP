public class SkylineDeliveryFleet {

    public static abstract class Drone {
        public abstract String fly();
    }

    public interface Trackable {
        String getLocation();
    }

    public static class DeliveryDrone extends Drone implements Trackable {
        private String id;

        public DeliveryDrone(String id) {
            this.id = id;
        }

        public String fly() {
            return "Flying delivery drone";
        }

        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    public static class ScoutDrone extends Drone {
        private String id;

        public ScoutDrone(String id) {
            this.id = id;
        }

        public String fly() {
            return "Flying scout drone";
        }
    }

    public static class GroundRobot implements Trackable {
        private String id;

        public GroundRobot(String id) {
            this.id = id;
        }

        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }
}