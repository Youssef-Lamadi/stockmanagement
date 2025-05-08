package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false,name = "typeSource")
    private String typeSource;

    @OneToMany(mappedBy = "source")
    private Set<Entree> entrees;

    public Source(Set<Entree> entrees, String typeSource) {
        this.entrees = entrees;
        this.typeSource = typeSource;
    }

    public Source() {
    }

}
