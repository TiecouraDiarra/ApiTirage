package com.example.apitirage.service;

import com.example.apitirage.modele.ListePostulant;
import com.example.apitirage.modele.Postulant;
import com.example.apitirage.modele.Tirage;
import com.example.apitirage.repository.RepoListePostulant;
import com.example.apitirage.repository.RepoPostulant;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@AllArgsConstructor
@Service
public class ListePostulantImpl implements ListePostulantService {

    private final RepoListePostulant repoListePostulant;

    @Override
    public ListePostulant CreerListe(ListePostulant listePostulant) {

        return repoListePostulant.save(listePostulant);
    }

    @Override
    public ListePostulant trouverListeParLibelle(String libelle) {
        return repoListePostulant.findByLibelle(libelle);
    }
}
