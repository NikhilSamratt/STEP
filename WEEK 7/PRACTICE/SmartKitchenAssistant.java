public class SmartKitchenAssistant {

    public static abstract class KitchenTool {
        private int speedLevel = 1;

        public abstract String prepare();

        public int getSpeedLevel() {
            return speedLevel;
        }

        public void setSpeedLevel(int speedLevel) {
            if (speedLevel >= 1 && speedLevel <= 5) {
                this.speedLevel = speedLevel;
            }
        }
    }

    public interface Washable {
        String clean();
    }

    public static class Blender extends KitchenTool implements Washable {
        public String prepare() {
            return "Blending at speed " + getSpeedLevel();
        }

        public String clean() {
            return "Blender rinsed and dried";
        }
    }
}