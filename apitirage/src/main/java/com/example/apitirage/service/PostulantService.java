package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface PostulantService {
    ArrayList<Postulant> importerFichier(MultipartFile file);

    Postulant creerPostulant(Postulant postulant);

    Iterable<Object[]> AfficherTousLesPostulants();
    List<Postulant> TrouveridPostList(Long idListe);
}
