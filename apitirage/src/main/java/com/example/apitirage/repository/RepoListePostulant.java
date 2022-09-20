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

    @Query(value = "SELECT * FROM liste_postulant", nativeQuery = true)
    Iterable<Object[]> ToutesListe();

    @Query(value = "SELECT * FROM `liste_postulant` WHERE liste_postulant.id_liste_postulant = :id_liste_postulant", nativeQuery = true)
    Iterable<Object[]> IdListePostulant(Long id_liste_postulant);

    /*@Query(value = "SELECT COUNT(*) FROM liste_postulant WHERE liste_postulant.nombre!=0", nativeQuery = true)
    int nombreListeTiree();*/

    @Query(value = "SELECT COUNT(id_liste_postulant) FROM liste_postulant WHERE liste_postulant.nombre_tirage!=0", nativeQuery = true)
    Long nombreListeTiree();

    @Query(value = "SELECT COUNT(id_liste_postulant) FROM liste_postulant WHERE liste_postulant.nombre_tirage=0", nativeQuery = true)
    Long nombreListeNonTiree();

}
