/*
 * Copyright (c) 2020 DGFiP - Tous droits r√©serv√©s
 * 
 */
package fr.exercice.coding.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.exercice.coding.exception.AucunAventurierException;
import fr.exercice.coding.exception.CaseInaccessibleException;
import fr.exercice.coding.exception.UnknownDirectionException;
import fr.exercice.coding.exception.UnknownMouvementException;
import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Case;
import fr.exercice.coding.model.Coordonnes;
import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.model.enums.LigneFichier;

/**
 * CarteUtils.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public abstract class CarteUtils {

	/**
	 * Fonction utilitaire pour recuperer la liste des aventuries ‡ partir d'une
	 * liste de ligne.
	 * 
	 * @param lignes
	 * @return
	 * @throws UnknownMouvementException
	 * @throws UnknownDirectionException
	 * @throws AucunAventurierException
	 */
	public static List<Aventurier> retrieveAllAventuries(List<Ligne> lignes)
			throws UnknownMouvementException, UnknownDirectionException, AucunAventurierException {
		List<Aventurier> aventuriers = new ArrayList<>();

		for (Ligne l : lignes.stream().filter(ligne -> LigneUtils.checkType(ligne, LigneFichier.AVENTURIER))
				.collect(Collectors.toList())) {

			aventuriers.add(LigneUtils.ligneToAventurier(l));

		}

		if (aventuriers.isEmpty()) {

			throw new AucunAventurierException("Aucun aventurier detecte dans la carte");
		}
		return aventuriers;
	}

	/**
	 * 
	 * @param map
	 * @param aventuriers
	 * @throws CaseInaccessibleException
	 */
	public static void initAventuriers(Case[][] map, List<Aventurier> aventuriers) throws CaseInaccessibleException {
		for (Aventurier a : aventuriers) {
			Case caseInCarte = map[a.getCoordonnes().getAxeOrdonnee()][a.getCoordonnes().getAxeAbscisse()];
			if (!caseInCarte.getCheckMontagne()) {
				caseInCarte.setAventurierActuel(a);
			} else {
				throw new CaseInaccessibleException("Case depart inaccessible");

			}
		}
	}

	public static Optional<List<Coordonnes>> retrieveAllMontagnes(List<Ligne> lignes) {
		List<Coordonnes> montagnes = lignes.stream().filter(ligne -> LigneFichier.MONTAGNE.equals(ligne.getType()))
				.map(ligne -> LigneUtils.getCoordonneParLigne(ligne.getLigne())).collect(Collectors.toList());
		if (!montagnes.isEmpty()) {
			return Optional.of(montagnes);

		}

		return Optional.empty();
	}

	public static Optional<List<Ligne>> retrieveAllTresorsLignes(List<Ligne> lignes) {
		List<Ligne> tresors = lignes.stream().filter(ligne -> LigneFichier.TRESOR.equals(ligne.getType()))
				.collect(Collectors.toList());
		if (!tresors.isEmpty()) {
			return Optional.of(tresors);

		}

		return Optional.empty();
	}

	public static void initMontagnesTresors(Case[][] carte, Optional<List<Coordonnes>> montagnesCoordonnes,
			Optional<List<Ligne>> tresorsLines) {
		if (montagnesCoordonnes.isPresent())
			montagnesCoordonnes.get().stream()
					.forEach(cord -> carte[cord.getAxeOrdonnee()][cord.getAxeAbscisse()].setCheckMontagne(true));
		if (tresorsLines.isPresent())
			tresorsLines.get().stream().forEach(ligne -> {
				Coordonnes cord = LigneUtils.getCoordonneParLigne(ligne.getLigne());
				Case coordonneTresor = carte[cord.getAxeOrdonnee()][cord.getAxeAbscisse()];
				if (coordonneTresor.getCheckMontagne()) {
					System.err.println(" Initilisation du tresor √† la case : " + coordonneTresor.toString()
							+ " ignorÈ  car il existe deja un montagne ");
				} else {
					coordonneTresor.setTresors(Integer.parseInt(ligne.getLigne().split(GameHelper.separateur)[3]));
				}
			});
	}

}
