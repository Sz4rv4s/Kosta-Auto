package hu.kosztaauto.partshop.service;

import hu.kosztaauto.partshop.dto.AlkatreszDTO;
import hu.kosztaauto.partshop.dto.AlkatreszWithWarehouseDTO;
import hu.kosztaauto.partshop.dto.RaktarDTO;
import hu.kosztaauto.partshop.model.Alkatresz;
import hu.kosztaauto.partshop.model.Raktar;
import hu.kosztaauto.partshop.repository.AlkatreszRepository;
import hu.kosztaauto.partshop.repository.RaktarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Service layer handling business logic related to car parts.
 */
@Service
public class AlkatreszService {

    @Autowired
    private AlkatreszRepository alkatreszRepository;

    @Autowired
    private RaktarRepository raktarRepository;
    /**
     * Retrieves all car parts from the database.
     *
     * @return List of all car parts as {@link AlkatreszDTO}.
     */
    public List<AlkatreszDTO> getAllItems() {
        return alkatreszRepository.findAll().stream()
                .map(this::convertToAlkatreszDTO)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves all warehouses where each car part is stored.
     *
     * @return List of car parts with their associated warehouses as {@link AlkatreszWithWarehouseDTO}.
     */
    public List<AlkatreszWithWarehouseDTO> getAllWarehousesByItem() {
        return alkatreszRepository.findAll().stream()
                .map(this::convertToAlkatreszWithWarehouseDTO)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves a specific car part by its ID (cikkszam).
     *
     * @param id The unique ID of the car part.
     * @return The car part details as {@link AlkatreszDTO}.
     * @throws ResponseStatusException if the item is not found.
     */
    public AlkatreszDTO getItemById(String id) {
        return alkatreszRepository.findById(id)
                .map(this::convertToAlkatreszDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
    }
    /**
     * Searches for car parts by name (case-insensitive).
     *
     * @param name The name or part of the name to search for.
     * @return List of matching car parts as {@link AlkatreszDTO}.
     */
    public List<AlkatreszDTO> searchByName(String name) {
        return alkatreszRepository.findByMegnevezesContainingIgnoreCase(name).stream()
                .map(this::convertToAlkatreszDTO)
                .collect(Collectors.toList());
    }
    /**
     * Adds a new car part to the database and associates it with a specific warehouse.
     *
     * @param alkatreszDTO The details of the car part to add.
     * @param raktarId     The ID of the warehouse where the part will be stored.
     * @return The added car part as {@link AlkatreszDTO}.
     * @throws ResponseStatusException if the warehouse is not found.
     */
    public AlkatreszDTO addItem(AlkatreszDTO alkatreszDTO, Long raktarId) {

        Raktar raktar = raktarRepository.findById(raktarId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Warehouse not found"));

        Alkatresz alkatresz = new Alkatresz();
        alkatresz.setCikkszam(alkatreszDTO.getCikkszam());
        alkatresz.setMegnevezes(alkatreszDTO.getMegnevezes());
        alkatresz.setAutoTipus(alkatreszDTO.getAutoTipus());
        alkatresz.setAr(alkatreszDTO.getAr());
        alkatresz.setRaktar(raktar);

        Alkatresz savedAlkatresz = alkatreszRepository.save(alkatresz);

        return convertToAlkatreszDTO(savedAlkatresz);
    }
    /**
     * Updates the price of an item identified by its cikkszam.
     *
     * @param id The ID of the item.
     * @param newPrice The new price to set for the item.
     * @throws ResponseStatusException if the item is not found.
     */
    public void updateItemPrice(String id, int newPrice) {
        Alkatresz alkatresz = alkatreszRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        alkatresz.setAr(newPrice);
        alkatreszRepository.save(alkatresz);
    }
    /**
     * Converts an {@link Alkatresz} entity to a {@link AlkatreszDTO}.
     *
     * @param alkatresz The car part entity to convert.
     * @return The converted car part DTO.
     */
    private AlkatreszDTO convertToAlkatreszDTO(Alkatresz alkatresz) {
        return new AlkatreszDTO(
                alkatresz.getCikkszam(),
                alkatresz.getMegnevezes(),
                alkatresz.getAutoTipus(),
                alkatresz.getAr()
        );
    }
    /**
     * Converts an {@link Alkatresz} entity to an {@link AlkatreszWithWarehouseDTO}, including warehouse details.
     *
     * @param alkatresz The car part entity to convert.
     * @return The converted car part DTO with associated warehouse information.
     */
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