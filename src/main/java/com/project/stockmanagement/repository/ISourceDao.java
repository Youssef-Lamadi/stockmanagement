package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISourceDao  extends JpaRepository<Produit,Long> {

}
