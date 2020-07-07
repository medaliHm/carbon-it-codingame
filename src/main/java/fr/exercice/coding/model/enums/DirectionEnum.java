/**
 * 
 */
package fr.exercice.coding.model.enums;

/**
 * @author mohamedali.elhajmess
 */
public enum DirectionEnum
{
    NORD("N"), SUD("S"), EST("E"), OUEST("O");

    private String directionVal;

    /**
     * Constructeur de l'enumeration direction.
     */
    DirectionEnum(String directionVal)
    {
        this.directionVal = directionVal;
    }

    /**
     * Accesseur du directionVal.
     * 
     * @return the directionVal
     */
    public String getDirectionVal()
    {
        return directionVal;
    }

    /**
     * Mutateur directionVal.
     * 
     * @param directionVal the directionVal to set
     */
    public void setDirectionVal(String directionVal)
    {
        this.directionVal = directionVal;
    }

}
