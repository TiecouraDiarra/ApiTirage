package com.example.apitirage.service;

import com.example.apitirage.repository.RepoPostulantTS;
import com.example.apitirage.repository.RepoTirage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostulantTireImpl implements PostulantTireService{
    private final RepoPostulantTS repoPTS;
    /*@Override
    public Iterable<Object[]> TirageSelection() {
        return repoPTS.TirageSelection();
    }*/

    @Override
    public int creer(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, Long id_tirage) {
        return repoPTS.INSERTPOSTTIRE(idPostulant,nomPostulant,prenomPostulant,numeroPostulant,emailPostulant,id_tirage);
    }

    @Override
    public Iterable<Object[]> AfficherTousLesPostulantsTire() {
        return repoPTS.AfficherTousLesPostulantsTire();
    }
}
