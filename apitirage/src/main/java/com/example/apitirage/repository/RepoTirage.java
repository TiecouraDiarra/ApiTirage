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


    @Query(value = "SELECT COUNT(id_tirage) FROM `tirage`", nativeQuery = true)
    Long nombretirageTotale();

    @Query(value = "SELECT COUNT(id_liste_postulant) FROM `tirage` WHERE id_liste_postulant =:id_liste_postulant", nativeQuery = true)
    Long nombretirageUneListe(Long id_liste_postulant);

    @Query(value = "SELECT * FROM `tirage` WHERE tirage.id_liste_postulant = :id_liste_postulant", nativeQuery = true)
    Iterable<Object[]> TousTirage(Long id_liste_postulant);


    @Query(value = "SELECT * FROM `postulantts` WHERE postulantts.id_tirage = :id_tirage", nativeQuery = true)
    Iterable<Object[]> IdTousTirage(Long id_tirage);

    @Query(value = "SELECT COUNT(id_tirage) FROM `postulantts` WHERE id_tirage =:id_tirage", nativeQuery = true)
    Long nombrePostulantTire(Long id_tirage);
}
