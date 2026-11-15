import java.util.*;

class CampusVehiclePass {

    interface Chargeable {
        void bookChargingBay();
    }

    static class Vehicle {
        String passNumber;
        String owner;
        String type;

        Vehicle(String passNumber, String owner, String type) {
            this.passNumber = passNumber;
            this.owner = owner;
            this.type = type;
        }

        int getFee() {
            if (type.equals("Bike") || type.equals("EBike")) {
                return 300;
            }
            return 1000;
        }
    }

    static class Bike extends Vehicle {
        Bike(String pass, String owner) {
            super(pass, owner, "Bike");
        }
    }

    static class Car extends Vehicle {
        Car(String pass, String owner) {
            super(pass, owner, "Car");
        }
    }

    static class EBike extends Vehicle implements Chargeable {
        EBike(String pass, String owner) {
            super(pass, owner, "EBike");
        }

        public void bookChargingBay() {
            System.out.println(passNumber + " charging bay allotted");
        }
    }

    static class ECar extends Vehicle implements Chargeable {
        ECar(String pass, String owner) {
            super(pass, owner, "ECar");
        }

        public void bookChargingBay() {
            System.out.println(passNumber + " charging bay allotted");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("PASS")) {
                String type = sc.next();
                String pass = sc.next();
                String owner = sc.next();

                Vehicle v = null;

                if (type.equals("Bike")) {
                    v = new Bike(pass, owner);
                } else if (type.equals("Car")) {
                    v = new Car(pass, owner);
                } else if (type.equals("EBike")) {
                    v = new EBike(pass, owner);
                } else if (type.equals("ECar")) {
                    v = new ECar(pass, owner);
                }

                if (v != null) {
                    vehicles.put(pass, v);
                    System.out.println(pass + " (" + type + ") pass fee " + v.getFee());
                }

            } else if (operation.equals("CHARGE")) {
                String pass = sc.next();

                Vehicle v = vehicles.get(pass);

                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).bookChargingBay();
                } else {
                    System.out.println(pass + " rejected: charging unsupported");
                }
            }
        }
    }
}