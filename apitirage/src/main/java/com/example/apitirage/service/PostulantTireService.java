package com.example.apitirage.service;

public interface PostulantTireService {
    /*Iterable<Object[]> TirageSelection();*/

    int creer(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, Long id_tirage);

    Iterable<Object[]> AfficherTousLesPostulantsTire();
}
