package hu.kosztaauto.partshop.controller;

import hu.kosztaauto.partshop.database.Alkatresz;
import hu.kosztaauto.partshop.database.Raktar;
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

    @GetMapping("/getAllParts")
    public List<Alkatresz> getAllParts() {
        return alkatreszService.getAllParts();
    }

    @GetMapping("/getAllWarehouses")
    public List<Raktar> getAllWarehouses() {
        return raktarService.getAllWarehouses();
    }
}
