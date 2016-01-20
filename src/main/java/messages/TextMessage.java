package messages;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Messages")
public class TextMessage {
    private int message_id;
    private String author;
    private String text;
    private Timestamp created;


    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="message_id")
    public int getId() {
        return message_id;
    }

    public void setId(int id) {
        this.message_id = id;
    }

    @Column(name="text")
    public String getText() {
        return text;
    }

    public boolean setText(String text) {
        if (text.length()<65535) {
            this.text = text;
            return true;
        } else {
            this.text = text.substring(0, 65534);
            return true;
        }
    }

    @Column(name="created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
