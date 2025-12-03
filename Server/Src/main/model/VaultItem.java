package model;

import java.time.LocalDateTime;

public abstract class VaultItem {
    protected String id;
    protected String title;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected String type; // Login, CreditCard, Identity, SecureNote

    public VaultItem(String id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public abstract void display();
}
