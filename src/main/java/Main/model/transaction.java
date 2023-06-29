package Main.model;

import jakarta.persistence.*;

@Entity
@Table
 public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID ;
    private  String ServiceType ;
    private  String ServiceName ;
    private  String TransactionType ;
    private double amount ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_fk")
    private SystemUser user;

   public transaction(String ServiceType , String ServiceName , String TransactionType){
       this.ServiceType = ServiceType ;
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
