import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AssignmentSubmissionPortal {

    public static abstract class Assignment {
        private String title;
        private int maxMarks;
        private LocalDate dueDate;

        public Assignment(String title, int maxMarks, LocalDate dueDate) {
            this.title = title;
            this.maxMarks = maxMarks;
            this.dueDate = dueDate;
        }

        public LocalDate getDueDate() { return dueDate; }
        public int getMaxMarks() { return maxMarks; }
        public abstract double applyPenalty(int awardedMarks, int lateDays);
    }

    public static class CodingAssignment extends Assignment {
        public CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }
        public double applyPenalty(int awardedMarks, int lateDays) {
            return awardedMarks * (1 - (0.10 * lateDays));
        }
    }

    public static class WrittenAssignment extends Assignment {
        public WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }
        public double applyPenalty(int awardedMarks, int lateDays) {
            return awardedMarks * (1 - (0.20 * lateDays));
        }
    }

    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
    }

    public static class Submission {
        private Student student;
        private Assignment assignment;
        private LocalDate submissionDate;
        private String status;
        private double finalMarks;

        public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
            this.student = student;
            this.assignment = assignment;
            this.submissionDate = submissionDate;
            this.status = "Submitted";
        }

        public void grade(int awardedMarks) {
            if ("Graded".equals(status)) {
                throw new IllegalStateException("Cannot resubmit or regrade a graded assignment.");
            }
            long lateDays = ChronoUnit.DAYS.between(assignment.getDueDate(), submissionDate);
            if (lateDays < 0) lateDays = 0;
            
            this.finalMarks = assignment.applyPenalty(awardedMarks, (int) lateDays);
            this.status = "Graded";
        }
        
        public String getStatus() { return status; }
        public double getFinalMarks() { return finalMarks; }
    }
}