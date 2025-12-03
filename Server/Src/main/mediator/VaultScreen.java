package mediator;

public class VaultScreen extends UIComponent {

    public VaultScreen(UIMediator mediator) {
        super(mediator);
        mediator.registerVaultScreen(this);
    }

    @Override
    public void send(String event) {
        mediator.notify(this, event);
    }

    @Override
    public void receive(String message) {
        if (message.equals("OpenVault")) {
            System.out.println("Vault Screen: Displaying all saved items...");
        }
    }

    public void openGenerator() {
        send("GeneratePassword");
    }
}
