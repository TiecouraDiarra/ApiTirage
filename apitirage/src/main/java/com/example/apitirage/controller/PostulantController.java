package com.example.apitirage.controller;


import com.example.apitirage.modele.Postulant;
import com.example.apitirage.service.ListePostulantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Postulant")
@AllArgsConstructor
public class PostulantController {
    private final ListePostulantService LPService;

    @PostMapping("/importer")
    public String LireFichier(Postulant p){
        LPService.importerFichier(p);
        return "Fichier importé";
    }
}
