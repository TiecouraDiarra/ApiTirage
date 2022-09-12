package com.example.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "Postulant")
@Setter
@Getter
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

    public Postulant(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, ListePostulant idlistePostulant) {
        super();
        this.idPostulant = idPostulant;
        this.nomPostulant = nomPostulant;
        this.prenomPostulant = prenomPostulant;
        this.numeroPostulant = numeroPostulant;
        this.emailPostulant = emailPostulant;
        this.idlistePostulant = idlistePostulant;
    }
}
