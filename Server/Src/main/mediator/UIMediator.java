package mediator;

public class UIMediator {

    private LoginScreen loginScreen;
    private VaultScreen vaultScreen;
    private PasswordGeneratorScreen generatorScreen;

    public void registerLoginScreen(LoginScreen screen) {
        this.loginScreen = screen;
    }

    public void registerVaultScreen(VaultScreen screen) {
        this.vaultScreen = screen;
    }

    public void registerPasswordGeneratorScreen(PasswordGeneratorScreen screen) {
        this.generatorScreen = screen;
    }

    public void showWelcomeScreen() {
        System.out.println("Welcome to MyPass");
        System.out.println("Login or create a new account to continue.");
    }

    public void notify(UIComponent sender, String event) {
        switch (event) {
            case "LoginSuccess":
                System.out.println("[Mediator] Login successful → Opening Vault...");
                vaultScreen.receive("OpenVault");
                break;

            case "GeneratePassword":
                generatorScreen.receive("OpenGenerator");
                break;

            case "BackToVault":
                vaultScreen.receive("OpenVault");
                break;
        }
    }
}
