/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.exception;

/**
 * UnknownMouvementException.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 2 juil. 2020
 */
public class UnknownMouvementException extends ExceptionMetier
{

    /**
     * Champ serialVersionUID en entrée pour l'OS UnknownMouvementException.java
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de la classe UnknownMouvementException.java
     *
     * @param string
     */
    public UnknownMouvementException(String msg)
    {
        super(msg);
    }

}
