package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    public Worker(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Worker() {
    }
}
