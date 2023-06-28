package Main.model;
import java.util.List;

public class wallet {

private double balance;
private creditcard cc;
private List<transactionDB> transactions; /// to see my previous transactions



public void addFunds(double amount) {
        // Validate amount and credit card information
        // Process payment using a payment gateway API
        // Add funds to balance
        // Create a new transaction object and add it to the transactions list
    }
    public wallet(double myCurrentBalance, creditcard cc) {
        balance = myCurrentBalance;
        this.cc = cc;
    }
    public wallet(){
        balance = 0.0;
    }


}
