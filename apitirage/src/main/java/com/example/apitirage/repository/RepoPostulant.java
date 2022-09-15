package com.example.apitirage.repository;

import com.example.apitirage.modele.Postulant;
import org.apache.poi.util.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RepoPostulant extends JpaRepository<Postulant, Long> {
    /*@Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant(nom_postulant, prenom_postulant,numero_postulant, email_postulant) value(?,?,?,?)", nativeQuery = true)
    int InsertPostulant(String nom, String prenom, String numero, String email);*/

    @Query(value = "SELECT * from postulant where id_liste_postulant = :idListePostulant", nativeQuery = true)
    public List<Postulant> FINDIDPOSTLIST(@Param("idListePostulant") Long idListePostulant);


    @Query(value = "SELECT * from postulant", nativeQuery = true)
    Iterable<Object[]> AfficherTousLesPostulants ();


    @Query(value = "SELECT * from postulant where id_liste_postulant = :id_liste_postulant", nativeQuery = true)
    Iterable<Object[]> IdTousPostulant(Long id_liste_postulant);
}
