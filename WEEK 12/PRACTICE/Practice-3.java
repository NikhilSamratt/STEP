import java.util.Scanner;

class Practice3 {
    static class Editor {
        String[] stack;
        int top;
        int capacity;

        Editor(int n) {
            capacity = n;
            stack = new String[n];
            top = -1;
        }

        void type(String word) {
            if (top == capacity - 1) {
                System.out.println("rejected: history full");
                return;
            }

            stack[++top] = word;
            display();
        }

        void undo() {
            if (top == -1) {
                System.out.println("rejected: nothing to undo");
                return;
            }

            stack[top] = null;
            top--;
            display();
        }

        void display() {
            if (top == -1) {
                System.out.println("(empty)");
                return;
            }

            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i]);

                if (i < top) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Editor editor = new Editor(n);

        int commands = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < commands; i++) {
            String command = sc.nextLine();

            if (command.startsWith("TYPE ")) {
                String word = command.substring(5);
                editor.type(word);
            } else if (command.equals("UNDO")) {
                editor.undo();
            }
        }
    }
}
