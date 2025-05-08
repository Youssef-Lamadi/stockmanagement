package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "entree")
public class Entree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateLivraison")
    @NotNull
    private Date dateLivraison;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Achat.class,mappedBy = "achat")
    @JoinTable(
            name = "entree_achat",
            joinColumns = @JoinColumn(name = "entree_id"),
            inverseJoinColumns = @JoinColumn(name = "achat_id")
    )
    @NotNull
    private Set<Achat> achats;


    @ManyToOne()
    @JoinColumn(name = "produit")
    @NotNull
    private Produit produit;

    @Column(name = "unit")
    private String unit;

    @Column(name = "quantite")
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "source")
    private Source source;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;

    @Column(name = "rmq")
    private String rmq;

    public Entree(Date dateLivraison, Set<Achat> Achat,
                  Produit produit, String unit,
                  Integer quantite, Source source,
                  Warehouse warehouse, String rmq) {
        this.dateLivraison = dateLivraison;
        this.achats = Achat;
        this.produit = produit;
        this.unit = unit;
        this.quantite = quantite;
        this.source = source;
        this.warehouse = warehouse;
        this.rmq = rmq;
    }

    public Entree() {
    }

}
