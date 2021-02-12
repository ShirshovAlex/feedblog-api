package by.feedblog.feedblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String login;

    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String password;


    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
