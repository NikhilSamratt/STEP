import java.util.Scanner;

class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    static void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }

    static void addLast(int token) {
        Node newNode = new Node(token);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    static void insertAt(int index, int token) {
        if (index < 0) {
            return;
        }

        if (index == 0) {
            addFirst(token);
            return;
        }

        Node current = head;

        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        Node newNode = new Node(token);
        newNode.next = current.next;
        current.next = newNode;
    }

    static void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            addLast(sc.nextInt());
        }

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String operation = sc.next();

            if (operation.equals("addFirst")) {
                addFirst(sc.nextInt());
            } else if (operation.equals("addLast")) {
                addLast(sc.nextInt());
            } else if (operation.equals("insertAt")) {
                int index = sc.nextInt();
                int token = sc.nextInt();
                insertAt(index, token);
            }
        }

        display();
    }
}