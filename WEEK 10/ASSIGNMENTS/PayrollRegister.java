import java.util.*;

class PayrollRegister {

    static class Payslip {
        String name;
        String type;
        int pay;

        Payslip(String name, String type, int pay) {
            this.name = name;
            this.type = type;
            this.pay = pay;
        }

        public String toString() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Payslip> staff = new ArrayList<>();
        int total = 0;
        int highest = -1;
        String topper = "";

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            int pay = 0;

            if (type.equals("FullTime")) {
                pay = sc.nextInt();
            } else if (type.equals("PartTime")) {
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                pay = hours * rate;
            } else if (type.equals("Intern")) {
                pay = sc.nextInt();
            }

            Payslip p = new Payslip(name, type, pay);
            staff.add(p);

            total += pay;

            if (pay > highest) {
                highest = pay;
                topper = name;
            }
        }

        for (Payslip p : staff) {
            System.out.println(p);
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topper);
    }
}