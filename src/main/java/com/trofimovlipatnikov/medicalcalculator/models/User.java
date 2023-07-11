package com.trofimovlipatnikov.medicalcalculator.models;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "user_id")
    private int id;

    private String username;

    private String email;

    private String password;

    private int region;

    @ManyToOne
    @JoinColumn(name = "fk_role_id")
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
