package hu.kosztaauto.partshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaktarDTO {
    private Long id;
    private String nev;
    private String varos;
    private String cim;
    private int kapacitas;
}