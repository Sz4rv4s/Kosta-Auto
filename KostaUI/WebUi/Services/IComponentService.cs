using hu.Kostaauto.WebUi.Data;
using hu.Kostaauto.WebUi.Data.Dtos;
using Refit;

namespace hu.Kostaauto.WebUi.Services;

public interface IComponentService
{
    [Get("/api/getallitems")]
    Task<IEnumerable<ComponentDto>> GetComponentsAsync();
    
    [Get("/api/search/{name}")]
    Task<ComponentDto> GetComponentByNameAsync(string name);
    
    [Get("/api/getitem/{id}")]
    Task<ComponentDto> GetComponentByIdAsync(string id);
    
    [Post("/api/additem/{warehouseId}")]
    Task AddItemToWarehouseAsync(long warehouseId, ComponentDto item);
    
    [Patch("/api/updateprice")]
    Task UpdatePriceAsync(UpdatePriceDto update);

    [Put("/api/updateitem/{id}")]
    Task UpdateItemAsync(string id, UpdateComponentDto update);
    
    [Delete("/api/deleteitem/{id}")]
    Task DeleteItemAsync(string id);
}