package hu.kosztaauto.partshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlkatreszDTO {
    private String cikkszam;
    private String megnevezes;
    private String autoTipus;
    private int ar;
}