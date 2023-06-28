package Main.model;
import jakarta.persistence.*;


@Table
@Entity
public class RefundRequestDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RefundRequestID ;
    private  String reason ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Fk")
    private SystemUserDB user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Transaction_Fk")
    private transactionDB trans;

    public void setId(int id) {
        this.RefundRequestID = id;
    }

    public int getId() {
        return RefundRequestID;
    }

}
