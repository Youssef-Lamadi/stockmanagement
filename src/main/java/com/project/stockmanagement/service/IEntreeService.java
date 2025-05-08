package com.project.stockmanagement.service;

import com.project.stockmanagement.model.entity.Entree;
import com.project.stockmanagement.model.entity.Produit;

import java.util.Date;
import java.util.List;

public interface IEntreeService {

    public List<Entree> getAllEntrees() ;
    public List<Entree> getAllEntreesByProduit(Produit pName);
    public List<Entree> getAllEntreesByDate(Date pDate);
    public List<Entree> getAllEntreesByDateLivraison(Date pDate);

}
