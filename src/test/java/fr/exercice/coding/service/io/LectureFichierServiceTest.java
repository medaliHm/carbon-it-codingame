package fr.exercice.coding.service.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.exercice.coding.exception.ExceptionTechnique;

public class LectureFichierServiceTest {

	@Test
	public void doit_retourner_une_liste_des_lignes() throws ExceptionTechnique {

		String testPath = new File("src/test/resources/input.txt").getAbsolutePath();

		List<String> lignes = new ArrayList<>();
		lignes.add("C - 4 - 3");
		lignes.add("M - 1 - 1");
		lignes.add("M - 2 - 2");

		List<String> lignesLus = LectureFichierService.lireFichier(testPath);

		assertEquals(3, lignesLus.size());
		assertTrue(lignesLus.get(0).equalsIgnoreCase(lignes.get(0)));
		assertTrue(lignesLus.get(1).equalsIgnoreCase(lignes.get(1)));
		assertTrue(lignesLus.get(2).equalsIgnoreCase(lignes.get(2)));
	}

	// @Test
	// public void should_throws_FileNotFoundException() {
	// assertThrows(
	// FileNotFoundException.class, () -> FileReader.getFileLines("")
	// );
	// }
}
