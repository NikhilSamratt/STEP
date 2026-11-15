public class WarehouseLabelPrinter {

    public interface Printable {
        String printLabel();
    }

    public static class PackageBox implements Printable {
        private String trackingId;

        public PackageBox(String trackingId) {
            this.trackingId = trackingId;
        }

        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }

    public static class Invoice implements Printable {
        private String invoiceNumber;

        public Invoice(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }

    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }
}