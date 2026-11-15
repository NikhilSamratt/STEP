public class FitZoneMembershipDesk {

    public interface MembershipPlan {
        double calculateFee();
    }

    public static class MonthlyPlan implements MembershipPlan {
        public double calculateFee() { return 1000.0; }
    }

    public static class QuarterlyPlan implements MembershipPlan {
        public double calculateFee() { return (1000.0 * 3) * 0.90; }
    }

    public static class AnnualPlan implements MembershipPlan {
        public double calculateFee() { return (1000.0 * 12) * 0.75; }
    }

    public static class Member {
        private String name;
        public Member(String name) { this.name = name; }
    }

    public static class Membership {
        private Member member;
        private MembershipPlan plan;
        private String status;

        public Membership(Member member, MembershipPlan plan) {
            this.member = member;
            this.plan = plan;
            this.status = "Active";
        }

        public double getFee() {
            return plan.calculateFee();
        }

        public void checkIn() {
            if (!"Active".equals(status)) {
                throw new IllegalStateException("Check-in denied: Membership is " + status);
            }
        }

        public void freeze() {
            if ("Expired".equals(status)) {
                throw new IllegalStateException("Cannot freeze an Expired membership.");
            }
            this.status = "Frozen";
        }

        public void unfreeze() {
            if ("Expired".equals(status)) {
                throw new IllegalStateException("Cannot unfreeze an Expired membership.");
            }
            this.status = "Active";
        }

        public void expire() {
            this.status = "Expired";
        }
        
        public String getStatus() { return status; }
    }
}