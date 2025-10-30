package Endroit;

import Base.Combat;
import Base.ConsoleIO;
import Base.Quete;
import Personnages.Hero;
import Personnages.Heros.Guerrier;
import Personnages.Heros.Mage;
import Personnages.Tavernier;

public class Taverne {

    private final int prix = 30;
    private ConsoleIO console = new ConsoleIO();
    private Tavernier tavernier = new Tavernier();
    private boolean ouvert = true;
    private boolean tavernierLà = true;
    private Combat combat = new Combat(new Quete(new Guerrier("")));

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public void visiter(Hero hero) {
        if (tavernierLà) {
            if (ouvert) {
                console.afficherMenuTaverne(prix, tavernierLà);
                console.afficher("\nOr posseder : " + hero.getOr());



                switch (console.readNextInt("Action à réaliser : ", 0, 2)) {
                    case 2:
                        combat.combattre(hero, tavernier, false);
                        if (!combat.getGagnerCombat()) {
                            setOuvert(false);
                        } else {
                            tavernierLà = false;

                        }
                        break;
                    case 1:
                        if (hero.getOr() < prix) {
                            console.afficher("\nVous n'avez pas assez d'or !");
                            console.consomerRetourLigne();
                        } else {
                            hero.depenserOr(prix);
                            console.afficherSansRetourLigne("\nVous vous reposez paisiblement...");
                            console.readNextLine();
                            console.afficherSansRetourLigne("PV : " + hero.getPV() + " -> ");
                            hero.soigner(999999999);
                            console.afficher(hero.getPV());
                            if (hero instanceof Mage) {
                                console.afficherSansRetourLigne("Mana : " + ((Mage) hero).getManaRestant() + " -> ");
                                ((Mage) hero).setMana(((Mage) hero).getManaMax());
                                console.afficher(((Mage) hero).getManaRestant());
                            }
                        }
                        console.consomerRetourLigne();
                        break;
                    case 0:
                        break;
                }
            } else {
                console.afficher("\nVous êtes banni de la taverne.");
                console.readNextLine();
            }
        } else {
            console.afficherMenuTaverne(0, tavernierLà);
            switch (console.readNextInt("Action à réaliser : ", 0, 1)) {
                case 1:
                    console.afficherSansRetourLigne("\nVous vous reposez paisiblement...");
                    console.readNextLine();
                    console.afficherSansRetourLigne("PV : " + hero.getPV() + " -> ");
                    hero.soigner(999999999);
                    console.afficher(hero.getPV());
                    if (hero instanceof Mage) {
                        console.afficherSansRetourLigne("Mana : " + ((Mage) hero).getManaRestant() + " -> ");
                        ((Mage) hero).setMana(((Mage) hero).getManaMax());
                        console.afficher(((Mage) hero).getManaRestant());
                    }

                    console.consomerRetourLigne();break;
                case 0: break;
            }
        }
    }
}
