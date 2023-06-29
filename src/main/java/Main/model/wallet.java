package Main.model;

import jakarta.persistence.*;


@Table
@Entity
public class wallet {
@Id
private int id ;
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
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
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

    public wallet(double myCurrentBalance, creditcard cc) {
        balance = myCurrentBalance;
        this.cc = cc;
    }
    public wallet(){
        balance = 0.0;
        cc = new creditcard();
    }
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cc_fk")
    private creditcard cc;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_fk")
    private transaction transactions; /// to see my previous transactions

}
