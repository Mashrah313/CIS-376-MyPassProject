package model;

public class SecureNotesItem extends VaultItem {
    private String noteText;

    public SecureNotesItem(String id, String title, String noteText) {
        super(id, title, "SecureNote");
        this.noteText = noteText;
    }

    public String getNoteText() { return noteText; }

    @Override
    public void display() {
        System.out.println("Secure Note: " + title);
    }
}
