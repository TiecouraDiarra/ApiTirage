package com.example.apitirage.repository;

import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RepoTirage extends JpaRepository<Tirage, Long> {

    Tirage findByLibelle(String libelle);
    //Tirage findByNombre(Long nombre);

}
