package com.example.apitirage.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PostulantTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostulantTS {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulant;
    private String nomPostulant;
    private String prenomPostulant;
    private String numeroPostulant;
    private String emailPostulant;

   @ManyToOne
   @JoinColumn(name = "id_tirage")
   private Tirage tirage;
}
