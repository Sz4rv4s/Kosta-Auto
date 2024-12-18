﻿using hu.Kostaauto.WebUi.Data;
using hu.Kostaauto.WebUi.Data.Dtos;
using Refit;

namespace hu.Kostaauto.WebUi.Services;

public interface IWarehouseService
{
    [Get("/api/getallwarehouses")]
    Task<IEnumerable<WarehouseDto>> GetAllWarehousesAsync();
    
    [Get("/api/getallitemsbywarehouse")]
    Task<IEnumerable<WarehouseWithComponentsDto>> GetAllWarehousesByWarehouseIdAsync();
    
    [Get("/api/getallwarehousesbyitem")]
    Task<IEnumerable<ComponentWithWarehouseDto>> GetAllWarehousesByItemIdAsync();
    
    [Get("/api/getwarehousebyid/{warehouseId}")]
    Task<WarehouseDto> GetWarehouseByIdAsync(long warehouseId);
    
    [Get("/api/getwarehousebyname/{warehouseName}")]
    Task<WarehouseDto> GetWarehouseByNameAsync(string warehouseName);
}