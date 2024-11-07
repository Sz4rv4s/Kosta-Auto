using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class WarehouseWithComponentsValidator : AbstractValidator<WarehouseWithComponentsDto>
{
    public WarehouseWithComponentsValidator()
    {
        RuleFor(x => x.Alkatreszek)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező");
    }
}