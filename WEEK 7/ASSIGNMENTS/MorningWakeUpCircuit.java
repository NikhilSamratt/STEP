public class MorningWakeUpCircuit {

    public interface Ringable {
        String ring();
    }

    public static class AlarmClock implements Ringable {
        private String time;

        public AlarmClock(String time) {
            this.time = time;
        }

        public String ring() {
            return "Alarm ringing for " + time;
        }
    }

    public static class Doorbell implements Ringable {
        private String location;

        public Doorbell(String location) {
            this.location = location;
        }

        public String ring() {
            return "Doorbell ringing at " + location;
        }
    }

    public static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }
}