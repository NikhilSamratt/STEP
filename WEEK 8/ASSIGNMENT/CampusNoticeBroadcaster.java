import java.util.ArrayList;
import java.util.List;

public class CampusNoticeBroadcaster {

    public interface NotificationChannel {
        void send(Student student, Notice notice);
    }

    public static class EmailChannel implements NotificationChannel {
        public void send(Student student, Notice notice) {
            System.out.println("[Email -> " + student.getName() + "] " + notice.getTitle());
        }
    }

    public static class SmsChannel implements NotificationChannel {
        public void send(Student student, Notice notice) {
            System.out.println("[SMS -> " + student.getName() + "] " + notice.getTitle());
        }
    }

    public static class AppChannel implements NotificationChannel {
        public void send(Student student, Notice notice) {
            System.out.println("[App -> " + student.getName() + "] " + notice.getTitle());
        }
    }

    public static class Student {
        private String name;
        private String department;
        private List<NotificationChannel> preferredChannels;

        public Student(String name, String department, List<NotificationChannel> preferredChannels) {
            this.name = name;
            this.department = department;
            this.preferredChannels = preferredChannels;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public List<NotificationChannel> getPreferredChannels() { return preferredChannels; }
    }

    public static class Notice {
        private String title;
        private List<String> targetDepartments;

        public Notice(String title, List<String> targetDepartments) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Notice title cannot be empty.");
            }
            if (targetDepartments == null || targetDepartments.isEmpty()) {
                throw new IllegalArgumentException("At least one target department is required.");
            }
            this.title = title;
            this.targetDepartments = targetDepartments;
        }

        public String getTitle() { return title; }
        public List<String> getTargetDepartments() { return targetDepartments; }
    }

    public static class NoticeBoard {
        private List<Student> allStudents = new ArrayList<>();

        public void registerStudent(Student student) {
            allStudents.add(student);
        }

        public void postNotice(Notice notice) {
            for (Student student : allStudents) {
                if (notice.getTargetDepartments().contains(student.getDepartment())) {
                    for (NotificationChannel channel : student.getPreferredChannels()) {
                        channel.send(student, notice);
                    }
                }
            }
        }
    }
}