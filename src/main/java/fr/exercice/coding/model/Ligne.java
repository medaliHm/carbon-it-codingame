/*
 * Copyright (c) 2020 DGFiP - Tous droits réservés
 * 
 */
package fr.exercice.coding.model;

import fr.exercice.coding.model.enums.LigneFichier;

/**
 * Ligne.java DOCUMENTEZ_MOI
 * 
 * @author mohamedali.elhajmess Date: 30 juin 2020
 */
public class Ligne {

	private String ligne;

	private LigneFichier type;

	/**
	 * Constructeur de la classe Ligne.java
	 */
	public Ligne() {

	}

	/**
	 * @param ligne
	 * @param type
	 */
	public Ligne(String ligne, LigneFichier type) {
		super();
		this.ligne = ligne;
		this.type = type;
	}

	/**
	 * Accesseur de ligne
	 *
	 * @return ligne
	 */
	public String getLigne() {
		return ligne;
	}

	/**
	 * Mutateur de ligne
	 *
	 * @param ligne ligne
	 */
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	/**
	 * Accesseur de type
	 *
	 * @return type
	 */
	public LigneFichier getType() {
		return type;
	}

	/**
	 * Mutateur de type
	 *
	 * @param type type
	 */
	public void setType(LigneFichier type) {
		this.type = type;
	}

}
