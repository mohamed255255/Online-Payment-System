package Main.model;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;
    private String email ;
    private String password ;

    private String phonenumber;

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", wallet=" + wallet +
                '}';
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setWallet(Main.model.wallet wallet) {
        this.wallet = wallet;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_fk")
    private wallet wallet;

    public wallet getWallet() {
        return wallet;
    }
}

