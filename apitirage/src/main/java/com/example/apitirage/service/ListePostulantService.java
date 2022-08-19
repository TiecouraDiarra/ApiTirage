package com.example.apitirage.service;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;

import java.util.List;

public interface ListePostulantService {
    void importerFichier(Postulant postulant);

    List<Postulant> Lire();
}
