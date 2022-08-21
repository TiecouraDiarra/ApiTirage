package com.example.apitirage.service;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;

import java.util.List;

public interface TirageService {
    /*Iterable<Object[]> TirageSelection();
    public List<Tirage> findAllTirage();*/

    List<Postulant> CreerTirage(Tirage tirage, List<Postulant> listAtrier, Long nbre);

  Tirage trouverTirageParlibelle(String libelle);

    Tirage modifierTirage(Long idTirage, Tirage tirage);
}
