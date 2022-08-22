package com.example.apitirage.controller;


import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.service.ListePostulantService;
import com.example.apitirage.service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

@RestController

@RequestMapping("/Postulant")
@AllArgsConstructor
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
    public Iterable<Object[]> getPostulants(){
        return postulantService.AfficherTousLesPostulants();
    }
}
