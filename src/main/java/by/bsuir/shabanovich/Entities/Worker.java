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
    private String name;
    private String surname;
    private Integer active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    public Worker(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        active = 1;
    }

    public Worker() {
    }

    public String getRoleName() {
        if(role.contains(Role.ADMIN)) return "Администратор";
        if(role.contains(Role.LOGIST)) return "Логист";
        if(role.contains(Role.MANAGER)) return "Менеджер";
        if(role.contains(Role.USER)) return "Пользователь";
        return "Пользователь";
    }
}
