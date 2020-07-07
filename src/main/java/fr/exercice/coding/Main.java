package fr.exercice.coding;

import java.util.List;

import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Carte;
import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.service.GameService;
import fr.exercice.coding.service.InitialisationService;
import fr.exercice.coding.service.io.LectureFichierService;
import fr.exercice.coding.service.io.OutputWriter;
import fr.exercice.coding.utils.CarteUtils;
import fr.exercice.coding.utils.LigneUtils;

public class Main
{

    public static void main(String[] args) throws Exception
    {

        String fileToReadPath = args[0].toString();

        List<Ligne> linesTypes = LigneUtils.StringtoLigne(LectureFichierService.lireFichier(fileToReadPath));

        Carte carte = InitialisationService.fichiertoCarte(linesTypes);

        List<Aventurier> adventurers = CarteUtils.retrieveAllAventuries(linesTypes);

        CarteUtils.initAventuriers(carte.getCarteTresor(), adventurers);

        GameService.playAventuriers(carte, adventurers, 0);

        OutputWriter.ecrireFichierSortant(
            args[1].toString(),
            carte,
            adventurers,
            linesTypes);
    }
}