package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameProduit")
    @NotNull
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @Column(name = "quantite")
    private int quantite;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "produit_achat",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "achat_id")
    )
    @NotNull
    private Set<Achat> achats;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, targetEntity = Entree.class)
    private Set<Entree> entrees;

    public Produit(String name, int quantite, String type, String description,Set<Achat> achats, Set<Entree> entrees)
    {
        this.entrees = entrees;
        this.achats = achats;
        this.name = name;
        this.quantite = quantite;
        this.type = type;
        this.description = description;
    }

    public Produit() {
    }

}
