package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Achat;
import com.project.stockmanagement.model.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IAchatDao extends JpaRepository<Achat,Long> {
    Achat getAchatById(Long id);

    Achat getAchatByName(String pName);

    List<Achat> getAchatByProduit(Produit pName);

    Achat getAchatByDate(Date pDate);


}
