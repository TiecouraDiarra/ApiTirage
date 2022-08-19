package com.example.apitirage.repository;

import com.example.apitirage.modele.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RepoTirage extends JpaRepository<Tirage, Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulant ORDER BY RAND() LIMIT 5", nativeQuery = true)
    Iterable<Object[]> TirageSelection();
}
