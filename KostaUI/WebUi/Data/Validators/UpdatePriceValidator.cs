using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class UpdatePriceValidator : AbstractValidator<UpdatePriceDto>
{
    public UpdatePriceValidator()
    {
        RuleFor(x => x.Id)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező");
        
        RuleFor(x => x.NewPrice)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .GreaterThan(0)
            .WithMessage("{PropertyName} nagyobb kell legyen mint 0");
    }
}