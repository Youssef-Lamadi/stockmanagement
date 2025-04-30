package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import java.util.*;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    private String firstName ;

    private String lastName;

/*    @Column(unique = true)
    private String cin;*/

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, targetEntity = UserAccount.class)
    private Set<UserAccount> accounts;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<UserAccount> accounts) {
        this.accounts = accounts;
    }

}