package com.example.apitirage.service;

import com.example.apitirage.modele.Tirage;

import java.util.List;

public interface TirageService {
    Iterable<Object[]> TirageSelection();
    public List<Tirage> findAllTirage();
}
