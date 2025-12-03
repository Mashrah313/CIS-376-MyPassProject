package cor;

public class RecoveryTest {

    public static void main(String[] args) {

        RecoveryHandler q1 = new Question1Handler("blue");
        RecoveryHandler q2 = new Question2Handler("tiger");
        RecoveryHandler q3 = new Question3Handler("delhi");

        q1.setNext(q2).setNext(q3);

        System.out.println("Starting password recovery...\n");

        boolean result1 = q1.handle("blue");
        boolean result2 = q2.handle("tiger");
        boolean result3 = q3.handle("delhi");

        if (result1 && result2 && result3) {
            System.out.println("\nAll questions correct → Password reset allowed.");
        } else {
            System.out.println("\nRecovery failed → Answers not verified.");
        }
    }
}
