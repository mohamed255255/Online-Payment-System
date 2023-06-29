package Main.model;
import jakarta.persistence.*;
@Entity
@Table
public class services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int SerivceID ;
    private  String ServiceName;
    private  String ServiceType ;
    private double serivcePrice ;

    public services(int id, String ServiceName, String type_of_service) {
        this.SerivceID = id;
        this.ServiceName = ServiceName;
        this.ServiceType = type_of_service;
    }

    public services() {}


    public int getSerivceID() {
        return SerivceID;
    }

    public void setSerivceID(int serivceID) {
        SerivceID = serivceID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public double getSerivcePrice() {
        return serivcePrice;
    }

}
