package com.example.apitirage.controller;


import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.service.ListePostulantService;
import com.example.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/Postulant")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class PostulantController {
    private final PostulantService postulantService;
    private final ListePostulantService listePostulantService;

    @PostMapping("/importer/{libelle}")
    public String LireFichier(@Param("file")MultipartFile file, ListePostulant liste, String libelle){


        if(listePostulantService.trouverListeParLibelle(liste.getLibelle())==null){
            ArrayList<Postulant> importer = postulantService.importerFichier(file);
            liste.setDateListePostulant(new Date());
            ListePostulant l = listePostulantService.CreerListe(liste);

            for (Postulant p: importer)
            {
                p.setIdlistePostulant(l);
                postulantService.creerPostulant(p);
            }
            postulantService.importerFichier(file);
            postulantService.AfficherTousLesPostulants();
            return "Fichier importé";
        }else {
            return "Cette liste existe déja.";
        }


    }

    @GetMapping("/AfficherTousPost")
    public List<Postulant> getPostulants(){

        return postulantService.AfficherTousLesPostulants();
    }


    @GetMapping("/AfficherToutesListe/{idListePostulant}")
    public Iterable<Object[]> getToutesListe(@PathVariable Long idListePostulant){
        return postulantService.IdTousPostulant(idListePostulant);
    }

    @GetMapping("/AfficherToutesListeTiree")
    public Long getToutesListeTiree(){
        return listePostulantService.nombreListeTiree();
    }

    /*@GetMapping("/AfficherToutesListeTiree")
    public ListePostulant modifier(Long id_liste_postulant){
        return listePostulantService.modifier(id_liste_postulant);
    }*/

}
