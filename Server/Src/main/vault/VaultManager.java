package vault;

import db.Database;
import model.*;
import proxy.SensitiveDataProxy;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class VaultManager {

    private int autoLockMinutes = 5;
    private Timer autoLockTimer;
    private boolean isLocked = false;

    public VaultManager() {
        startAutoLockTimer();
    }

    /** Adds a Login Item */
    public void addLoginItem(int userId, LoginItem item) throws SQLException {
        String sql = "INSERT INTO vault_items(user_id,type,title,username,password,url,created_at,updated_at) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = Database.getConnection().prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setString(2, item.getType());
        ps.setString(3, item.getTitle());
        ps.setString(4, item.getUsername());
        ps.setString(5, item.getPassword());
        ps.setString(6, item.getUrl());
        ps.setString(7, LocalDateTime.now().toString());
        ps.setString(8, LocalDateTime.now().toString());
        ps.executeUpdate();
        System.out.println("Login item added: " + item.getTitle());
    }

    /** Example: Mask/Unmask Login Password */
    public void showMaskedLoginPassword(String password) {
        SensitiveDataProxy proxy = new SensitiveDataProxy(password);
        System.out.println("Masked: " + proxy.view());
        proxy.unmask();
        System.out.println("Unmasked: " + proxy.view());
    }

    /** Vault auto-lock after inactivity */
    private void startAutoLockTimer() {
        autoLockTimer = new Timer(true);
        autoLockTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                isLocked = true;
                System.out.println("Vault auto-locked due to inactivity.");
                clearClipboard();
            }
        }, autoLockMinutes * 60 * 1000);
    }

    /** Reset auto-lock timer on user activity */
    public void resetAutoLockTimer() {
        autoLockTimer.cancel();
        isLocked = false;
        startAutoLockTimer();
    }

    /** Clipboard auto-clear after X minutes */
    private void clearClipboard() {
        System.out.println("Clearing sensitive data from clipboard...");
        // For simplicity, we simulate clipboard clear
        // Real implementation can use java.awt.Toolkit for system clipboard
    }

    public boolean isLocked() {
        return isLocked;
    }
}
