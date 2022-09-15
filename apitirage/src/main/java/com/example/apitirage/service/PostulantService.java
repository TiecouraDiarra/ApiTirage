package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface PostulantService {

    //================METHODE PERMETTANT D'AFFICHER TOUS LES POSTULANTS TIRES=========================
    ArrayList<Postulant> importerFichier(MultipartFile file);

    Postulant creerPostulant(Postulant postulant);

    List<Postulant>AfficherTousLesPostulants();
    List<Postulant> TrouveridPostList(Long idListe);

    Iterable<Object[]> IdTousPostulant(Long idPostulant);


}
