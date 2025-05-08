package com.project.stockmanagement.controller;

import com.project.stockmanagement.model.entity.Warehouse;
import com.project.stockmanagement.service.IWarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/warehouse")

public class WarehouseController {


    private final IWarehouseService warehouseRepository;
    public WarehouseController(IWarehouseService warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping("/")
    public String viewWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseRepository.getAllWarehouses());
        return "warehouse";
    }

    @GetMapping("edit/{id}")
    public String viewOneWarehouses(Model model, @PathVariable Long id) {
        model.addAttribute("warehouse", warehouseRepository.getWarehouseById(id));
        return "edit";
    }

    @PostMapping("add")
    public String addWarehouse(@RequestParam String name,
                               @RequestParam String code,
                               @RequestParam String address) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(System.currentTimeMillis());
        warehouse.setName(name);
        warehouse.setCode(code);
        warehouse.setAddress(address);
        warehouseRepository.addWarehouse(warehouse);
        return "redirect:/warehouse/";
    }
    @PostMapping("edit/{id}")
    public String updateWarehouse(@ModelAttribute("warehouse") Warehouse WH ,@PathVariable Long id) {
        WH.setId(id);
        warehouseRepository.updateWarehouse(WH);
        return "redirect:/warehouse/";
    }

    @GetMapping("delete/{id}")
    public String deleteWarehouse(@PathVariable Long id) {
         List<Warehouse> warehouses = warehouseRepository.getAllWarehouses();
         for (Warehouse warehouse : warehouses) {
             if (warehouse.getId().equals(id)) {
                 warehouseRepository.deleteWarehouse(warehouse);
                 break;
             }
         }
        return "redirect:/warehouse/";
    }


}
