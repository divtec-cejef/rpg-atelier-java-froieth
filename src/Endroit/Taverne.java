package Endroit;

import Base.Combat;
import Base.ConsoleIO;
import Personnages.Hero;
import Personnages.Tavernier;

public class Taverne {

    private final int prix = 30;
    private ConsoleIO console = new ConsoleIO();
    private Tavernier tavernier = new Tavernier();
    private boolean ouvert = true;
    private Combat combat = new Combat();

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public void visiter(Hero hero) {
        if(ouvert) {
            console.afficherMenuTaverne(prix);
            console.afficher("\nOr posseder : " + hero.getOr());

            boolean besoinDePayer = true;

            switch (console.readNextInt("Action à réaliser : ", 0, 2)) {
                case 2: combat.combattre(hero, tavernier, false); besoinDePayer = false; setOuvert(false);
                case 1:
                    if(besoinDePayer && hero.getOr() < prix) {
                        console.afficher("Vous n'avez pas assez d'or !");
                    } else {
                        if(besoinDePayer) {hero.depenserOr(prix);}
                        console.afficherSansRetourLigne("\nVous vous reposez paisiblement...");
                        console.readNextLine();
                        console.afficherSansRetourLigne("PV : " + hero.getPV() + " -> ");
                        hero.soigner(999999999);
                        console.afficher(hero.getPV());
                    }
                    console.consomerRetourLigne();break;
                case 0: break;
            }
        } else {
            console.afficher("La taverne est définitivement fermé car le tavernier est mort.");
            console.consomerRetourLigne();
        }
    }
}
