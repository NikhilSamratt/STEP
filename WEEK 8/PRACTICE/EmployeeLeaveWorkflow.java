import java.time.LocalDate;

public class EmployeeLeaveWorkflow {

    public static abstract class Employee {
        private String name;
        public Employee(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name) { super(name); }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name) { super(name); }
    }

    public static class LeaveRequest {
        private Employee employee;
        private LocalDate startDate;
        private LocalDate endDate;
        private String status;

        public LeaveRequest(Employee employee, LocalDate startDate, LocalDate endDate) {
            this.employee = employee;
            this.startDate = startDate;
            this.endDate = endDate;
            this.status = "Pending";
        }

        public String getStatus() { return status; }

        public void approve() {
            if (!"Pending".equals(status)) {
                throw new IllegalStateException("Cannot change status from " + status);
            }
            this.status = "Approved";
        }

        public void reject() {
            if (!"Pending".equals(status)) {
                throw new IllegalStateException("Cannot change status from " + status);
            }
            this.status = "Rejected";
        }

        public void setPending() {
            if ("Approved".equals(status) || "Rejected".equals(status)) {
                throw new IllegalStateException("Cannot change leave request status from " + status + " to Pending.");
            }
            this.status = "Pending";
        }
    }
}