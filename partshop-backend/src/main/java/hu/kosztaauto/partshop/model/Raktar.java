package hu.kosztaauto.partshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Raktar {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nev;
        private String varos;
        private String cim;
        private int kapacitas;

        @OneToMany(mappedBy = "raktar", fetch = FetchType.LAZY)
        private List<Alkatresz> alkatreszek;
}