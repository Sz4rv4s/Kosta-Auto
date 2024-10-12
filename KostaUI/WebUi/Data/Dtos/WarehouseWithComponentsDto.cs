namespace hu.Kostaauto.WebUi.Data.Dtos;

public class WarehouseWithComponentsDto : WarehouseDto
{
    public IEnumerable<ComponentDto> Alkatreszek { get; set; }
}