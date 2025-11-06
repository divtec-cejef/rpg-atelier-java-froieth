package Endroit;

import Base.Combat;
import Base.ConsoleIO;
import Base.Fin;
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
    private boolean tavernierPrésent = true;
    private Combat combat = new Combat(new Quete(new Guerrier("")));

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public boolean getOuvert() {
        return ouvert;
    }

    public boolean getTavernierPrésent() {
        return tavernierPrésent;
    }

    public void visiter(Hero hero, Quete quete, long startTime) throws InterruptedException {
        if(quete.getQueteTerminer().get(0) && quete.getQueteTerminer().get(1) && quete.getQueteTerminer().get(2)) {
            console.afficherMenuTaverne(prix, tavernierPrésent, true);
            switch(console.readNextInt("Action a réaliser : ", 0, 1)){
                case 1: Fin fin = new Fin(this); fin.lancerFin(quete, hero, startTime) ;break;
                case 0: break;
            }
        } else {
            if (tavernierPrésent) {
                if (ouvert) {
                    console.afficherMenuTaverne(prix, tavernierPrésent, false);
                    console.afficher("\nOr posseder : " + hero.getOr());


                    switch (console.readNextInt("Action à réaliser : ", 0, 2)) {
                        case 2:
                            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
                            console.afficher("\t\t\t\t\t\t\t« Tu as un sacré culot de vouloir te battre contre moi.\n\t\t\t\t\t\t\t\tJe vais t'apprendre les bonnes manières ! »");
                            console.readNextLine();
                            combat.combattre(hero, tavernier, false);
                            if (!combat.getGagnerCombat()) {
                                setOuvert(false);
                            } else {
                                tavernierPrésent = false;

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
                console.afficherMenuTaverne(0, tavernierPrésent, false);
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

                        console.consomerRetourLigne();
                        break;
                    case 0:
                        break;
                }
            }
        }
    }
}
