package com.muving.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    private Long roleId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "role")
    private Set<UserRol> userRol = new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRol> getUserRol() {
        return userRol;
    }

    public void setUserRol(Set<UserRol> userRol) {
        this.userRol = userRol;
    }

    public Role() {
    }
}
