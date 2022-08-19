package com.example.apitirage.controller;


import com.example.apitirage.service.ListePostulantService;
import com.example.apitirage.service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Tirage")
public class TirageController {
    private final TirageService TService;

    @GetMapping("/tirage")
    public Iterable<Object[]> getRegionsSP(){

        return TService.TirageSelection();
    }

}
