package Main.model;
import javax.persistence.*;

@Table
@Entity
public class RefundRequestDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RefundRequestID ;
    private int UserID ;
    private  String type_of_service ;
    private  String service_name ;
    private  String reason ;
    private  String amount ;

    public void setId(int id) {
        this.RefundRequestID = id;
    }

    public int getId() {
        return RefundRequestID;
    }

}
