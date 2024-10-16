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
/**
 * Service class responsible for business logic related to warehouses (Raktar).
 */
@Service
public class RaktarService {

    @Autowired
    private RaktarRepository raktarRepository;
    /**
     * Retrieves all warehouses from the database.
     *
     * @return A list of {@link RaktarDTO} representing all warehouses.
     */
    public List<RaktarDTO> getAllWarehouses() {
        return raktarRepository.findAll().stream()
                .map(this::convertToRaktarDTO)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves all warehouses along with the items stored in each warehouse.
     *
     * @return A list of {@link RaktarWithItemsDTO} representing all warehouses with their associated items.
     */
    public List<RaktarWithItemsDTO> getAllItemsByWarehouse() {
        return raktarRepository.findAll().stream()
                .map(this::convertToRaktarWithItemsDTO)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves all items stored in a warehouse by warehouse name (or part of the name).
     *
     * @param name The name or part of the name of the warehouse.
     * @return A list of items in the matching warehouse as {@link RaktarWithItemsDTO}.
     */
    public List<RaktarWithItemsDTO> getItemsByWarehouseName(String name) {
        return raktarRepository.findByNevContainingIgnoreCase(name).stream()
                .map(this::convertToRaktarWithItemsDTO)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves all items stored in a specific warehouse by its ID.
     *
     * @param warehouseId The ID of the warehouse.
     * @return The warehouse and its stored items as {@link RaktarWithItemsDTO}.
     */
    public RaktarWithItemsDTO getItemsByWarehouseId(Long warehouseId) {
        Raktar raktar = raktarRepository.findById(warehouseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Warehouse not found"));

        return convertToRaktarWithItemsDTO(raktar);
    }
    /**
     * Converts a {@link Raktar} entity to a {@link RaktarDTO}.
     *
     * @param raktar The warehouse entity to convert.
     * @return The converted warehouse DTO.
     */
    public RaktarDTO convertToRaktarDTO(Raktar raktar) {
        return new RaktarDTO(
                raktar.getId(),
                raktar.getNev(),
                raktar.getVaros(),
                raktar.getCim(),
                raktar.getKapacitas()
        );
    }
    /**
     * Converts a {@link Raktar} entity to a {@link RaktarWithItemsDTO}, including associated items.
     *
     * @param raktar The warehouse entity to convert.
     * @return The converted warehouse DTO with associated items.
     */
    public RaktarWithItemsDTO convertToRaktarWithItemsDTO(Raktar raktar) {
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