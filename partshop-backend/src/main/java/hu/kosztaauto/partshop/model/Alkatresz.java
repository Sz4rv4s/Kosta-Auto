package hu.kosztaauto.partshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alkatresz {
    @Id
    private String cikkszam;

    private String megnevezes;
    private String autoTipus;
    private int ar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raktar_id")
    private Raktar raktar;
}