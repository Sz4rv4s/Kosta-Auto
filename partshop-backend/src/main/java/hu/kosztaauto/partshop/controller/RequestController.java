package hu.kosztaauto.partshop.controller;

import hu.kosztaauto.partshop.dto.*;
import hu.kosztaauto.partshop.service.AlkatreszService;
import hu.kosztaauto.partshop.service.RaktarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
/**
 * Rest controller providing API endpoints for managing car parts and warehouses.
 */
@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private AlkatreszService alkatreszService;

    @Autowired
    private RaktarService raktarService;
    /**
     * Retrieves a list of all car parts.
     *
     * @return List of all car parts as {@link AlkatreszDTO}.
     */
    @GetMapping("/getallitems")
    public List<AlkatreszDTO> getAllItems() {
        return alkatreszService.getAllItems();
    }
    /**
     * Retrieves a list of all warehouses.
     *
     * @return List of all warehouses as {@link RaktarDTO}.
     */
    @GetMapping("/getallwarehouses")
    public List<RaktarDTO> getAllWarehouses() {
        return raktarService.getAllWarehouses();
    }
    /**
     * Retrieves a list of all warehouses with their associated items.
     *
     * @return List of warehouses and their items as {@link RaktarWithItemsDTO}.
     */
    @GetMapping("/getallitemsbywarehouse")
    public List<RaktarWithItemsDTO> getAllItemsByWarehouse() {
        return raktarService.getAllItemsByWarehouse();
    }
    /**
     * Retrieves all warehouses where a particular car part is stored.
     *
     * @return List of car parts along with the warehouses they are stored in as {@link AlkatreszWithWarehouseDTO}.
     */
    @GetMapping("/getallwarehousesbyitem")
    public List<AlkatreszWithWarehouseDTO> getAllWarehousesByItem() {
        return alkatreszService.getAllWarehousesByItem();
    }
    /**
     * Retrieves a specific car part by its unique ID (cikkszam).
     *
     * @param id The unique identifier (cikkszam) of the car part.
     * @return The car part details as {@link AlkatreszDTO}.
     */
    @GetMapping("/getitem/{id}")
    public AlkatreszDTO getItemByCikkszam(@PathVariable String id) {
        return alkatreszService.getItemById(id);
    }
    /**
     * Searches for car parts by name or part of the name (case-insensitive).
     *
     * @param name The name or part of the name of the car part.
     * @return List of matching car parts as {@link AlkatreszDTO}.
     */
    @GetMapping("/search/{name}")
    public List<AlkatreszDTO> searchItemByName(@PathVariable String name) {
        return alkatreszService.searchByName(name);
    }
    /**
     * Retrieves all items stored in a specific warehouse by its ID.
     *
     * @param warehouseId The ID of the warehouse.
     * @return List of items stored in the warehouse as {@link RaktarWithItemsDTO}.
     */
    @GetMapping("/getwarehousebyid/{warehouseId}")
    public RaktarWithItemsDTO getItemsByWarehouseId(@PathVariable Long warehouseId) {
        return raktarService.getItemsByWarehouseId(warehouseId);
    }
    /**
     * Retrieves all items stored in a specific warehouse by its name (or part of the name).
     *
     * @param warehouseName The name or part of the name of the warehouse.
     * @return List of items stored in the matching warehouse as {@link RaktarWithItemsDTO}.
     */
    @GetMapping("/getwarehousebyname/{warehouseName}")
    public List<RaktarWithItemsDTO> getItemsByWarehouseName(@PathVariable String warehouseName) {
        return raktarService.getItemsByWarehouseName(warehouseName);
    }
    /**
     * Adds a new car part to the database and associates it with a specific warehouse.
     *
     * @param alkatreszDTO The car part details to be added.
     * @param warehouseId  The ID of the warehouse where the part will be stored.
     * @return The newly added car part as {@link AlkatreszDTO}.
     */
    @PostMapping("/additem/{warehouseId}")
    public AlkatreszDTO addItem(@RequestBody AlkatreszDTO alkatreszDTO, @PathVariable Long warehouseId) {
        return alkatreszService.addItem(alkatreszDTO, warehouseId);
    }
    /**
     * Updates the price of an item identified by its ID.
     *
     * @param updatePriceDTO DTO containing the item ID and the new price.
     * @return ApiResponseDTO containing success or failure message.
     */
    @PutMapping("/updateprice")
    public ApiResponseDTO updatePrice(@RequestBody UpdatePriceDTO updatePriceDTO) {
        try {
            alkatreszService.updateItemPrice(updatePriceDTO.getId(), updatePriceDTO.getNewPrice());
            return new ApiResponseDTO("Price updated successfully.");
        } catch (ResponseStatusException e) {
            return new ApiResponseDTO("Failed to update price: " + e.getReason());
        }
    }
    /**
     * Updates all fields of an item except its ID.
     *
     * @param id The ID of the item to update.
     * @param updateAlkatreszDTO The updated data for the item.
     * @return ApiResponseDTO containing success or failure message.
     */
    @PutMapping("/updateitem/{id}")
    public ApiResponseDTO updateItem(
            @PathVariable String id,
            @RequestBody UpdateAlkatreszDTO updateAlkatreszDTO) {
        try {
            alkatreszService.updateItem(id, updateAlkatreszDTO);
            return new ApiResponseDTO("Item updated successfully.");
        } catch (ResponseStatusException e) {
            return new ApiResponseDTO("Failed to update item: " + e.getReason());
        }
    }
}