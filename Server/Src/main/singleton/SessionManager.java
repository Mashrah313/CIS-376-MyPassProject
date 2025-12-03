package singleton;

public class SessionManager {
    private static SessionManager instance;
    private String loggedInUser;

    private SessionManager() {
        // prevent instantiation
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(String user) {
        this.loggedInUser = user;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void endSession() {
        loggedInUser = null;
        instance = null;
    }
}
