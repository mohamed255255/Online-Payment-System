package Main.model;
import jakarta.persistence.*;


@Table
@Entity
public class RefundRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RefundRequestID ;
    private  String reason ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Fk")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Transaction_Fk")
    private transaction trans;

    public void setId(int id) {
        this.RefundRequestID = id;
    }

    public int getId() {
        return RefundRequestID;
    }

}
