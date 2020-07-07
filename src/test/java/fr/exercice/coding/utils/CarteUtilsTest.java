/**
 * 
 */
package fr.exercice.coding.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import fr.exercice.coding.commun.MockUtils;
import fr.exercice.coding.exception.AucunAventurierException;
import fr.exercice.coding.exception.ExceptionMetier;
import fr.exercice.coding.exception.ExceptionTechnique;
import fr.exercice.coding.model.Aventurier;
import fr.exercice.coding.model.Case;
import fr.exercice.coding.model.Coordonnes;
import fr.exercice.coding.model.Ligne;

/**
 * @author mohamedali.elhajmess
 *
 */
public class CarteUtilsTest {

	@Test
	public void doit_retourner_liste_aventuriers() throws ExceptionTechnique, ExceptionMetier {

		List<Aventurier> aventuriers = CarteUtils.retrieveAllAventuries(MockUtils.generateCarte());
		assertEquals(2, aventuriers.size());
		assertEquals("Mohamed", aventuriers.get(0).getName());
		assertEquals("Elhaj", aventuriers.get(1).getName());

	}

	@Test
	public void doit_thrower_une_exception_aucun_aventurier() throws ExceptionTechnique, ExceptionMetier {

		List<Ligne> lignes = MockUtils.generateCarteWithoutAventuriers();
		assertThrows(AucunAventurierException.class, () -> CarteUtils.retrieveAllAventuries(lignes));

	}

	@Test
	public void doit_retourner_liste_montagnes() throws ExceptionTechnique, ExceptionMetier {

		Optional<List<Coordonnes>> montagnes = CarteUtils.retrieveAllMontagnes(MockUtils.generateCarte());
		assertEquals(true, montagnes.isPresent());
		assertEquals(2, montagnes.get().size());

	}

	@Test
	public void doit_retourner_liste_tresors() throws ExceptionTechnique, ExceptionMetier {

		Optional<List<Ligne>> tresors = CarteUtils.retrieveAllTresorsLignes(MockUtils.generateCarte());
		assertEquals(true, tresors.isPresent());
		assertEquals(2, tresors.get().size());

	}

	@Test
	public void doit_retourner_empty_montagnes() throws ExceptionTechnique, ExceptionMetier {

		Optional<List<Coordonnes>> montagnes = CarteUtils
				.retrieveAllMontagnes(MockUtils.generateCarteWithoutMontagnesAndTresors());
		assertEquals(Optional.empty(), montagnes);

	}

	@Test
	public void doit_retourner_empty_tresors() throws ExceptionTechnique, ExceptionMetier {

		Optional<List<Ligne>> tresors = CarteUtils
				.retrieveAllTresorsLignes(MockUtils.generateCarteWithoutMontagnesAndTresors());
		assertEquals(Optional.empty(), tresors);

	}

	@Test
	public void doit_remplir_matrice_avec_aventuriers() throws ExceptionTechnique, ExceptionMetier {

		Case[][] map = new Case[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Case(i, j);
			}
		}
		List<Aventurier> aventuriers = CarteUtils.retrieveAllAventuries(MockUtils.generateCarte());

		CarteUtils.initAventuriers(map, aventuriers);
		assertEquals("Mohamed", map[0][0].getAventurierActuel().getName());

		assertEquals("Elhaj", map[2][1].getAventurierActuel().getName());

	}

	@Test
	public void doit_remplir_matrice_avec_montagnesEtTresors() {
		Case[][] map = new Case[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = new Case(i, j);
			}
		}

	}
}
