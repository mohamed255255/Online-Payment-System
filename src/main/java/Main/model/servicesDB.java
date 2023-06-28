package Main.model;
import jakarta.persistence.*;
@Entity
@Table
public class servicesDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int SerivceID ;
    private  String ServiceName;
    private  String ServiceType ;

    public servicesDB(int id, String ServiceName, String type_of_service) {
        this.SerivceID = id;
        this.ServiceName = ServiceName;
        this.ServiceType = type_of_service;
    }

    public servicesDB() {}

    public void setId(int id) {
        this.SerivceID = id;
    }

    public void setServiceName(String serviceName) {
        this.ServiceName = serviceName;
    }

    public void setType_of_service(String type_of_service) {
        this.ServiceType = type_of_service;
    }

    public int getId() {
        return SerivceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getType_of_service() {
        return ServiceType;
    }
}
