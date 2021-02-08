package by.feedblog.feedblogapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @OneToOne
    private Category category;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comment;

    private boolean isChecked = false;
    private long countViews = 0;
    private long likes = 0;

    public Post(String title, String description, Category category, User user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    public Post(String title, String description, List<Tag> tags, Category category, User user) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.category = category;
        this.user = user;
    }
}
