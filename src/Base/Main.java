package Base;

import Endroit.Boutique;
import Endroit.Taverne;
import Objet.Arme;
import Objet.typeArme;
import Personnages.Hero;
import Personnages.Heros.Guerrier;
import Personnages.Heros.Mage;
import Personnages.Monstre;
import Personnages.monstres.Dragon;
import Personnages.monstres.Gobelin;
import Personnages.monstres.Troll;


public class Main {

    public static Monstre monstreAleatoire() {
        Monstre monstre;

        int pourcentage = (int)(Math.random() * 100) + 1;
        if (pourcentage <= 50) {
            monstre = new Gobelin();
        } else if (pourcentage <= 85) {
            monstre = new Troll();
        } else {
            monstre = new Dragon();
        }

        return monstre;
    }

    static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();

        Hero hero = new Mage("test");
        Boutique boutique = new  Boutique();
        Taverne taverne = new Taverne();

        hero.gagnerOr(1223123);

        boolean continuerJeux = true;
        do {
            console.afficherMenuPricipale();
            int choix = console.readNextInt("\nAction à réaliser : ", 0, 5);
            if (choix == 0) {continuerJeux = false;
            } else {
                switch (choix) {
                    case 1: console.afficher(hero); console.readNextLine();break;
                    case 2: console.afficherMenuPréparerCombat(hero, monstreAleatoire(), true);break;
                    case 3: console.afficherMenuInventaire(hero);break;
                    case 4: boutique.visiter(hero);break;
                    case 5: taverne.visiter(hero);break;
                }
            }

        } while (continuerJeux);
    }
}


// TODO : quand on montre le personnage montrer aussi ses pv def atk
// TODO : faire pour qu'on puisse choisir son nom et son type de guerrier au début du rogramme
// TODO : faire pour qu'il y ait un boss de fin