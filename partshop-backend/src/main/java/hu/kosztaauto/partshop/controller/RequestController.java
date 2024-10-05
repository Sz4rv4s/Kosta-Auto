package hu.kosztaauto.partshop.controller;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.AlkatreszWithWarehouseDTO;
import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.dto.RaktarWithItemsDTO;
import hu.kosztaauto.partshop.service.AlkatreszService;
import hu.kosztaauto.partshop.service.RaktarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private AlkatreszService alkatreszService;

    @Autowired
    private RaktarService raktarService;

    @GetMapping("/getallitems")
    public List<AlkatreszDTO> getAllItems() {
        return alkatreszService.getAllItems();
    }

    @GetMapping("/getallwarehouses")
    public List<RaktarDTO> getAllWarehouses() {
        return raktarService.getAllWarehouses();
    }

    @GetMapping("/getallitemsbywarehouse")
    public List<RaktarWithItemsDTO> getAllItemsByWarehouse() {
        return raktarService.getAllItemsByWarehouse();
    }

    @GetMapping("/getallwarehousesbyitem")
    public List<AlkatreszWithWarehouseDTO> getAllWarehousesByItem() {
        return alkatreszService.getAllWarehousesByItem();
    }

    @GetMapping("/getitem/{id}")
    public AlkatreszDTO getItemByCikkszam(@PathVariable String id) {
        return alkatreszService.getItemById(id);
    }

    @GetMapping("/search/{name}")
    public List<AlkatreszDTO> searchItemByName(@PathVariable String name) {
        return alkatreszService.searchByName(name);
    }

    @GetMapping("/getwarehousebyid/{warehouseId}")
    public RaktarWithItemsDTO getItemsByWarehouseId(@PathVariable Long warehouseId) {
        return raktarService.getItemsByWarehouseId(warehouseId);
    }

    @GetMapping("/getwarehousebyname/{warehouseName}")
    public List<RaktarWithItemsDTO> getItemsByWarehouseName(@PathVariable String warehouseName) {
        return raktarService.getItemsByWarehouseName(warehouseName);
    }

}