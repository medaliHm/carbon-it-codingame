/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.service;

import java.util.List;

import fr.exercice.coding.exception.ExceptionMetier;
import fr.exercice.coding.exception.ExceptionTechnique;
import fr.exercice.coding.model.Carte;
import fr.exercice.coding.model.Case;
import fr.exercice.coding.model.Coordonnes;
import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.utils.CarteUtils;
import fr.exercice.coding.utils.LigneUtils;

/**
 * Classe d'initialisation passage du fichier entrant vers les POJO avec
 * l'initialisation des POJO.
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public abstract class InitialisationService {

	/**
	 * 
	 * @param lignes
	 * @return
	 * @throws ExceptionMetier
	 * @throws ExceptionTechnique
	 */
	public static Carte fichiertoCarte(List<Ligne> lignes) throws ExceptionMetier, ExceptionTechnique {
		Coordonnes dimensions = LigneUtils.recupererDimensionsCarte(lignes);
		Carte carte = new Carte();
		carte.setDimensionsToAventurier(dimensions);

		Case[][] map = new Case[dimensions.getAxeOrdonnee()][dimensions.getAxeAbscisse()];
		initCarte(map, dimensions);

		CarteUtils.initAventuriers(map, CarteUtils.retrieveAllAventuries(lignes));

		CarteUtils.initMontagnesTresors(map, CarteUtils.retrieveAllMontagnes(lignes),
				CarteUtils.retrieveAllTresorsLignes(lignes));
		carte.setCarteTresor(map);
		return carte;
	}

	/**
	 * 
	 * @param matrice
	 * @param dimensions
	 */
	private static void initCarte(Case[][] matrice, Coordonnes dimensions) {
		for (int i = 0; i < dimensions.getAxeOrdonnee(); i++) {
			for (int j = 0; j < dimensions.getAxeAbscisse(); j++) {
				matrice[i][j] = new Case(i, j);
			}
		}

	}

}
