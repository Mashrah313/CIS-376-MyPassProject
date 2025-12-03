package model;

import java.time.LocalDate;

public class CreditCardItem extends VaultItem {
    private String cardholderName;
    private String cardNumber;
    private String cvv;
    private LocalDate expirationDate;

    public CreditCardItem(String id, String title, String cardholderName, String cardNumber,
                          String cvv, LocalDate expirationDate) {
        super(id, title, "CreditCard");
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getCardholderName() { return cardholderName; }
    public String getCardNumber() { return cardNumber; }
    public String getCvv() { return cvv; }
    public LocalDate getExpirationDate() { return expirationDate; }

    @Override
    public void display() {
        System.out.println("Credit Card: " + title + " | " + cardholderName + " | " + expirationDate);
    }
}
