package Objet;

import Personnages.Hero;

public class Trinket extends Objet {
    typeTrinket type;

    public Trinket(typeTrinket type) {
        this.type = type;
        super(type.effet, type.getNom());
    }

    public typeTrinket getType() {
        return type;
    }

    @Override
    public void utiliser(Hero cible) {
        type.utiliser(cible);
    }
}
