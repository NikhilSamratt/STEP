import java.util.Scanner;

class Practice5 {
    static class Participant {
        String name;
        int score;

        Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Participant[] players = new Participant[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            players[i] = new Participant(name, score);
        }

        for (int i = 1; i < n; i++) {
            Participant key = players[i];
            int j = i - 1;

            while (j >= 0 && players[j].score < key.score) {
                players[j + 1] = players[j];
                j--;
            }

            players[j + 1] = key;
        }

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && players[i].score != players[i - 1].score) {
                rank = i + 1;
            }

            System.out.println(rank + " " + players[i].name + " " + players[i].score);
        }
    }
}
