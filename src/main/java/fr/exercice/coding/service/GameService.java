/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.service;

import java.util.List;
import java.util.stream.Collectors;

import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Carte;
import fr.exercice.coding.model.Mouvement;
import fr.exercice.coding.model.enums.MouvementDirection;
import fr.exercice.coding.model.enums.MouvementEnum;

/**
 * Classe representant les fonctions utilitaires pour le jeu .
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public abstract class GameService {

	/**
	 * Fonction pour simuler les mouvements de l'aventurier .
	 * 
	 * @param carte
	 * @param aventuries
	 * @param count
	 */
	public static void playAventuriers(Carte carte, List<Aventurier> aventuries, int count) {
		List<Mouvement> mouvementsAventuriers = aventuries.stream()
				.flatMap(aventurier -> aventurier.getAventuriersMovments().stream()).collect(Collectors.toList());

		if (mouvementsAventuriers.stream().anyMatch(mouv -> !mouv.isMouvementEffectue())) {
			aventuries.stream()
					.filter(aventurier -> count < aventurier.getAventuriersMovments().size()
							&& !aventurier.getAventuriersMovments().get(count).isMouvementEffectue())
					.forEach(aventurier -> {
						Mouvement mouvement = aventurier.getAventuriersMovments().get(count);
						deplacerAventurier(carte, aventurier, mouvement);
						mouvement.setMouvementEffectue(true);
					});
			// appel recursive avec incrementation du tour
			playAventuriers(carte, aventuries, count + 1);

		}

	}

	/**
	 * Fonction de deplacement de l'aventurier selon le choix du mouvement .
	 * Utilisation de design pattern Command pour les mouvement gauche et droite.
	 * 
	 * @param map
	 * @param aventurier
	 * @param mouvement
	 */
	private static void deplacerAventurier(Carte map, Aventurier aventurier, Mouvement mouvement) {

		MouvementDroiteGaucheCommand executionMouvement = new MouvementDroiteGaucheCommand();
		if (mouvement.getMouvement().equals(MouvementEnum.AVANT)) {
			MouvementService.mouvementAvant(map, aventurier);
		} else {
			MouvementDirection dirMouv = new MouvementDirection(aventurier.getDirectionActuel(),
					mouvement.getMouvement());
			executionMouvement.moveAventurier(dirMouv, aventurier);

		}

	}

}
