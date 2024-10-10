using hu.Kostaauto.WebUi.Data;
using Refit;

namespace hu.Kostaauto.WebUi.Services;

public interface IWarehouseService
{
    [Get("/api/getallwarehouses")]
    Task<IEnumerable<WarehouseDto>> GetAllWarehousesAsync();
    
    [Get("/api/getallitemsbywarehouse")]
    Task<IEnumerable<WarehouseWithComponentsDto>> GetAllWarehousesByWarehouseIdAsync();
    
    [Get("/api/getallwarehousesbyitem")]
    Task<IEnumerable<WarehouseWithComponentsDto>> GetAllWarehousesByItemIdAsync();
    
    [Get("/api/getwarehousebyid/{warehouseId}")]
    Task<WarehouseWithComponentsDto> GetWarehouseByIdAsync(long warehouseId);
    
    [Get("/api/getwarehousebyname/{warehouseName}")]
    Task<WarehouseWithComponentsDto> GetWarehouseByNameAsync(string warehouseName);
}