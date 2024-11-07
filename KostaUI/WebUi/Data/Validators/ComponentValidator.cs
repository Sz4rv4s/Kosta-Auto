using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class ComponentValidator : AbstractValidator<ComponentDto>
{
    public ComponentValidator()
    {
        RuleFor(x => x.Cikkszam)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(15)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.Megnevezes)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(60)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.AutoTipus)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .MaximumLength(30)
            .WithMessage("{PropertyName} maximum hossza {MaxLength}");
        
        RuleFor(x => x.Ar)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .GreaterThan(0)
            .WithMessage("{PropertyName} nagyobb kell legyen mint 0");
    }
}