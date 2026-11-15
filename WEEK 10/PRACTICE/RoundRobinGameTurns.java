import java.util.Scanner;

class RoundRobinGameTurns {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static Node head;
    static Node tail;

    static void addLast(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    static void printTurns(int turns) {
        if (head == null) {
            return;
        }

        Node current = head;

        for (int i = 0; i < turns; i++) {
            System.out.print(current.name);

            if (i < turns - 1) {
                System.out.print(" ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            addLast(sc.next());
        }

        int turns = sc.nextInt();

        printTurns(turns);
    }
}