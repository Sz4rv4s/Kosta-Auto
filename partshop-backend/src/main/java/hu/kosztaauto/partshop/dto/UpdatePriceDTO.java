package hu.kosztaauto.partshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePriceDTO {

    private String id;
    private int newPrice;

}
