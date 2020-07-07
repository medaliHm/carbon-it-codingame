/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.enums.DirectionEnum;
import fr.exercice.coding.model.enums.MouvementDirection;
import fr.exercice.coding.model.enums.MouvementEnum;

/**
 * Implementation du design pattern Command pour deplacement de l'aventurier
 * gauche et droite , Utilisation du Hashmap pour le choix de direction et
 * mouvement.Possibilite de passage avec des annotations reflections ou meme des
 * spring holders.
 *
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public class MouvementDroiteGaucheCommand {

	private final static Map<MouvementDirection, MouvementCommand> MOUVEMENTS;
	/**
	 * Initialisation du map des directions avec des directionsMouvement et des
	 * commands.
	 */
	static {
		final Map<MouvementDirection, MouvementCommand> mouves = new HashMap<>();
		MouvementDirection nord_droite = new MouvementDirection(DirectionEnum.NORD, MouvementEnum.DROITE);
		MouvementDirection est_droite = new MouvementDirection(DirectionEnum.EST, MouvementEnum.DROITE);
		MouvementDirection sud_droite = new MouvementDirection(DirectionEnum.SUD, MouvementEnum.DROITE);
		MouvementDirection ouest_droite = new MouvementDirection(DirectionEnum.OUEST, MouvementEnum.DROITE);
		MouvementDirection nord_gauche = new MouvementDirection(DirectionEnum.NORD, MouvementEnum.GAUCHE);
		MouvementDirection sud_gauche = new MouvementDirection(DirectionEnum.SUD, MouvementEnum.GAUCHE);
		MouvementDirection est_gauche = new MouvementDirection(DirectionEnum.EST, MouvementEnum.GAUCHE);
		MouvementDirection ouest_gauche = new MouvementDirection(DirectionEnum.OUEST, MouvementEnum.GAUCHE);

		mouves.put(nord_droite, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.EST);
			}
		});

		mouves.put(est_droite, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.SUD);
			}
		});
		mouves.put(sud_droite, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.OUEST);
			}
		});
		mouves.put(ouest_droite, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.NORD);
			}
		});
		mouves.put(nord_gauche, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.OUEST);
			}
		});

		mouves.put(est_gauche, new MouvementCommand() {
			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.NORD);
			}
		});
		mouves.put(sud_gauche, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.EST);
			}
		});
		mouves.put(ouest_gauche, new MouvementCommand() {

			@Override
			public void mouvement(Aventurier aventurier) {
				aventurier.setDirectionActuel(DirectionEnum.SUD);
			}
		});
		MOUVEMENTS = Collections.unmodifiableMap(mouves);
	}

	/**
	 * 
	 * Fonction de deplacement , choix du mouvement � partir du key du hashMap.
	 * 
	 * @param dirMouv
	 * @param aventurier
	 */
	public void moveAventurier(MouvementDirection dirMouv, Aventurier aventurier) {
		MouvementCommand command = MOUVEMENTS.get(dirMouv);
		System.out.println(dirMouv.getDirection() + " " + dirMouv.getMouvement());

		if (command == null) {
			throw new IllegalArgumentException("Invalid Direction Mouvment: " + dirMouv);

		}
		command.mouvement(aventurier);
	}
}
