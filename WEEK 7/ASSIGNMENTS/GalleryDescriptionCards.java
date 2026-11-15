public class GalleryDescriptionCards {

    public static abstract class ArtPiece {
        private static int counter = 1;
        private final String pieceId;

        public ArtPiece() {
            this.pieceId = "ART-" + (counter++);
        }

        public abstract String describe();

        public String getPieceId() {
            return pieceId;
        }
    }

    public static class Painting extends ArtPiece {
        private String title;

        public Painting(String title) {
            this.title = title;
        }

        public String describe() {
            return "Painting: " + title + ", framed on canvas";
        }
    }

    public static class Sculpture extends ArtPiece {
        private String title;

        public Sculpture(String title) {
            this.title = title;
        }

        public String describe() {
            return "Sculpture: " + title + ", carved from stone";
        }
    }
}