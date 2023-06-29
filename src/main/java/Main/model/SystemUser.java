package Main.model;
import jakarta.persistence.*;


@Entity
@Table
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;
    private String email ;
    private String password ;



    public SystemUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SystemUser() {}

    @Override
    public String toString() {
        return "Systemuser{" +
                "id=" + UserID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public void setId(int id) {
        this.UserID = id;
    }

    public int getId() {
        return UserID;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_fk")
    private wallet wallet;

    public wallet getWallet() {
        return wallet;
    }
}

