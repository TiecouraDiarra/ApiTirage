package com.example.apitirage.repository;

import com.example.apitirage.modele.PostulantTS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RepoPostulantTS extends JpaRepository<PostulantTS, Long> {
    /*@Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulant ORDER BY RAND() LIMIT 5", nativeQuery = true)
    Iterable<Object[]> TirageSelection();*/

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulantts(id_postulant, nom_postulant, prenom_postulant, numero_postulant, email_postulant, id_tirage) values(?,?,?,?,?,?)", nativeQuery = true)
    public int INSERTPOSTTIRE(Long idPostulant, String nomPostulant, String prenomPostulant, String numeroPostulant, String emailPostulant, Long id_tirage);

    @Query(value = "SELECT * from postulantts", nativeQuery = true)
    Iterable<Object[]> AfficherTousLesPostulantsTire();
}
