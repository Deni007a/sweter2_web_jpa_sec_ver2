package sweter2_web_jpa_sec.sweter2_web_jpa_sec.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "")
   // @Size(min = 2, max = 25, message = "неправильная длина")
    private String text;


    @NotEmpty(message = "пустой")
    private String tag;

    // constructors
    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Message() {
    }
//Get Set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
