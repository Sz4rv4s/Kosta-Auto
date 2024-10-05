package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.dto.RaktarWithItemsDTO;
import hu.kosztaauto.partshop.model.Raktar;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaktarService {

    @Autowired
    private RaktarRepository raktarRepository;

    public List<RaktarDTO> getAllWarehouses() {
        return raktarRepository.findAll().stream()
                .map(this::convertToRaktarDTO)
                .collect(Collectors.toList());
    }

    public List<RaktarWithItemsDTO> getAllItemsByWarehouse() {
        return raktarRepository.findAll().stream()
                .map(this::convertToRaktarWithItemsDTO)
                .collect(Collectors.toList());
    }

    public List<RaktarWithItemsDTO> getItemsByWarehouseName(String name) {
        return raktarRepository.findByNevContainingIgnoreCase(name).stream()
                .map(this::convertToRaktarWithItemsDTO)
                .collect(Collectors.toList());
    }

    public RaktarWithItemsDTO getItemsByWarehouseId(Long warehouseId) {
        Raktar raktar = raktarRepository.findById(warehouseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Warehouse not found"));

        return convertToRaktarWithItemsDTO(raktar);
    }

    private RaktarDTO convertToRaktarDTO(Raktar raktar) {
        return new RaktarDTO(
                raktar.getId(),
                raktar.getNev(),
                raktar.getVaros(),
                raktar.getCim(),
                raktar.getKapacitas()
        );
    }

    private RaktarWithItemsDTO convertToRaktarWithItemsDTO(Raktar raktar) {
        List<AlkatreszDTO> alkatreszek = raktar.getAlkatreszek().stream()
                .map(alkatresz -> new AlkatreszDTO(
                        alkatresz.getCikkszam(),
                        alkatresz.getMegnevezes(),
                        alkatresz.getAutoTipus(),
                        alkatresz.getAr()
                ))
                .collect(Collectors.toList());

        return new RaktarWithItemsDTO(
                raktar.getId(),
                raktar.getNev(),
                raktar.getVaros(),
                raktar.getCim(),
                raktar.getKapacitas(),
                alkatreszek
        );
    }
}