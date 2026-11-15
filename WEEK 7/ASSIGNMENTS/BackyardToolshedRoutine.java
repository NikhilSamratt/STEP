public class BackyardToolshedRoutine {

    public static abstract class GardenTool {
        public abstract String use();
    }

    public static class CuttingTool extends GardenTool {
        public String use() {
            return "Using the tool in the garden, blade sharpened first";
        }
    }

    public static class Pruner extends CuttingTool {
        public String use() {
            return super.use() + ", then trimming branches precisely";
        }
    }
}