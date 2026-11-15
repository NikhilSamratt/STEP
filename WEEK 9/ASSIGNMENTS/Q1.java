import java.util.Scanner;

class Q1 {
    static String findBook(String[] isbn, String[] title, String target) {
        int low = 0;
        int high = isbn.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = isbn[mid].compareTo(target);

            if (result == 0) {
                return title[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] isbn = new String[n];
        String[] title = new String[n];

        for (int i = 0; i < n; i++) {
            isbn[i] = sc.next();
            title[i] = sc.nextLine().trim();
        }

        String target = sc.next();

        System.out.println(findBook(isbn, title, target));
    }
}