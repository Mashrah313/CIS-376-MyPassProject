package mediator;

public class PasswordGeneratorScreen extends UIComponent {

    public PasswordGeneratorScreen(UIMediator mediator) {
        super(mediator);
        mediator.registerPasswordGeneratorScreen(this);
    }

    @Override
    public void send(String event) {
        mediator.notify(this, event);
    }

    @Override
    public void receive(String message) {
        System.out.println("Password Generator Window Opening...");
        System.out.println("Set length / special characters / symbols etc.");
    }

    public void close() {
        send("BackToVault");
    }
}
