using FluentValidation;
using hu.Kostaauto.WebUi.Data.Dtos;

namespace hu.Kostaauto.WebUi.Data.Validators;

public class UpdateComponentValidator : AbstractValidator<UpdateComponentDto>
{
    public UpdateComponentValidator()
    {
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
        
        RuleFor(x => x.RaktarId)
            .NotEmpty()
            .WithMessage("{PropertyName} megadása kötelező")
            .GreaterThan(0)
            .WithMessage("{PropertyName} nagyobb kell legyen mint 0");
    }
}