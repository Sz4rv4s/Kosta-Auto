package hu.kosztaauto.partshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Entity representing a car part (Alkatresz).
 * This class is mapped to the 'alkatresz' table in the database.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alkatresz {
    /** The unique identifier of the car part (cikkszam). */
    @Id
    private String cikkszam;
    /** The name or description of the car part. */
    private String megnevezes;
    /** The type of car this part is compatible with. */
    private String autoTipus;
    /** The price of the car part. Provided in HUF. */
    private int ar;
    /** Foreign key for the associated warehouse. The warehouse where the part is stored. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raktar_id")
    private Raktar raktar;

    public Alkatresz(String cikkszam, String megnevezes, String autoTipus, int ar) {
        this.cikkszam = cikkszam;
        this.megnevezes = megnevezes;
        this.autoTipus = autoTipus;
        this.ar = ar;
    }
}