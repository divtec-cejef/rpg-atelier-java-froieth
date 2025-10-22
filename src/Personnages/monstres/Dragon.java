package Personnages.monstres;

import Personnages.Monstre;
import Personnages.Personnage;

public class Dragon extends Monstre {

    public Dragon(int PV, float ATK, int DEF, int butinXP, int or) {
        super("Dragon", 140, 18, 10, 150, 100);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Souffle de Feu";
    }

    // TODO : faire compétence spécial troll + dragon
    @Override
    public int competenceSpeciale(Personnage cible) {
        return 28 - Math.round(cible.getDEF() * 0.7) > 1 ? (int)(28 - Math.round(cible.getDEF() * 0.7)) : 1;
    }
}
