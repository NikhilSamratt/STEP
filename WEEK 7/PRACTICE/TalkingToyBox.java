public class TalkingToyBox {

    public static abstract class Toy {
        private static int counter = 1001;
        private final String toyId;

        public Toy() {
            this.toyId = "TOY-" + (counter++);
        }

        public abstract String makeSound();

        public String getToyId() {
            return toyId;
        }
    }

    public static class ToyCar extends Toy {
        private String name;

        public ToyCar(String name) {
            this.name = name;
        }

        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    public static class ToyRobot extends Toy {
        private String name;

        public ToyRobot(String name) {
            this.name = name;
        }

        public String makeSound() {
            return name + ": Beep boop!";
        }
    }
}