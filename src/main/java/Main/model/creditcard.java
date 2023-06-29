package Main.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;



@Entity
@Table
public class creditcard {
    @Id
    private int id ;
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
    public creditcard(){}

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
