package com.example.apitirage.controller;


import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;
import com.example.apitirage.service.ListePostulantService;
import com.example.apitirage.service.PostulantService;
import com.example.apitirage.service.PostulantTireService;
import com.example.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Tirage")
public class TirageController {
    /*private final TirageService TService;

    @GetMapping("/tirage")
    public Iterable<Object[]> getRegionsSP(){

        return TService.TirageSelection();
    }*/

    private final TirageService TService;
    private final ListePostulantService listePostulantService;
    private final PostulantService postulantService;
    private final PostulantTireService postulantTireService;

    @PostMapping("/createTirage/{libelle}/{nombre}")
    public String create(@RequestBody Tirage tirage, @PathVariable String libelle, @PathVariable Long nombre, ListePostulant listeP){
        ListePostulant liste = listePostulantService.trouverListeParLibelle(libelle);
        List<Postulant> postulant = postulantService.TrouveridPostList(liste.getIdListePostulant());

        List<Postulant> lp = TService.CreerTirage(tirage, postulant, nombre);
        Long idTirage = TService.trouverTirageParlibelle(tirage.getLibelle()).getIdTirage();
        //Long idTirage = TService.trouverTirageParle(tirage.getIdTirage()).get();
        //ListePostulant l = listePostulantService.CreerListe(listeP);

        for (Postulant p : lp){

            //postulantService.creerPostulant(p);
            postulantTireService.creer(p.getIdPostulant(),p.getNomPostulant(),p.getPrenomPostulant(),p.getNumeroPostulant(),p.getEmailPostulant(),idTirage);

        }
        /*for (Tirage T : lp){
            T.setIdlistePostulant(l);
            TService.CreerTirageA(p);
        }*/
        return "succes";
    }

    @PutMapping("/modifier/{idTirage}")
    public Tirage update(@PathVariable Long idTirage, @RequestBody Tirage tirage){
        return TService.modifierTirage(idTirage, tirage);
    }

}
