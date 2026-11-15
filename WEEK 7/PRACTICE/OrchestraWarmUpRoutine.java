public class OrchestraWarmUpRoutine {

    public static abstract class Instrument {
        public abstract String play();
    }

    public static class StringInstrument extends Instrument {
        public String play() {
            return "Strumming the strings";
        }
    }

    public static class Violin extends StringInstrument {
        public String play() {
            return super.play() + ", with a bow drawn across four strings";
        }
    }
}