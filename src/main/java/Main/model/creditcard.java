package Main.model;
import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
@Table
public class creditcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String cardNumber ;
    private LocalDate ExpiryDate ;
    private String CVV ;
    private String creditcardName ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private double currentBalance;


    public creditcard(String cardNumber, LocalDate expiryDate, String CVV, String creditcardName, double currentBalance) {
        this.cardNumber = cardNumber;
        ExpiryDate = expiryDate;
        this.CVV = CVV;
        this.creditcardName = creditcardName;
        this.currentBalance = currentBalance;
    }
    public creditcard(){}

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
