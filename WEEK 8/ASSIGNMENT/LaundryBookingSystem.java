public class LaundryBookingSystem {

    public interface WashType {
        int getDuration();
        double getCharge();
    }

    public static class QuickWash implements WashType {
        public int getDuration() { return 30; }
        public double getCharge() { return 20.0; }
    }

    public static class NormalWash implements WashType {
        public int getDuration() { return 45; }
        public double getCharge() { return 30.0; }
    }

    public static class HeavyWash implements WashType {
        public int getDuration() { return 60; }
        public double getCharge() { return 45.0; }
    }

    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class WashingMachine {
        private String id;
        private boolean isFree = true;

        public WashingMachine(String id) { this.id = id; }
        public String getId() { return id; }
        public boolean isFree() { return isFree; }
        
        void setFree(boolean free) { this.isFree = free; }
    }

    public static class WashCycle {
        private Student student;
        private WashingMachine machine;
        private WashType washType;

        public WashCycle(Student student, WashingMachine machine, WashType washType) {
            this.student = student;
            this.machine = machine;
            this.washType = washType;
        }

        public void start() {
            if (!machine.isFree()) {
                throw new IllegalStateException("Machine is busy.");
            }
            machine.setFree(false);
        }

        public void complete() {
            machine.setFree(true);
        }
        
        public double getCharge() {
            return washType.getCharge();
        }
    }
}