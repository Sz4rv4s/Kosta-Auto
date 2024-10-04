package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.AlkatreszWithWarehouseDTO;
import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.model.Alkatresz;
import hu.kosztaauto.partshop.repository.AlkatreszRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlkatreszService {

    @Autowired
    private AlkatreszRepository alkatreszRepository;

    public List<AlkatreszDTO> getAllItems() {
        return alkatreszRepository.findAll().stream()
                .map(this::convertToAlkatreszDTO)
                .collect(Collectors.toList());
    }

    public List<AlkatreszWithWarehouseDTO> getAllWarehousesByItem() {
        return alkatreszRepository.findAll().stream()
                .map(this::convertToAlkatreszWithWarehouseDTO)
                .collect(Collectors.toList());
    }

    public AlkatreszDTO getItemById(String id) {
        return alkatreszRepository.findById(id)
                .map(this::convertToAlkatreszDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
    }

    public List<AlkatreszDTO> searchByName(String name) {
        return alkatreszRepository.findByMegnevezesContainingIgnoreCase(name).stream()
                .map(this::convertToAlkatreszDTO)
                .collect(Collectors.toList());
    }

    private AlkatreszDTO convertToAlkatreszDTO(Alkatresz alkatresz) {
        return new AlkatreszDTO(
                alkatresz.getCikkszam(),
                alkatresz.getMegnevezes(),
                alkatresz.getAutoTipus(),
                alkatresz.getAr()
        );
    }

    private AlkatreszWithWarehouseDTO convertToAlkatreszWithWarehouseDTO(Alkatresz alkatresz) {
        RaktarDTO raktarDTO = new RaktarDTO(
                alkatresz.getRaktar().getId(),
                alkatresz.getRaktar().getNev(),
                alkatresz.getRaktar().getVaros(),
                alkatresz.getRaktar().getCim(),
                alkatresz.getRaktar().getKapacitas()
        );

        return new AlkatreszWithWarehouseDTO(
                alkatresz.getCikkszam(),
                alkatresz.getMegnevezes(),
                alkatresz.getAutoTipus(),
                alkatresz.getAr(),
                raktarDTO
        );
    }
}