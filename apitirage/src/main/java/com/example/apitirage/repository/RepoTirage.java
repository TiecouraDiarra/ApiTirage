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
    /*@Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulant ORDER BY RAND() LIMIT 5", nativeQuery = true)
    Iterable<Object[]> TirageSelection();*/
    Tirage findByLibelle(String libelle);
    /*@Query(value = "SELECT * from tirage where id_liste_postulant = :idListePostulant", nativeQuery = true)
    public List<Tirage> FINDIDTIRAGELIST(@Param("idListePostulant") Long idListePostulant);*/
}
