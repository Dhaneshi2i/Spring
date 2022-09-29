package com.ideas2it.entity;

import javax.persistence.*;
@NamedQueries(
        {
        @NamedQuery(
                name = "findUser",
                query = "from Login where user = :user AND password = :password"
        )
}
)
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;
    private String password;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
