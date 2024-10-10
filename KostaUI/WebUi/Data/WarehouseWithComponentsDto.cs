namespace hu.Kostaauto.WebUi.Data;

public class WarehouseWithComponentsDto : WarehouseDto
{
    public IEnumerable<ComponentDto> Components { get; set; }
}