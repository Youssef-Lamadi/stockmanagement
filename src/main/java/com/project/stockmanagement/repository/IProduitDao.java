package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Achat;
import com.project.stockmanagement.model.entity.Entree;
import com.project.stockmanagement.model.entity.Produit;
import com.project.stockmanagement.model.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IProduitDao extends JpaRepository<Produit,Long> {
    List<Produit> getProduitsByWarehouse(Warehouse p);
    List<Produit> getProduitsByAchat(Achat p);
    List<Produit> getProduitsByEntree(Entree p);
    List<Produit> getProduitsByProduit(Produit p);
    List<Produit> getProduitsByDate(Date p);
    List<Produit> getProduitsByType(String pType);

}
