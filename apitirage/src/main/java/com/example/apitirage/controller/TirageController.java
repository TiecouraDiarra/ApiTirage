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

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Tirage")
@CrossOrigin(origins ="http://localhost:4200")
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
    public String create(@RequestBody Tirage tirage, @PathVariable("libelle") String libelle, @PathVariable("nombre") Long nombre){

        if (TService.trouverTirageParlibelle(tirage.getLibelle())==null){
            ListePostulant liste = listePostulantService.trouverListeParLibelle(libelle);
            List<Postulant> postulant = postulantService.TrouveridPostList(liste.getIdListePostulant());

            tirage.setListePostulant(liste);
            tirage.setDateTirage(new Date());
            tirage.setNombrePostTire(nombre);
            List<Postulant> lp = TService.CreerTirage(tirage, postulant, nombre);
            Long idTirage = TService.trouverTirageParlibelle(tirage.getLibelle()).getIdTirage();

            for (Postulant p : lp){
                postulantTireService.creer(p.getIdPostulant(),p.getNomPostulant(),p.getPrenomPostulant(),p.getNumeroPostulant(),p.getEmailPostulant(),idTirage);
            }
            return "Tirage effectué avec succès";
        }else {
            return "Ce tirage existe déja.";
        }

    }

    @PutMapping("/modifier/{idTirage}")
    public Tirage update(@PathVariable Long idTirage, @RequestBody Tirage tirage){
        return TService.modifierTirage(idTirage, tirage);
    }

    @GetMapping("/AfficherTirageTotal")
    public Long getNombreTirage(){
        return TService.nombreTotaltirage();
    }

    @GetMapping("/AfficherTirageTotalUneListe/{IdListePostulant}")
    public Long getNombreTirageUneListe(@PathVariable Long IdListePostulant){
        return TService.nombreTotaltirageListe(IdListePostulant);
    }

    @GetMapping("/AfficherToutesListe")
    public Iterable<Object[]> getToutesListe(){
        return listePostulantService.AfficherToutesListe();
    }

    @GetMapping("/AfficherTousTirages/{IdListePostulant}")
    public Iterable<Object[]> getToutesTirages(@PathVariable Long IdListePostulant){
        return TService.AfficherTousLesTirages(IdListePostulant);
    }


    @GetMapping("/AfficherIdTirages/{idTirage}")
    public Iterable<Object[]> getIdTirages(@PathVariable Long idTirage){
        return TService.IdTirageTous(idTirage);
    }


    @GetMapping("/RecupererIdListePost/{IdListePostulant}")
    public Iterable<Object[]> getIdListePostulant(@PathVariable Long IdListePostulant){
        return listePostulantService.IdListePostulant(IdListePostulant);
    }


    @GetMapping("/nombrePostTire/{idTirage}")
    public Long getPostulantsTire(@PathVariable Long idTirage){
        return TService.nombrePostulantTire(idTirage);
    }


    @GetMapping("/RetrouverIdListePostulant/{idListePostulant}")
    public ListePostulant RetrouverIdListePostulant(@PathVariable Long idListePostulant){
        ListePostulant list = listePostulantService.RetrouverParId(idListePostulant);
        return list;
    }

    @GetMapping("/RetrouverIdIdTirage/{IdTirage}")
    public Tirage RetrouverIdTirage(@PathVariable Long IdTirage){
        Tirage Tira = TService.RetrouverParId(IdTirage);
        return Tira;
    }

}
