package com.example.apitirage.service;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;

import java.util.List;

public interface TirageService {
    /*Iterable<Object[]> TirageSelection();
    public List<Tirage> findAllTirage();*/

    //================METHODE PERMETTANT DE FAIRE LE TIRAGE=========================
    List<Postulant> CreerTirage(Tirage tirage, List<Postulant> listAtrier, Long nbre);

    //================METHODE PERMETTANT DE TROUVER LE TIRAGE PAR LIBELLE=========================
  Tirage trouverTirageParlibelle(String libelle);

    //================METHODE PERMETTANT DE MODIFIER UN TIRAGE=========================
    Tirage modifierTirage(Long idTirage, Tirage tirage);

    Long nombreTotaltirage();

    Long nombreTotaltirageListe(Long IdListePostulant);

    Iterable<Object[]> AfficherTousLesTirages(Long idListePostulant);

    Iterable<Object[]> IdTirageTous(Long idTirage);

    Long nombrePostulantTire(Long idTirage);

    Tirage RetrouverParId(Long idTirage);
}
