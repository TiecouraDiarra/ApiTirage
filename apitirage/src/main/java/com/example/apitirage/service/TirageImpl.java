package com.example.apitirage.service;

import com.example.apitirage.modele.Tirage;
import com.example.apitirage.repository.RepoPostulant;
import com.example.apitirage.repository.RepoTirage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TirageImpl implements TirageService{

    private final RepoTirage repotirage;

    @Override
    public Iterable<Object[]> TirageSelection() {
        return repotirage.TirageSelection();
    }

    @Override
    public List<Tirage> findAllTirage() {
        return null;
    }
}
