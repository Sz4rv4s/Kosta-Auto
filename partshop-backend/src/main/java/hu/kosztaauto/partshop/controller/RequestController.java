package hu.kosztaauto.partshop.controller;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.AlkatreszWithWarehouseDTO;
import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.dto.RaktarWithItemsDTO;
import hu.kosztaauto.partshop.service.AlkatreszService;
import hu.kosztaauto.partshop.service.RaktarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private AlkatreszService alkatreszService;

    @Autowired
    private RaktarService raktarService;

    @GetMapping("/getAllItems")
    public List<AlkatreszDTO> getAllItems() {
        return alkatreszService.getAllItems();
    }

    @GetMapping("/getAllWarehouses")
    public List<RaktarDTO> getAllWarehouses() {
        return raktarService.getAllWarehouses();
    }

    @GetMapping("/getAllItemsByWarehouse")
    public List<RaktarWithItemsDTO> getAllItemsByWarehouse() {
        return raktarService.getAllItemsByWarehouse();
    }

    @GetMapping("/getAllWarehousesByItem")
    public List<AlkatreszWithWarehouseDTO> getAllWarehousesByItem() {
        return alkatreszService.getAllWarehousesByItem();
    }
}