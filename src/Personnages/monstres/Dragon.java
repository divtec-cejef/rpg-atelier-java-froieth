package Personnages.monstres;

import Personnages.Monstre;
import Personnages.Personnage;

public class Dragon extends Monstre {

    public Dragon() {
        super("Dragon", 170, 50, 10, 150, 100);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Souffle de Feu";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        return 28 - Math.round(cible.getDEF() * 0.7) > 1 ? (int)(100 - Math.round(cible.getDEF() * 0.7)) : 1;
    }
}
