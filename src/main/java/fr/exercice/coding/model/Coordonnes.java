package fr.exercice.coding.model;

public class Coordonnes
{

    private int axeAbscisse;

    private int axeOrdonnee;

    /**
     * Constructeur de la classe Coordonnes.java
     *
     * @param axeAbscisse
     * @param axeOrdonnee
     */
    public Coordonnes(int axeAbscisse, int axeOrdonnee)
    {
        super();
        this.axeAbscisse = axeAbscisse;
        this.axeOrdonnee = axeOrdonnee;
    }

    /**
     * Constructeur de la classe Coordonnes.
     */
    public Coordonnes()
    {
        super();
    }

    /**
     * Accesseur du axeAbscisse.
     * 
     * @return the axeAbscisse
     */
    public int getAxeAbscisse()
    {
        return axeAbscisse;
    }

    /**
     * Mutateur axeAbscisse.
     * 
     * @param axeAbscisse the axeAbscisse to set
     */
    public void setAxeAbscisse(int axeAbscisse)
    {
        this.axeAbscisse = axeAbscisse;
    }

    /**
     * Mutateur axeOrdonnee.
     * 
     * @param axeOrdonnee the axeOrdonnee to set
     */
    public void setAxeOrdonnee(int axeOrdonnee)
    {
        this.axeOrdonnee = axeOrdonnee;
    }

    /**
     * Accesseur du axeOrdonnee.
     * 
     * @return the axeOrdonnee
     */
    public int getAxeOrdonnee()
    {
        return axeOrdonnee;
    }

}
