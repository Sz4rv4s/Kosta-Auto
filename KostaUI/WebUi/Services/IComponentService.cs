using hu.Kostaauto.WebUi.Data;
using Refit;

namespace hu.Kostaauto.WebUi.Services;

public interface IComponentService
{
    [Get("/api/getallitems")]
    Task<IEnumerable<ComponentDto>> GetComponentsAsync();
    
    [Get("/api/search/{name}")]
    Task<ComponentDto> GetComponentByNameAsync(string name);
    
    [Get("/api/getitem/{id}")]
    Task<ComponentDto> GetComponentByIdAsync(int id);
    
    [Post("/api/additem/{warehouseId}")]
    Task AddItemToWarehouseAsync(int warehouseId, ComponentDto item);
    
    [Put("/api/updateprice")]
    Task UpdatePriceAsync(UpdatePriceDto update);

    [Put("/api/updateitem/{id}")]
    Task UpdateItemAsync(string id, UpdateComponentDto update);
}