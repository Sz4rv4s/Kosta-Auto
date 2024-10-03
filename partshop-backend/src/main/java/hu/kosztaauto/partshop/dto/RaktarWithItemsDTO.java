package hu.kosztaauto.partshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaktarWithItemsDTO {
    private Long id;
    private String nev;
    private String varos;
    private String cim;
    private int kapacitas;
    private List<AlkatreszDTO> alkatreszek;
}