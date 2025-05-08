package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Entree;
import com.project.stockmanagement.model.entity.Produit;
import com.project.stockmanagement.model.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface IEntreeDao extends JpaRepository<Entree,Long> {
    Entree getEntreeById(Long id);
    Entree getEntreeByDateLivraison(Date dateLivraison);
    Entree getEntreeByProduit(Produit produit);
    Entree getEntreeByWarehouse(Warehouse warehouse);
}
