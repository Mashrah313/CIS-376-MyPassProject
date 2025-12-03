package observer;

public class UserNotificationObserver implements Observer {
    private String userEmail;

    public UserNotificationObserver(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification sent to " + userEmail + ": " + message);
    }
}
