package Main.model;

import jakarta.persistence.*;

@Entity
@Table
 public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID ;
    private  String ServiceName ;

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }



    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private  String TransactionType ;
    private double amount ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_fk")
    private User user;

   public transaction(String ServiceType , String ServiceName , String TransactionType){
       this.ServiceName = ServiceName ;
       this.TransactionType = TransactionType;
   }
    public transaction(){}
    public void setId(int id) {
        this.transactionID = id;
    }

    public int getId() {
        return transactionID;
    }


}
