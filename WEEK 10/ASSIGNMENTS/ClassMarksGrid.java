import java.util.*;

class ClassMarksGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marks = new ArrayList<>();

        while (sc.hasNext()) {
            String name = sc.next();
            int[] row = new int[3];

            for (int i = 0; i < 3; i++) {
                row[i] = sc.nextInt();
            }

            names.add(name);
            marks.add(row);
        }

        int[] subjectTotal = new int[3];
        int highest = -1;
        String topper = "";

        System.out.print("Totals ");

        for (int i = 0; i < names.size(); i++) {
            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks.get(i)[j];
                subjectTotal[j] += marks.get(i)[j];
            }

            System.out.print(names.get(i) + " " + total);

            if (i < names.size() - 1) {
                System.out.print(", ");
            }

            if (total > highest) {
                highest = total;
                topper = names.get(i);
            }
        }

        System.out.println();

        System.out.print("averages ");

        for (int j = 0; j < 3; j++) {
            double average = (double) subjectTotal[j] / names.size();

            System.out.printf("%.2f", average);

            if (j < 2) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("topper " + topper + " (" + highest + ")");
    }
}