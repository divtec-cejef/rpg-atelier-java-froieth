package Objet;

import Personnages.Hero;

public abstract class Objet {
    private final String effet;

    public Objet(String effet) { this.effet = effet; }

    public String getEffet() { return effet; }

    public abstract void utiliser(Hero cible);

    @Override
    public String toString() { return getClass().getSimpleName()+"("+ effet +")"; }
}

