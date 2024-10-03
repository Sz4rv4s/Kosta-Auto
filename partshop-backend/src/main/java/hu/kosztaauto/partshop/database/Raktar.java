package hu.kosztaauto.partshop.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "raktar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Raktar {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "nev")
        private String nev;

        @Column(name = "varos")
        private String varos;

        @Column(name = "cim")
        private String cim;

        @Column(name = "kapacitas")
        private int kapacitas;

        @JsonIgnore
        @OneToMany(mappedBy = "raktar", cascade = CascadeType.ALL)
        private List<Alkatresz> alkatreszek;
}