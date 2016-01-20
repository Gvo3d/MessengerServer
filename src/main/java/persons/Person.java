package persons;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Person")
public class Person {
    private int user_id;
    private String user_login;
    private String password;
    private int user_type;
    private Timestamp user_last_entered;
    private Timestamp created;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Column(name="user_login")
    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    @Column(name="user_type")
    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    @Column(name="user_last_entered")
    public Timestamp getUser_last_entered() {
        return user_last_entered;
    }

    public void setUser_last_entered(Timestamp user_last_entered) {
        this.user_last_entered = user_last_entered;
    }

    @Column(name="created")
    public Timestamp getCreated() {
        return created;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated() {
        this.created = new java.sql.Timestamp(System.currentTimeMillis());
    }
}
