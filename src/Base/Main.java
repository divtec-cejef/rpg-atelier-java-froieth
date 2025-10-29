package Base;

import Endroit.Boutique;
import Endroit.Taverne;
import Objet.Potion;
import Objet.Trinket;
import Objet.taillePotion;
import Objet.typeTrinket;
import Personnages.Hero;
import Personnages.Heros.Guerrier;
import Personnages.Monstre;
import Personnages.monstres.Dragon;
import Personnages.monstres.Gobelin;

import java.util.ArrayList;


public class Main {

    public static Monstre monstreAleatoire() {
        return new Gobelin();
    }

    static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();


        Hero hero = new Guerrier("test");
        Boutique boutique = new  Boutique();
        Taverne taverne = new Taverne();

        // TODO : supprimer ces lignes après les tests
        hero.gagnerOr(2000);


        boolean continuerJeux = true;
        do {
            console.afficherMenuPricipale();
            int choix = console.readNextInt("\nAction à réaliser : ", 0, 5);
            if (choix == 0) {continuerJeux = false;
            } else {
                switch (choix) {
                    case 1: break;
                    case 2: console.afficherMenuPréparerCombat(hero, monstreAleatoire(), true);break;
                    case 3: console.afficherMenuInventaire(hero);break;
                    case 4: boutique.visiter(hero);break;
                    case 5: taverne.visiter(hero);break;
                }
            }

        } while (continuerJeux);
    }
}
