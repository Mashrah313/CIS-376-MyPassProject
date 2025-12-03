package model;

public class LoginItem extends VaultItem {
    private String username;
    private String password;
    private String url;

    public LoginItem(String id, String title, String username, String password, String url) {
        super(id, title, "Login");
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getUrl() { return url; }

    @Override
    public void display() {
        System.out.println("Login: " + title + " | " + username + " | " + url);
    }
}
