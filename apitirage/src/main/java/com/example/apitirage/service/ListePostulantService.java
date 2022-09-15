package com.example.apitirage.service;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

public interface ListePostulantService {
    //void importerFichier(MultipartFile file);

    //List<Postulant> Lire();
    ListePostulant CreerListe(ListePostulant listePostulant);
    ListePostulant trouverListeParLibelle(String libelle);

    Iterable<Object[]> AfficherToutesListe();

    Iterable<Object[]> IdListePostulant(Long idListePostulant);


    ListePostulant RetrouverParId(Long idListePostulant);

    Long nombreListeTiree();


    /*ListePostulant modifier(Long id_liste_postulant);*/
}
