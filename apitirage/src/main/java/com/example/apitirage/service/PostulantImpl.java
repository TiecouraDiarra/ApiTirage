package com.example.apitirage.service;

import com.example.apitirage.modele.Postulant;
import com.example.apitirage.repository.RepoPostulant;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Service
public class PostulantImpl implements PostulantService{
    @Autowired
    final private RepoPostulant postulantRepository;
    @Override
    public ArrayList<Postulant> importerFichier(MultipartFile file) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulant> values = new ArrayList<Postulant>(); // Variable permettant de prendre toutes les donnees du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            //InputStream fichier = new FileInputStream("fichierSource.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
            // Boucle permettant de parcours toutes lignes de la page

            while (rows.hasNext()){

                //values.clear(); // Vider toutes les donnes du tableau dynamique "values"

                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes les colonnes de chaque ligne
                Postulant p=new Postulant();
                int numColun=0;
                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    switch (numColun){

                        case 0:
                            p.setNomPostulant(formatter.formatCellValue(cell));
                            break;
                        case 1:
                            p.setPrenomPostulant(formatter.formatCellValue(cell));
                            break;
                        case 2:
                            p.setNumeroPostulant(formatter.formatCellValue(cell));
                            break;
                        case 3:
                            p.setEmailPostulant(formatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    numColun++;

                    // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                    // if (cell.getCellType() == CellType.NUMERIC){
                    //   values.add(Integer.toString((int) cell.getNumericCellValue()));
                    // }
                    //else{
                    //  values.add(cell.getStringCellValue());
                    // }
                }

                //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                values.add(p);
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    @Override
    public Postulant creerPostulant(Postulant postulant) {

        return postulantRepository.save(postulant);
    }

    @Override
    public List<Postulant> AfficherTousLesPostulants() {
        return  postulantRepository.findAll();
    }

    @Override
    public List<Postulant> TrouveridPostList(Long idListe) {

        return postulantRepository.FINDIDPOSTLIST(idListe);
    }


    /*private final RepoPostulant repoPostulant;


    @Override
    public ArrayList<Postulant> importerFichier(MultipartFile file) {

        ArrayList<Postulant> values = new ArrayList<>();


        try {

            //InputStream input = new FileInputStream("Classeur1.xls");
            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()){
                values.clear();
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                Postulant p = new Postulant();
                int numColun = 0;
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next();

                    Switch(numColun){
                        case 0:
                            p.setNomPostulant(formatter);
                    }
                    if( cell.getCellType() == CellType.NUMERIC)
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                    else if (CellType.STRING == cell.getCellType())
                        values.add(cell.getStringCellValue());
                }


                repoPostulant.InsertPostulant(values.get(0), values.get(1), values.get(2), values.get(3));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
