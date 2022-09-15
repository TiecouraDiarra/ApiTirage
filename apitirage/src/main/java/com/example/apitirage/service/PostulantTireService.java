package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.PostulantTS;

import java.util.List;

public interface PostulantTireService {

    //================METHODE PERMETTANT DE RECUPERER LES DONNEES DANS LE FICHIER ET LES ENREGISTRER=========================
    int creer(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, Long id_tirage);

    //================METHODE PERMETTANT D'AFFICHER TOUS LES POSTULANTS TIRES=========================
    List<PostulantTS> AfficherTousLesPostulantsTire();

    Iterable<Object[]> PostulantTireParListe(Long idTirage);
}
