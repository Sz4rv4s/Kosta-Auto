package hu.kosztaauto.partshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object for car parts (Alkatresz).
 * This DTO is used to transfer car part information between layers.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlkatreszDTO {
    /** The unique identifier of the car part (cikkszam). */
    private String cikkszam;
    /** The name or description of the car part. */
    private String megnevezes;
    /** The type of car this part is compatible with. */
    private String autoTipus;
    /** The price of the car part. Provided in HUF. */
    private int ar;
}