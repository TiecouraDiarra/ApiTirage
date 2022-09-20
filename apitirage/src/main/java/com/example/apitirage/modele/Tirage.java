package com.example.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Tirage")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTirage;
    private Date dateTirage;
    private String libelle;
    private Long nombrePostTire;

    @ManyToOne
    @JoinColumn(name = "id_liste_postulant")
    ListePostulant listePostulant;

    /*@OneToMany(mappedBy = "tirage")
    List<PostulantTS> postulantTS = new ArrayList<>();*/
}
