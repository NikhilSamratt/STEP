public class DigitalClassroomSetup {

    public static abstract class ClassroomDevice {
        public abstract String operate();
    }

    public interface Chargeable {
        String charge();
        String charge(int minutes);
    }

    public static class Tablet extends ClassroomDevice implements Chargeable {
        private String assetTag;

        public Tablet(String assetTag) {
            this.assetTag = assetTag;
        }

        public String operate() {
            return "Tablet " + assetTag + " displaying lesson";
        }

        public String charge() {
            return assetTag + " charging";
        }

        public String charge(int minutes) {
            return assetTag + " charging for " + minutes + " minutes";
        }
    }
}