package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String roleName;


    public Role() {
    }


    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
