package com.example.apitirage.modele;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ListePostulant")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListePostulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListePostulant;
    private Date dateListePostulant;
    private String libelle;
}
