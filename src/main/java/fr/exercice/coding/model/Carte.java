/**
 * 
 */
package fr.exercice.coding.model;

/**
 * @author mohamedali.elhajmess
 *
 */
public class Carte {

	private Case[][] carteTresor;

	private Coordonnes dimensionsToAventurier;

	/**
	 * Accesseur du carteTresor.
	 * 
	 * @return the carteTresor
	 */
	public Case[][] getCarteTresor() {
		return carteTresor;
	}

	/**
	 * Mutateur carteTresor.
	 * 
	 * @param carteTresor the carteTresor to set
	 */
	public void setCarteTresor(Case[][] carteTresor) {
		this.carteTresor = carteTresor;
	}

	/**
	 * Mutateur dimensionsToAventurier.
	 * 
	 * @param dimensionsToAventurier the dimensionsToAventurier to set
	 */
	public void setDimensionsToAventurier(Coordonnes dimensionsToAventurier) {
		this.dimensionsToAventurier = dimensionsToAventurier;
	}

	/**
	 * Accesseur du dimensionsToAventurier.
	 * 
	 * @return the dimensionsToAventurier
	 */
	public Coordonnes getDimensionsToAventurier() {
		return dimensionsToAventurier;
	}

}
