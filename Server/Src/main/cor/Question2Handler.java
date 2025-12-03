package cor;

public class Question2Handler extends RecoveryHandler {

    private String correctAnswer;

    public Question2Handler(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean handle(String answer) {
        if (!answer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Security Question 2 incorrect.");
            return false;
        }

        System.out.println("Security Question 2 verified.");
        return next == null || next.handle(answer);
    }
}
