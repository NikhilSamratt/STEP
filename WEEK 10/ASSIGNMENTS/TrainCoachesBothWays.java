import java.util.Scanner;

class TrainCoachesBothWays {

    static class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node head;
    static Node tail;

    static void addLast(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    static void remove(String name) {
        Node current = head;

        while (current != null && !current.data.equals(name)) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
    }

    static void printForward() {
        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    static void printBackward() {
        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.prev != null) {
                System.out.print(" <-> ");
            }

            current = current.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            addLast(sc.next());
        }

        String name = sc.next();

        remove(name);

        printForward();
        printBackward();
    }
}