package com.example.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Postulant")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulant;
    private String nomPostulant;
    private String prenomPostulant;
    private String numeroPostulant;
    private String emailPostulant;

    @ManyToOne
    @JoinColumn(name = "id_liste_postulant")
    private ListePostulant idlistePostulant;
}
