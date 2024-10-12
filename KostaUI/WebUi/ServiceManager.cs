using hu.Kostaauto.WebUi.Services;
using Refit;

namespace hu.Kostaauto.WebUi;

public static class ServiceManager
{
    public static IServiceCollection AddWebuiServices(this IServiceCollection service)
    {
        var uri = new Uri("http://localhost:8080/");
        
        var settings = new RefitSettings()
        {
            ContentSerializer = new SystemTextJsonContentSerializer(),
        };

        service.AddRefitClient<IComponentService>(settings)
            .ConfigureHttpClient(c => c.BaseAddress = uri);

        service.AddRefitClient<IWarehouseService>(settings)
            .ConfigureHttpClient(c => c.BaseAddress = uri);
        
        return service;
    }
}