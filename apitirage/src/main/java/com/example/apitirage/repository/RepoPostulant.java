package com.example.apitirage.repository;

import com.example.apitirage.modele.Postulant;
import org.apache.poi.util.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RepoPostulant extends JpaRepository<Postulant, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant(nom_postulant, prenom_postulant,numero_postulant, email_postulant) value(?,?,?,?)", nativeQuery = true)
    int InsertPostulant(String nom, String prenom, String numero, String email);
}
