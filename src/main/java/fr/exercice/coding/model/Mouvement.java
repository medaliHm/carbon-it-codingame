package fr.exercice.coding.model;

import fr.exercice.coding.model.enums.MouvementEnum;

public class Mouvement
{

    private MouvementEnum mouvement;

    private boolean mouvementEffectue;

    /**
     * Constructeur de la classe Mouvement.java
     *
     * @param mouvement
     * @param mouvementEffectue
     */
    public Mouvement(MouvementEnum mouvement, boolean mouvementEffectue)
    {
        super();
        this.mouvement = mouvement;
        this.mouvementEffectue = mouvementEffectue;
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
     * Constructeur de la classe Mouvement.java
     */
    public Mouvement()
    {
        // TODO Raccord de constructeur auto-généré

    }

    /**
     * Accesseur de mouvementEffectue
     *
     * @return mouvementEffectue
     */
    public boolean isMouvementEffectue()
    {
        return mouvementEffectue;
    }

    /**
     * Mutateur de mouvementEffectue
     *
     * @param mouvementEffectue mouvementEffectue
     */
    public void setMouvementEffectue(boolean mouvementEffectue)
    {
        this.mouvementEffectue = mouvementEffectue;
    }
}
