package com.example.apitirage.controller;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.PostulantTS;
import com.example.apitirage.modele.Tirage;
import com.example.apitirage.service.PostulantTireService;
import com.example.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/TiragePTS")
@CrossOrigin(origins = "http://localhost:4200/")
public class PostulantTSController {
    private final PostulantTireService PTSService;


    @GetMapping("/AfficherPostTire")
    public List<PostulantTS> getPostulantsTire(){

        return PTSService.AfficherTousLesPostulantsTire();
    }
}
