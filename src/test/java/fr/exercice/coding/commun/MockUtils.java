/**
 * 
 */
package fr.exercice.coding.commun;

import java.util.ArrayList;
import java.util.List;

import fr.exercice.coding.model.Ligne;
import fr.exercice.coding.model.enums.LigneFichier;

/**
 * @author mohamedali.elhajmess
 *
 */
public class MockUtils {

	public static List<Ligne> generateCarteWithoutAventuriers() {
		List<Ligne> lignes = new ArrayList<>();
		lignes.add(new Ligne("C - 4 - 3", LigneFichier.CARTE));
		lignes.add(new Ligne("M - 1 - 1", LigneFichier.MONTAGNE));
		lignes.add(new Ligne("M - 2 - 2", LigneFichier.MONTAGNE));
		return lignes;
	}

	public static List<Ligne> generateCarte() {
		List<Ligne> lignes = new ArrayList<>();
		lignes.add(new Ligne("C - 5 - 5", LigneFichier.CARTE));
		lignes.add(new Ligne("M - 1 - 1", LigneFichier.MONTAGNE));
		lignes.add(new Ligne("M - 1 - 2", LigneFichier.MONTAGNE));
		lignes.add(new Ligne("T - 3 - 3", LigneFichier.TRESOR));
		lignes.add(new Ligne("T - 4 - 4", LigneFichier.TRESOR));
		lignes.add(new Ligne("A - Mohamed - 0 - 0 - N - AA", LigneFichier.AVENTURIER));
		lignes.add(new Ligne("A - Elhaj - 1 - 2 - S - ADD", LigneFichier.AVENTURIER));

		return lignes;
	}

	public static List<Ligne> generateCarteWithoutMontagnesAndTresors() {
		List<Ligne> lignes = new ArrayList<>();
		lignes.add(new Ligne("C - 4 - 3", LigneFichier.CARTE));

		return lignes;
	}

}
