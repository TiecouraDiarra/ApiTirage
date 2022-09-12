package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.PostulantTS;
import com.example.apitirage.repository.RepoPostulantTS;
import com.example.apitirage.repository.RepoTirage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostulantTireImpl implements PostulantTireService{

    //================LA DEPENDANCE DU REPOSITORY DU POSTULANTS TIRES=========================
    private final RepoPostulantTS repoPTS;

    @Override
    //================METHODE PERMETTANT DE RECUPERER LES DONNEES DANS LE FICHIER ET LES ENREGISTRER=========================
    public int creer(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, Long id_tirage) {
        return repoPTS.INSERTPOSTTIRE(idPostulant,nomPostulant,prenomPostulant,numeroPostulant,emailPostulant,id_tirage);
    }

    @Override
    //================METHODE PERMETTANT D'AFFICHER TOUS LES POSTULANTS TIRES=========================
    public List<PostulantTS> AfficherTousLesPostulantsTire() {
        return repoPTS.findAll();
    }
}
