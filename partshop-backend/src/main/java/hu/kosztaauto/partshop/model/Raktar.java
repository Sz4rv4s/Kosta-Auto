package hu.kosztaauto.partshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
/**
 * Entity representing a warehouse (Raktar).
 * This class is mapped to the 'raktar' table in the database.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Raktar {
        /** The unique identifier for the warehouse. */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        /** The name of the warehouse. */
        private String nev;
        /** The city where the warehouse is located. */
        private String varos;
        /** The address of the warehouse. */
        private String cim;
        /** The capacity of the warehouse. Provided in pallets. */
        private int kapacitas;
        /** One-to-many relationship with Alkatresz. List of car parts stored in the warehouse. */
        @OneToMany(mappedBy = "raktar", fetch = FetchType.LAZY)
        private List<Alkatresz> alkatreszek;

        public Raktar(Long id, String nev, String varos, String cim, int kapacitas) {
                this.id = id;
                this.nev = nev;
                this.varos = varos;
                this.cim = cim;
                this.kapacitas = kapacitas;
        }
}