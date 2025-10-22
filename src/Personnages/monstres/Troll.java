package Personnages.monstres;

import Personnages.Hero;
import Personnages.Monstre;
import Personnages.Personnage;

public class Troll extends Monstre {

    public Troll() {
        super("Troll", 90, 14, 6, 80, 45);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Massue Écrasante";
    }

    // TODO : faire compétence spécial troll + dragon
    @Override
    public int competenceSpeciale(Personnage cible) {
        return 18 - Math.round(cible.getDEF() * 0.7) > 1 ? (int)(18 - Math.round(cible.getDEF() * 0.7)) : 1;
    }
}
