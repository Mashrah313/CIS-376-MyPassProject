package model;

public class IdentityItem extends VaultItem {
    private String fullName;
    private String passportNumber;
    private String licenseNumber;
    private String ssn;

    public IdentityItem(String id, String title, String fullName,
                        String passportNumber, String licenseNumber, String ssn) {
        super(id, title, "Identity");
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.licenseNumber = licenseNumber;
        this.ssn = ssn;
    }

    @Override
    public void display() {
        System.out.println("Identity: " + fullName + " | Passport: " + passportNumber);
    }
}
