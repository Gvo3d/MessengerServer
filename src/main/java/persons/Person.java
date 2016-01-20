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

    public boolean isNotNull(){
        if (user_id==0) return false;
        if (user_login==null) return false;
        if (password==null) return false;
        if (user_type==0) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getUser_id() != person.getUser_id()) return false;
        if (getUser_type() != person.getUser_type()) return false;
        if (getUser_login() != null ? !getUser_login().equals(person.getUser_login()) : person.getUser_login() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(person.getPassword()) : person.getPassword() != null)
            return false;
        if (!getUser_last_entered().equals(person.getUser_last_entered())) return false;
        return getCreated() != null ? getCreated().equals(person.getCreated()) : person.getCreated() == null;
    }

    @Override
    public int hashCode() {
        int result = getUser_id();
        result = 31 * result + (getUser_login() != null ? getUser_login().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getUser_type();
        result = 31 * result + getUser_last_entered().hashCode();
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        return result;
    }
}
