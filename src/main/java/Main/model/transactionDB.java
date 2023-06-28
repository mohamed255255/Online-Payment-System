package Main.model;
import jakarta.persistence.*;

@Entity
@Table
 public class transactionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID ;
    private  String ServiceType ;
    private  String ServiceName ;
    private  String TransactionType ;
    private double amount ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private SystemUserDB user;


    public void setId(int id) {
        this.transactionID = id;
    }

    public int getId() {
        return transactionID;
    }


}
