public class PackageDropOffLog {

    public static abstract class DeliveryNote {
        public abstract String confirmDelivery();

        public String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }
    }

    public static class ParcelNote extends DeliveryNote {
        private String trackingId;

        public ParcelNote(String trackingId) {
            this.trackingId = trackingId;
        }

        public String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }

    public static class LetterNote extends DeliveryNote {
        private String trackingId;

        public LetterNote(String trackingId) {
            this.trackingId = trackingId;
        }

        public String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }
}