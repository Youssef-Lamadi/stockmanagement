package com.project.stockmanagement.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity

public class Warehouse {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "name")
    @NotNull
    private String name;
    @Column(name = "location", nullable = false)
    private String address;
    @Column(name = "code", nullable = false)
    private String code;





}
