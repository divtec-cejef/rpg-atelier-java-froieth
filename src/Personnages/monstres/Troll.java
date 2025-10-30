package Personnages.monstres;

import Personnages.Hero;
import Personnages.Monstre;
import Personnages.Personnage;

public class Troll extends Monstre {

    public Troll() {
        super("Troll", 120, 25, 6, 80, 45);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Massue Écrasante";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        return 18 - Math.round(cible.getDEF() * 0.7) > 1 ? (int)(50 - Math.round(cible.getDEF() * 0.7)) : 1;
    }
}
