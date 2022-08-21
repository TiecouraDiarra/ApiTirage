package com.example.apitirage.repository;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RepoListePostulant extends JpaRepository<ListePostulant, Long> {
    ListePostulant findByLibelle(String libelle);

    /*@Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulant ORDER BY RAND() LIMIT 5", nativeQuery = true)
    Iterable<Object[]> TirageSelection();*/
}
