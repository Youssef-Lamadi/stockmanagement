package com.project.stockmanagement.service;
import com.project.stockmanagement.model.entity.Warehouse;
import com.project.stockmanagement.repository.IWarehouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseServiceImpl implements  IWarehouseService {

    @Autowired
    private IWarehouseDao warehouseDao;

    @Override
    public List<Warehouse> getAllWarehouses() {
       return warehouseDao.findAll();
    }

    @Override
    public Warehouse getWarehouseById(Long pId) {
        return warehouseDao.getById(pId);
    }

    @Override
    public Warehouse getWarehouseByName(String pName) {
        return warehouseDao.getWarehousesByName(pName);
    }
    @Override
    public void addWarehouse(Warehouse pWarehouse) {
        warehouseDao.save(pWarehouse);
    }

    @Override
    public void deleteWarehouse(Warehouse pWarehouse) {
        warehouseDao.delete(pWarehouse);
    }

    @Override
    public void updateWarehouse(Warehouse pWarehouse) {
        warehouseDao.save(pWarehouse);
    }
}
