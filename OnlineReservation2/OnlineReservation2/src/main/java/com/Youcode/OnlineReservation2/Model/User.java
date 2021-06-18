/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Youcode.OnlineReservation2.Model;
import javax.persistence.*;


/**
 *
 * @author Admin
 */
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="identifiant")
    private long id;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "identifiant_Role")
    private Role role;

    @Column(name="fullName")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="verification")
    private Boolean Verification;

    public User() {
        super();
    }
    
    public User(long id, Role role, String fullName, String email, String password, Boolean Verification) {
        super();
        this.id = id;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.Verification = Verification;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Boolean getVerification() {
        return Verification;
    }

    public void setVerification(Boolean verification) {
        Verification = verification;
    }
}
