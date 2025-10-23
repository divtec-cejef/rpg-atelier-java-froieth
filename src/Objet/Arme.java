package Objet;

import Base.ConsoleIO;
import Personnages.Hero;

// TODO : corriger bug quand on choisi l'arme à équipé c'est tjr l'arme par défault qui se séléctionne
public class Arme extends Objet {
    private ConsoleIO console = new ConsoleIO();
    private typeArme arme = typeArme.EPEE;

    public Arme() {
        super(typeArme.EPEE.getEffet(), typeArme.EPEE.getNom());
    }

    public Arme(typeArme arme) {
        super(arme.getEffet(), arme.getNom());
    }

    public typeArme getType() {
        return arme;
    }


    @Override
    public void utiliser(Hero cible) {
        cible.setATK(cible.getATK() + arme.bonusATK);
        cible.setDEF(cible.getDEF() - arme.malusDEF);
        console.afficher("");
    }
}
