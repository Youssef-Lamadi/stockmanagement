package com.project.stockmanagement.service;

import com.project.stockmanagement.model.entity.Warehouse;

import java.util.List;

public interface IWarehouseService {
    public List<Warehouse> getAllWarehouses() ;
    public  void addWarehouse(Warehouse pWarehouse);
    public void deleteWarehouse(Warehouse pWarehouse);
    public void updateWarehouse(Warehouse pWarehouse);
    public Warehouse getWarehouseById(Long pId);
    public Warehouse getWarehouseByName(String pName);
}
