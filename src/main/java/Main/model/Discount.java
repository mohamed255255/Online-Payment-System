package Main.model;
import jakarta.persistence.*;


@Table
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DiscountID ;
    private String DiscountType;
    private double DiscountPercentage ;
    private String ServiceType ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Service_FK")
    private services service;

    public void setId(int DiscountID) {
        this.DiscountID = DiscountID;
    }

    public int getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(int discountID) {
        DiscountID = discountID;
    }

    public void setDiscountType(String discountType) {
        DiscountType = discountType;
    }

    public double getDiscountPercentage() {
        return DiscountPercentage;
    }


}
