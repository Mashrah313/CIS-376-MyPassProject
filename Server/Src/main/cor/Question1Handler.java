package cor;

public class Question1Handler extends RecoveryHandler {

    private String correctAnswer;

    public Question1Handler(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean handle(String answer) {
        if (!answer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Security Question 1 incorrect.");
            return false;
        }

        System.out.println("Security Question 1 verified.");
        return next == null || next.handle(answer);
    }
}
