package Main.model;
import javax.persistence.*;


@Entity
@Table

public class SystemUserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;
    private String email ;
    private String password ;

    public SystemUserDB(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SystemUserDB() {

    }

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
}

