package hu.kosztaauto.partshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAlkatreszDTO {
    private String megnevezes;
    private String autoTipus;
    private int ar;
    private Long raktarId;
}