package Main.model;
import jakarta.persistence.*;


@Table
@Entity
public class DiscountDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DiscountID ;
    private String DiscountType;
    private double DiscountPercentage ;
    private String ServiceType ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Service_FK")
    private servicesDB service;

    public void setId(int DiscountID) {
        this.DiscountID = DiscountID;
    }

    public int getId() {
        return DiscountID;
    }
}
