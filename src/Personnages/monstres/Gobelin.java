package Personnages.monstres;

import Personnages.Monstre;
import Personnages.Personnage;

public class Gobelin extends Monstre {

    public Gobelin() {
        super("Gobelin", 50, 9, 3, 200, 20);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Coup Bas";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        return 6;
    }


}
