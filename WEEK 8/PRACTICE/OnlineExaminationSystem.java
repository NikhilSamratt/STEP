import java.util.HashMap;
import java.util.Map;

public class OnlineExaminationSystem {

    public interface Question {
        String getId();
        int evaluate(String answer);
    }

    public static class MCQ implements Question {
        private String id;
        private String correctAnswer;
        private int points;

        public MCQ(String id, String correctAnswer, int points) {
            this.id = id;
            this.correctAnswer = correctAnswer;
            this.points = points;
        }
        public String getId() { return id; }
        public int evaluate(String answer) {
            return correctAnswer.equalsIgnoreCase(answer) ? points : 0;
        }
    }

    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
    }

    public static class Examination {
        private String id;
        private Map<String, Question> questions = new HashMap<>();

        public Examination(String id) { this.id = id; }
        public void addQuestion(Question q) { questions.put(q.getId(), q); }
        public Question getQuestion(String id) { return questions.get(id); }
    }

    public static class Attempt {
        private Student student;
        private Examination exam;
        private Map<String, String> answers = new HashMap<>();
        private String status = "InProgress";
        private int totalScore = 0;

        public Attempt(Student student, Examination exam) {
            this.student = student;
            this.exam = exam;
        }

        public void recordAnswer(String questionId, String answer) {
            if ("Submitted".equals(status)) {
                throw new IllegalStateException("Cannot change answers for a submitted examination.");
            }
            answers.put(questionId, answer);
        }

        public void submit() {
            if ("Submitted".equals(status)) return;
            
            totalScore = 0;
            for (Map.Entry<String, String> entry : answers.entrySet()) {
                Question q = exam.getQuestion(entry.getKey());
                if (q != null) {
                    totalScore += q.evaluate(entry.getValue());
                }
            }
            this.status = "Submitted";
        }

        public int getTotalScore() { return totalScore; }
        public String getStatus() { return status; }
    }
}