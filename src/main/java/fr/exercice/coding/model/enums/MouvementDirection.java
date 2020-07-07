/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.model.enums;

/**
 * MouvementDirectionEnum.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public class MouvementDirection
{

    private DirectionEnum direction;

    private MouvementEnum mouvement;

    /**
     * Accesseur de direction
     *
     * @return direction
     */
    public DirectionEnum getDirection()
    {
        return direction;
    }

    /**
     * Mutateur de direction
     *
     * @param direction direction
     */
    public void setDirection(DirectionEnum direction)
    {
        this.direction = direction;
    }

    /**
     * Accesseur de mouvement
     *
     * @return mouvement
     */
    public MouvementEnum getMouvement()
    {
        return mouvement;
    }

    /**
     * Mutateur de mouvement
     *
     * @param mouvement mouvement
     */
    public void setMouvement(MouvementEnum mouvement)
    {
        this.mouvement = mouvement;
    }

    /**
     * Constructeur de la classe MouvementDirectionEnum.java
     *
     * @param direction
     * @param mouvement
     */
    public MouvementDirection(DirectionEnum direction, MouvementEnum mouvement)
    {
        this.direction = direction;
        this.mouvement = mouvement;
    }

    /**
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        MouvementDirection deplacement = (MouvementDirection) obj;
        if (deplacement.getDirection().equals(this.direction) && deplacement.getMouvement().equals(this.mouvement))
            return true;
        return false;
    }

    /**
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + direction.hashCode();
        result = 31 * result + mouvement.hashCode();
        return result;
    }

}
