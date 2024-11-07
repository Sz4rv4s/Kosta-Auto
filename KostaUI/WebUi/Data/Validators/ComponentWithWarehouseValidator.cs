using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class ComponentWithWarehouseValidator : AbstractValidator<ComponentWithWarehouseDto>
{
    public ComponentWithWarehouseValidator()
    {
        RuleFor(x => x.Raktar)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező");
    }
}