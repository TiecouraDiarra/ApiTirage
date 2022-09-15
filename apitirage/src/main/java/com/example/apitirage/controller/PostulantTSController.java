package com.example.apitirage.controller;


import com.example.apitirage.service.PostulantTireService;

import com.example.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
@RequestMapping("/TiragePTS")
@CrossOrigin(origins = "http://localhost:4200/")
public class PostulantTSController {
    @Autowired
    private PostulantTireService PTSService;


    @Autowired
    private final TirageService TService;


    @GetMapping("/AfficherListeParTirage/{idTirage}")
    public Iterable<Object[]> getPostulantsTireParListe(@PathVariable Long idTirage){

        return PTSService.PostulantTireParListe(idTirage);
    }


}
