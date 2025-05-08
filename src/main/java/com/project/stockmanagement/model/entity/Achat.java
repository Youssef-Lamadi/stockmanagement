package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="achat")
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateAchat")
    private Date dateAchat;

    @ManyToMany(mappedBy = "achats")
    @NotNull
    private Set<Entree> entrees;

    @ManyToMany(mappedBy = "achats")
    @NotNull
    private Set<Produit> produits;

    public Achat(Date dateAchat, Set<Entree> entrees, Set<Produit> produits) {
        this.dateAchat = dateAchat;
        this.entrees = entrees;
        this.produits = produits;
    }

    public Achat() {
    }
}





























