/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.service.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fr.exercice.coding.exception.ExceptionTechnique;

/**
 * LectureFichierService.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 1 juil. 2020
 */
public abstract class LectureFichierService
{
    public static List<String> lireFichier(String path) throws ExceptionTechnique
    {

        List<String> lignes = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path)))
        {
            stream.filter(l -> !l.startsWith("#")).forEach(lignes::add);

        }
        catch (IOException ioe)
        {
            throw new ExceptionTechnique("Erreur lors de la lecture du fichier");
        }

        return lignes;
    }
}
