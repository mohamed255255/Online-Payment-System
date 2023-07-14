package Main.model;

import jakarta.persistence.*;


@Table
@Entity
public class wallet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int walletID ;


private double balance;



public void addFunds(creditcard cc , int amount ) {
    if(amount <= cc.getCurrentBalance()){
        balance+=amount ;
        cc.setCurrentBalance(cc.getCurrentBalance() - amount);
    }else{
        System.out.println("THERE IS NO ENOUGH MONEY");
    }


}

    public void setId(int id) {
        this.walletID = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return walletID;
    }

    public double getBalance() {
        return balance;
    }

    public creditcard getCc() {
        return cc;
    }

    public transaction getTransactions() {
        return transactions;
    }

    public wallet(double myCurrentBalance) {
        balance = myCurrentBalance;
    }
    public wallet(){
        balance = 0.0;
    }

    public void setCc(creditcard cc) {
        this.cc = cc;
    }

    public void setTransactions(transaction transactions) {
        this.transactions = transactions;
    }

    public wallet(creditcard cc) {
        this.cc = cc;
    }
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cc_fk")
    private creditcard cc;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_fk")
    private transaction transactions; /// to see my previous transactions




}
