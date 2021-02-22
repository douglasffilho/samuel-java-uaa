package br.com.douglasffilho.uaa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private final String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private final String roles; // "ADMINISTRATOR,MANAGER,CUSTOMER"

    public User() {
        this.email = null;
        this.password = null;
        this.roles = null;
    }

    public User(final String email, String password, final String roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }
}
