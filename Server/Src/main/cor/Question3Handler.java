package cor;

public class Question3Handler extends RecoveryHandler {

    private String correctAnswer;

    public Question3Handler(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean handle(String answer) {
        if (!answer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Security Question 3 incorrect.");
            return false;
        }

        System.out.println("Security Question 3 verified.");
        return true;
    }
}
