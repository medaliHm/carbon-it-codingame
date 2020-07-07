package fr.exercice.coding.service.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import fr.exercice.coding.exception.ExceptionTechnique;
import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Carte;
import fr.exercice.coding.model.Case;
import fr.exercice.coding.model.Coordonnes;
import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.model.enums.LigneFichier;
import fr.exercice.coding.utils.GameHelper;
import fr.exercice.coding.utils.LigneUtils;

public abstract class OutputWriter {

	private static final String separateur = " - ";

	/**
	 * Methode d'ecriture de fichier sortant .
	 * 
	 * @param fileOutput
	 * @param carte
	 * @param aventuriers
	 * @param lignes
	 * @throws ExceptionTechnique
	 */
	public static void ecrireFichierSortant(String fileOutput, Carte carte, List<Aventurier> aventuriers,
			List<Ligne> lignes) throws ExceptionTechnique {
		try {
			File file = new File(fileOutput);
			FileWriter writer;

			writer = new FileWriter(file);

			PrintWriter printWriter = new PrintWriter(writer);

			lignes.forEach(l -> {
				if (l.getType().equals(LigneFichier.CARTE)) {
					ecrireLigneCarte(printWriter, l);
				} else if (l.getType().equals(LigneFichier.MONTAGNE)) {
					ecrireLigneMontagne(printWriter, l);
				} else if (l.getType().equals(LigneFichier.TRESOR)) {
					Coordonnes cordonneTresor = LigneUtils.getCoordonneParLigne(l.getLigne());

					Case caseTresor = carte.getCarteTresor()[cordonneTresor.getAxeOrdonnee()][cordonneTresor
							.getAxeAbscisse()];
					if (caseTresor != null) {
						ecrireLigneTresor(printWriter, caseTresor);
					}
				}
			});

			aventuriers.forEach(a -> ecrireLigneAventurier(printWriter, a));
			printWriter.close();

		} catch (IOException e) {
			throw new ExceptionTechnique("Erreur lors de l'ecriture de fichier ");
		}
	}

	/**
	 * 
	 * Methode privée pour ecrire une ligne de type carte "C - 1 - 1"
	 * 
	 * @param writer
	 * @param ligne
	 */
	private static void ecrireLigneCarte(PrintWriter writer, Ligne ligne) {

		Coordonnes dimensions = LigneUtils.getCoordonneParLigne(ligne.getLigne());
		writer.println(GameHelper.CARTE_BEGIN + dimensions.getAxeOrdonnee() + separateur + dimensions.getAxeAbscisse());
	}

	/**
	 * Methode pour ecrire une ligne Montagne dans le fichier sortant "M - ".
	 * 
	 * @param writer
	 * @param ligne
	 */
	private static void ecrireLigneMontagne(PrintWriter writer, Ligne ligne) {
		Coordonnes montagneCoordonnes = LigneUtils.getCoordonneParLigne(ligne.getLigne());
		writer.println(GameHelper.MONTAGNE_BEGIN + montagneCoordonnes.getAxeAbscisse() + separateur
				+ montagneCoordonnes.getAxeOrdonnee());
	}

	/**
	 * 
	 * @param writer
	 * @param caseTreasure
	 */
	private static void ecrireLigneTresor(PrintWriter writer, Case caseTreasure) {
		if (caseTreasure.getTresors() > 0) {
			writer.println(GameHelper.TRESOR_BEGIN + caseTreasure.getCaseY() + separateur + caseTreasure.getCaseX()
					+ separateur + caseTreasure.getTresors());
		}
	}

	/**
	 * Fonction pour ecrire une ligne de sortie lié à l'aventurier .
	 * 
	 * @param writer
	 * @param a
	 */
	private static void ecrireLigneAventurier(PrintWriter writer, Aventurier a) {
		writer.println(GameHelper.AVENTURIER_BEGIN + a.getName() + separateur + a.getCoordonnes().getAxeAbscisse()
				+ separateur + a.getCoordonnes().getAxeOrdonnee() + separateur
				+ a.getDirectionActuel().getDirectionVal() + separateur + a.getTresorDecouvert());
	}

}
