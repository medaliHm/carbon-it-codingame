/**
 * 
 */
package fr.exercice.coding.service;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Carte;
import fr.exercice.coding.model.Case;
import fr.exercice.coding.model.Coordonnes;

/**
 * @author mohamedali.elhajmess
 */
public class MouvementService {

	/**
	 * Fonction pour mettre � jour les coordonnes de l'aventurier selon sa
	 * direction.
	 * 
	 * @param aventurier
	 * @return
	 */
	private static Coordonnes deplacer(Aventurier aventurier) {
		Coordonnes nouveauCoordonnes = new Coordonnes();
		int axeX = aventurier.getCoordonnes().getAxeAbscisse();
		int axeY = aventurier.getCoordonnes().getAxeOrdonnee();

		switch (aventurier.getDirectionActuel()) {
		case NORD:
			nouveauCoordonnes.setAxeAbscisse(axeX);
			nouveauCoordonnes.setAxeOrdonnee(axeY - 1);
			break;
		case SUD:
			nouveauCoordonnes.setAxeAbscisse(axeX);
			nouveauCoordonnes.setAxeOrdonnee(axeY + 1);

			break;
		case EST:
			nouveauCoordonnes.setAxeAbscisse(axeX + 1);

			nouveauCoordonnes.setAxeOrdonnee(axeY);
			break;
		case OUEST:
			nouveauCoordonnes.setAxeAbscisse(axeX - 1);

			nouveauCoordonnes.setAxeOrdonnee(axeY);
			break;
		}
		return nouveauCoordonnes;
	}

	/**
	 * Fonction pour un deplacement en avant de l'aventurier.
	 * 
	 * @param carte
	 * @param aventurier
	 */

	public static void mouvementAvant(Carte carte, Aventurier aventurier) {
		Coordonnes coordonnes = deplacer(aventurier);
		BiPredicate<Coordonnes, Coordonnes> verificationCoordonnes = (c1,
				c2) -> c1.getAxeAbscisse() > c2.getAxeAbscisse() && c1.getAxeOrdonnee() > c2.getAxeOrdonnee()
						&& c2.getAxeAbscisse() >= 0 && c2.getAxeOrdonnee() >= 0;
		Case[][] cases = carte.getCarteTresor();
		if (verificationCoordonnes.test(carte.getDimensionsToAventurier(), coordonnes)) {

			Case caseActuel = cases[aventurier.getCoordonnes().getAxeOrdonnee()][aventurier.getCoordonnes()
					.getAxeAbscisse()];
			Case nouveauCase = cases[coordonnes.getAxeOrdonnee()][coordonnes.getAxeAbscisse()];
			Predicate<Case> verificationCase = (p1) -> !p1.getCheckMontagne();
			if (verificationCase.test(nouveauCase)) {

				caseActuel.setAventurierActuel(null);
				nouveauCase.setAventurierActuel(aventurier);
				aventurier.setCoordonnes(coordonnes);
				System.out.println("L'aventurier vient d'avancer à la case : " + nouveauCase.toString());
				if (nouveauCase.getTresors() > 0) {
					aventurier.setTresorDecouvert(aventurier.getTresorDecouvert() + 1);
					nouveauCase.setTresors(nouveauCase.getTresors() - 1);
					System.out.println("Nouveau Tresor Detecte");

				}
			} else {
				System.err.println("Mouvement non permis. Montagne detecté");
			}
		} else {
			System.err.println("Mouvement à une case hors la carte");
		}

	}

}
