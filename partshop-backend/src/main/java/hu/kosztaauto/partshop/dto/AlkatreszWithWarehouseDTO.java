package hu.kosztaauto.partshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object that includes car part information along with its associated warehouse.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlkatreszWithWarehouseDTO {
    /** The unique identifier of the car part (cikkszam). */
    private String cikkszam;
    /** The name or description of the car part. */
    private String megnevezes;
    /** The type of car this part is compatible with. */
    private String autoTipus;
    /** The price of the car part. Provided in HUF. */
    private int ar;
    /** The warehouse where the part is stored. */
    private RaktarDTO raktar;
}