package hu.kosztaauto.partshop.database;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alkatresz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alkatresz {

    @Id
    @Column(name = "cikkszam")
    private String cikkszam;

    @Column(name = "megnevezes")
    private String megnevezes;

    @Column(name = "auto_tipus")
    private String autoTipus;

    @Column(name = "ar")
    private int ar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raktar_id", referencedColumnName = "id")
    private Raktar raktar;
}
