/**
 * 
 */
package fr.exercice.coding.model;

/**
 * @author mohamedali.elhajmess
 */
public class Case
{

    private boolean checkMontagne;

    private int caseX;

    private int caseY;

    private int tresors;

    private Aventurier aventurierActuel;

    /**
     * Constructeur de la classe Case.java
     *
     * @param i
     * @param j
     */
    public Case(int i, int j)
    {
        this.caseX = i;
        this.caseY = j;
        this.tresors = 0;
        this.aventurierActuel = null;
        this.checkMontagne = false;
    }

    public int getCaseX()
    {
        return caseX;
    }

    public void setCaseX(int caseX)
    {
        this.caseX = caseX;
    }

    public int getCaseY()
    {
        return caseY;
    }

    public void setCaseY(int caseY)
    {
        this.caseY = caseY;
    }

    public int getTresors()
    {
        return tresors;
    }

    public void setTresors(int tresors)
    {
        this.tresors = tresors;
    }

    /**
     * Mutateur aventurierActuel.
     * 
     * @param aventurierActuel the aventurierActuel to set
     */
    public void setAventurierActuel(Aventurier aventurierActuel)
    {
        this.aventurierActuel = aventurierActuel;
    }

    /**
     * Accesseur du aventurierActuel.
     * 
     * @return the aventurierActuel
     */
    public Aventurier getAventurierActuel()
    {
        return aventurierActuel;
    }

    /**
     * Accesseur du checkMontagne.
     * 
     * @return the checkMontagne
     */
    public boolean getCheckMontagne()
    {
        return checkMontagne;
    }

    /**
     * Mutateur checkMontagne.
     * 
     * @param checkMontagne the checkMontagne to set
     */
    public void setCheckMontagne(boolean checkMontagne)
    {
        this.checkMontagne = checkMontagne;
    }

    /**
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return this.caseX + " " + this.caseY; // TODO Raccord de méthode auto-généré
    }

}
