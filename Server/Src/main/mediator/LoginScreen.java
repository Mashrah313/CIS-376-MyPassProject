package mediator;

public class LoginScreen extends UIComponent {

    public LoginScreen(UIMediator mediator) {
        super(mediator);
        mediator.registerLoginScreen(this);
    }

    @Override
    public void send(String event) {
        mediator.notify(this, event);
    }

    @Override
    public void receive(String message) {
        System.out.println("Login Screen Event: " + message);
    }

    public void login(String username, String password) {
        System.out.println("Attempting login for: " + username);
        send("LoginSuccess");
    }
}
