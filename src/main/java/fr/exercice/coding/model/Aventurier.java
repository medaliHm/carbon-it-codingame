package fr.exercice.coding.model;

import java.util.List;

import fr.exercice.coding.model.enums.DirectionEnum;

/**
 * Classe reprensentant l'aventurier.
 * 
 * @author mohamedali.elhajmess
 */
public class Aventurier
{

    private String name;

    private Coordonnes coordonnes;

    private DirectionEnum directionActuel;

    private List<Mouvement> aventuriersMovments;

    private int tresorDecouvert;

    /**
     * Constructeur de la classe Aventurier.java
     *
     * @param name
     * @param coordonnes
     * @param directionActuel
     * @param aventuriersMovments
     * @param tresorDecouvert
     */
    public Aventurier(String name, Coordonnes coordonnes, DirectionEnum directionActuel, List<Mouvement> aventuriersMovments,
        int tresorDecouvert)
    {
        super();
        this.name = name;
        this.coordonnes = coordonnes;
        this.directionActuel = directionActuel;
        this.aventuriersMovments = aventuriersMovments;
        this.tresorDecouvert = tresorDecouvert;
    }

    /**
     * Constructeur de la classe Aventurier.
     */
    public Aventurier()
    {
        super();
    }

    /**
     * Accesseur du name.
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Mutateur name.
     * 
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Accesseur du aventuriersMovments.
     * 
     * @return the aventuriersMovments
     */
    public List<Mouvement> getAventuriersMovments()
    {
        return aventuriersMovments;
    }

    /**
     * Mutateur aventuriersMovments.
     * 
     * @param aventuriersMovments the aventuriersMovments to set
     */
    public void setAventuriersMovments(List<Mouvement> aventuriersMovments)
    {
        this.aventuriersMovments = aventuriersMovments;
    }

    /**
     * Accesseur du coordonnes.
     * 
     * @return the coordonnes
     */
    public Coordonnes getCoordonnes()
    {
        return coordonnes;
    }

    /**
     * Mutateur coordonnes.
     * 
     * @param coordonnes the coordonnes to set
     */
    public void setCoordonnes(Coordonnes coordonnes)
    {
        this.coordonnes = coordonnes;
    }

    /**
     * Accesseur du tresorDecouvert.
     * 
     * @return the tresorDecouvert
     */
    public int getTresorDecouvert()
    {
        return tresorDecouvert;
    }

    /**
     * Mutateur tresorDecouvert.
     * 
     * @param tresorDecouvert the tresorDecouvert to set
     */
    public void setTresorDecouvert(int tresorDecouvert)
    {
        this.tresorDecouvert = tresorDecouvert;
    }

    /**
     * Accesseur du directionActuel.
     * 
     * @return the directionActuel
     */
    public DirectionEnum getDirectionActuel()
    {
        return directionActuel;
    }

    /**
     * Mutateur directionActuel.
     * 
     * @param directionActuel the directionActuel to set
     */
    public void setDirectionActuel(DirectionEnum directionActuel)
    {
        this.directionActuel = directionActuel;
    }

}
