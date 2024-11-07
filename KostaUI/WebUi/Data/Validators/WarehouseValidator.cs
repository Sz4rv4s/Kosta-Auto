using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class WarehouseValidator : AbstractValidator<WarehouseDto>
{
    public WarehouseValidator()
    {
        RuleFor(x => x.Id)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .GreaterThan(0)
            .WithMessage("{PropertyName} nagyobb kell legyen mint 0");
        
        RuleFor(x => x.Nev)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(50)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.Varos)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(30)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.Cim)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(60)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.Kapacitas)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .GreaterThan(0)
            .WithMessage("{PropertyName} nagyobb kell legyen mint 0");
    }
}