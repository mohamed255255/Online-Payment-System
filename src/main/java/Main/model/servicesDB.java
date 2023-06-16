package Main.model;
import javax.persistence.*;



@Entity
@Table
public class servicesDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int SerivceID ;
    private  String service_name ;
    private  String type_of_service ;

    public servicesDB(int id, String service_name, String type_of_service) {
        this.SerivceID = id;
        this.service_name = service_name;
        this.type_of_service = type_of_service;
    }

    public servicesDB() {}

    public void setId(int id) {
        this.SerivceID = id;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public void setType_of_service(String type_of_service) {
        this.type_of_service = type_of_service;
    }

    public int getId() {
        return SerivceID;
    }

    public String getService_name() {
        return service_name;
    }

    public String getType_of_service() {
        return type_of_service;
    }
}
