/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Youcode.OnlineReservation2.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRole;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<User> user = new ArrayList<User>();
    private String role;

    public Role() {
        super();
    }

    public Role(long idRole, List<User> user, String role) {
        this.idRole = idRole;
        this.user = user;
        this.role = role;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
