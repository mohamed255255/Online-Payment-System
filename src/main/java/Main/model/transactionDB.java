package Main.model;
import javax.persistence.*;

@Entity
@Table
 public class transactionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID ;
    private  String type_of_service ;
    private  String service_name ;
    private  String TransactionType ;
    private  int UserID ;


    public void setId(int id) {
        this.transactionID = id;
    }

    public int getId() {
        return transactionID;
    }


}
