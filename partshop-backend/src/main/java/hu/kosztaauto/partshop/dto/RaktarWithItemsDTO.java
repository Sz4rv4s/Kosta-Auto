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
    /** The unique identifier for the warehouse. */
    private Long id;
    /** The name of the warehouse. */
    private String nev;
    /** The city where the warehouse is located. */
    private String varos;
    /** The address of the warehouse. */
    private String cim;
    /** The capacity of the warehouse. Provided in pallets. */
    private int kapacitas;
    /** List of car parts stored in the warehouse. */
    private List<AlkatreszDTO> alkatreszek;
}