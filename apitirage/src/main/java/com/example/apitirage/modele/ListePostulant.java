package com.example.apitirage.modele;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Long dateListePostulant;
    private String libelleListePostulant;
}
