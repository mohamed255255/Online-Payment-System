package Main.model;
import jakarta.persistence.*;
@Entity
@Table
public class services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int SerivceID ;
    private  String servicename;
    private double fees ;

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    private String img_path ;

    private String servicetype ;


    public int getSerivceID() {
        return SerivceID;
    }

    public void setSerivceID(int serivceID) {
        SerivceID = serivceID;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }



    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "services{" +
                "SerivceID=" + SerivceID +
                ", ServiceName='" + servicename + '\'' +
                ", fees=" + fees +
                ", serivceFeesInterval='"  + '\'' +
                ", img_path='" + img_path + '\'' +
                '}';
    }

    public void LowerCaseServiceName(){
        servicename = servicename.toLowerCase();
    }
}
