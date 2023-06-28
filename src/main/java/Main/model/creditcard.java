package Main.model;
import java.time.LocalDate;

public class creditcard {
    private String cardNumber ;
    private LocalDate ExpiryDate ;
    private String CVV ;
    private String creditcardName ;
    private double currentBalance;


    public creditcard(String cardNumber, LocalDate expiryDate, String CVV, String creditcardName, double currentBalance) {
        this.cardNumber = cardNumber;
        ExpiryDate = expiryDate;
        this.CVV = CVV;
        this.creditcardName = creditcardName;
        this.currentBalance = currentBalance;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getCreditcardName() {
        return creditcardName;
    }

    public void setCreditcardName(String creditcardName) {
        this.creditcardName = creditcardName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
