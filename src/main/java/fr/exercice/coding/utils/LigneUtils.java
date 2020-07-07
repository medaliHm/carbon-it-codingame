/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.exercice.coding.exception.CarteLigneNotFound;
import fr.exercice.coding.exception.UnknownDirectionException;
import fr.exercice.coding.exception.UnknownLigneSyntaxException;
import fr.exercice.coding.exception.UnknownMouvementException;
import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Coordonnes;
import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.model.Mouvement;
import fr.exercice.coding.model.enums.DirectionEnum;
import fr.exercice.coding.model.enums.LigneFichier;
import fr.exercice.coding.model.enums.MouvementEnum;

/**
 * TresorUtils.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public abstract class LigneUtils
{

    public static Coordonnes recupCoordonnesAventurier(String ligne)
    {
        String[] array = ligne.split(GameHelper.separateur);
        return new Coordonnes(Integer.valueOf(array[2]), Integer.valueOf(array[3]));
    }

    public static Coordonnes getCoordonneParLigne(String ligne)
    {
        String[] split = ligne.split(GameHelper.separateur);
        return new Coordonnes(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public static Coordonnes recupererDimensionsCarte(List<Ligne> lignes) throws CarteLigneNotFound
    {

        Optional<Ligne> ligneCarte = lignes.stream().filter(l -> l.getType().equals(LigneFichier.CARTE)).findFirst();
        if (ligneCarte.isPresent())
        {
            String[] array = ligneCarte.get().getLigne().split(GameHelper.separateur);

            return new Coordonnes(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
        }
        else
        {
            throw new CarteLigneNotFound("Aucun ligne d'initialisation de la carte est present dans le fichier");
        }

    }

    public static Optional<List<Ligne>> retrieveAllByTypeLine(List<Ligne> lines, LigneFichier typeLigneRecherche)
    {
        List<Ligne> lignes = lines.stream()
            .filter(line -> typeLigneRecherche.equals(line.getType()))
            .collect(Collectors.toList());

        return (lignes.isEmpty()) ? Optional.empty() : Optional.of(lignes);
    }

    public static Aventurier ligneToAventurier(Ligne ligne) throws UnknownMouvementException, UnknownDirectionException
    {

        String[] array = ligne.getLigne().split(GameHelper.separateur);
        String name = array[1];
        Coordonnes coordonnes = recupCoordonnesAventurier(ligne.getLigne());
        List<Mouvement> movements = new ArrayList<>();

        for (char c : array[5].toCharArray())
        {
            movements.add(new Mouvement(recupMouvementParChar(c), false));
        }

        DirectionEnum directionAventurier = recupDirection(array[4].toString());

        return new Aventurier(name, coordonnes, directionAventurier, movements, 0);

    }

    public static boolean checkType(Ligne line, LigneFichier type)
    {
        return type.equals(line.getType());
    }

    /**
     * DOCUMENTEZ_MOI
     *
     * @param c
     * @return
     * @throws IllegalArgumentException
     */
    public static MouvementEnum recupMouvementParChar(char c) throws UnknownMouvementException
    {
        switch (c)
        {
            case 'A':
                return MouvementEnum.AVANT;
            case 'G':
                return MouvementEnum.GAUCHE;
            case 'D':
                return MouvementEnum.DROITE;
        }
        throw new UnknownMouvementException("Un mouvement d'un aventurier n'est pas correctement renseigné.");
    }

    public static DirectionEnum recupDirection(String d) throws UnknownDirectionException
    {
        switch (d)
        {
            case "N":
                return DirectionEnum.NORD;
            case "S":
                return DirectionEnum.SUD;
            case "E":
                return DirectionEnum.EST;
            case "O":
                return DirectionEnum.OUEST;
        }
        throw new UnknownDirectionException("Un mouvement d'un aventurier n'est pas correctement renseigné.");
    }

    /**
     * DOCUMENTEZ_MOI
     *
     * @param lignesFichier
     * @return
     * @throws UnknownLigneSyntaxException
     */
    public static List<Ligne> StringtoLigne(List<String> lignesFichier) throws UnknownLigneSyntaxException
    {
        List<Ligne> lignes = new ArrayList<>();

        for (String line : lignesFichier)
        {
            Ligne ligne = new Ligne();
            ligne.setLigne(line);

            ligne.setType(LigneUtils.getLigneType(line));
            lignes.add(ligne);

        }

        return lignes;
    }

    /**
     * DOCUMENTEZ_MOI
     *
     * @param l
     * @return
     * @throws UnknownLigneSyntaxException
     */
    private static LigneFichier getLigneType(String line) throws UnknownLigneSyntaxException
    {

        if (line.startsWith(GameHelper.CARTE_BEGIN))
        {
            return LigneFichier.CARTE;
        }
        else if (line.startsWith(GameHelper.MONTAGNE_BEGIN))
        {
            return LigneFichier.MONTAGNE;
        }
        else if (line.startsWith(GameHelper.TRESOR_BEGIN))
        {
            return LigneFichier.TRESOR;
        }
        else if (line.startsWith(GameHelper.AVENTURIER_BEGIN))
        {
            return LigneFichier.AVENTURIER;
        }

        else
        {
            throw new UnknownLigneSyntaxException("Impossible de définir le type de la ligne fournie : " + line);
        }
    }
}
