package ch.swindiatours.Entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@NamedQueries({
        @NamedQuery(name = "user.getAll", query = "SELECT user FROM User user"),
        @NamedQuery(name = "user.getById", query = "SELECT user FROM User user WHERE user.id = :userId"),
        @NamedQuery(name = "user.getByName", query = "SELECT user FROM User user WHERE user.name = :name"),
        @NamedQuery(name = "user.getByPassword", query = "SELECT user FROM User user WHERE user.password = :password"),
        @NamedQuery(name = "user.getByEmail", query = "SELECT user FROM User user WHERE user.email = :email")
})
@Entity
public class User {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 450)
    private String name;
    @Basic
    @Column(name = "email", nullable = false)
    private String email;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }


    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
}
