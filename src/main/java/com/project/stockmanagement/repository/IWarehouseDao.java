package com.project.stockmanagement.repository;

import com.project.stockmanagement.model.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseDao extends JpaRepository<Warehouse,Long> {

    Warehouse getWarehousesByName(String pName);
}
