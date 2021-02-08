package by.feedblog.feedblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    @OneToOne
    private User user;

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
