package com.example.VaschStore.Persons;

import com.example.VaschStore.Roles.Role;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private char isBanned;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public Person() {
    }

    public Person(String name, String email, String password, char isBanned, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isBanned = isBanned;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char isBanned() {
        return isBanned;
    }

    public void setBanned(char banned) {
        isBanned = banned;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isBanned=" + isBanned +
                ", roleId=" + role +
                '}';
    }
}
