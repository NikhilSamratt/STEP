import java.util.*;

class StudentClubRegistration {

    static class Student {
        String roll;
        String name;

        Student(String roll, String name) {
            this.roll = roll;
            this.name = name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Student)) {
                return false;
            }

            Student s = (Student) obj;
            return roll.equals(s.roll);
        }

        public int hashCode() {
            return roll.hashCode();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> members = new HashSet<>();
        ArrayList<String> results = new ArrayList<>();

        while (sc.hasNext()) {
            String operation = sc.next();
            String roll = sc.next();
            String name = sc.next();

            Student s = new Student(roll, name);

            if (operation.equals("ADD")) {
                if (members.add(s)) {
                    results.add("Added");
                } else {
                    results.add("duplicate rejected");
                }
            } else if (operation.equals("CONTAINS")) {
                results.add("contains: " + members.contains(s));
            }
        }

        int count = 0;

        for (String result : results) {
            if (result.equals("Added")) {
                count++;
            }
        }

        for (String result : results) {
            System.out.println(result);
        }

        System.out.println("member count " + members.size());
    }
}