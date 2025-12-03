package main;

import singleton.SessionManager;
import mediator.UIMediator;
import db.Database;

public class MyPassApp {
    public static void main(String[] args) {
        System.out.println("=== MyPass Password Manager ===");

        Database.connect();
        UIMediator mediator = new UIMediator(); // UI controlling mediator

        // Simple console testing behavior
        mediator.showWelcomeScreen();

        // Start the session
        SessionManager.getInstance().startSession("demo_user@example.com");

        System.out.println("Session Active: "
                + SessionManager.getInstance().getLoggedInUser());
    }
}
