package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;
import com.example.apitirage.repository.RepoPostulant;
import com.example.apitirage.repository.RepoTirage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class TirageImpl implements TirageService{

    @Autowired
    //================LA DEPENDANCE DU REPOSITORY DU TIRAGE=========================
    private final RepoTirage repotirage;




    @Override
    //================METHODE PERMETTANT DE FAIRE LE TIRAGE=========================
    public List<Postulant> CreerTirage(@RequestBody Tirage tirage, List<Postulant> listAtrier, Long nbre) {
        Random rand = new Random();
        List<Postulant> list = new ArrayList<>();
        for (int i=0; i<nbre; i++){
            Integer idAct = rand.nextInt(listAtrier.size());
            list.add(listAtrier.get(idAct));
            listAtrier.remove(listAtrier.get(idAct));
        }
        repotirage.save(tirage);
        return list;
    }

    @Override
    //================METHODE PERMETTANT DE TROUVER LE TIRAGE PAR LIBELLE=========================
    public  Tirage trouverTirageParlibelle(String libelle) {
        return repotirage.findByLibelle(libelle);
    }

    @Override
    //================METHODE PERMETTANT DE MODIFIER UN TIRAGE=========================
    public Tirage modifierTirage(Long idTirage, Tirage tirage) {
        return repotirage.findById(idTirage)
                .map(p->{
                    p.setDateTirage(tirage.getDateTirage());
                    p.setLibelle(tirage.getLibelle());
                    p.setListePostulant(tirage.getListePostulant());
                    return repotirage.save(p);
                }).orElseThrow(() -> new RuntimeException("Tirage non trouvé !"));
    }

    @Override
    public Long nombreTotaltirage() {
        return repotirage.nombretirageTotale();
    }

    @Override
    public Long nombreTotaltirageListe(Long IdListePostulant) {
        return repotirage.nombretirageUneListe(IdListePostulant);
    }

    @Override
    public Iterable<Object[]> AfficherTousLesTirages(Long idListePostulant) {
        return repotirage.TousTirage(idListePostulant);
    }

    @Override
    public Iterable<Object[]> IdTirageTous(Long idTirage) {
        return repotirage.IdTousTirage(idTirage);
    }

    @Override
    public Long nombrePostulantTire(Long idTirage) {
        return repotirage.nombrePostulantTire(idTirage);
    }

    @Override
    public Tirage RetrouverParId(Long idTirage) {
        return repotirage.findById(idTirage).get();
    }

}
