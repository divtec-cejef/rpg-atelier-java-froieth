package Base;

import Endroit.Boutique;
import Endroit.Taverne;
import Objet.Arme;
import Objet.typeArme;
import Personnages.Hero;
import Personnages.Heros.Archer;
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

        Boutique boutique = new  Boutique();
        Taverne taverne = new Taverne();
        Hero hero;

        console.afficherMenuCréationPersonnage();
        switch(console.readNextInt("Classe du Héro : ", 1, 3)) {
            default:
            case 1: console.afficherSansRetourLigne("Nom du Héro : "); hero = new Guerrier(console.readNextLine()); break;
            case 2: console.afficherSansRetourLigne("Nom du Héro : "); hero = new Mage(console.readNextLine()); break;
            case 3: console.afficherSansRetourLigne("Nom du Héro : "); hero = new Archer(console.readNextLine()); break;
        }

        hero.gagnerOr(50);

        Quete quete = new Quete(hero);
        boolean continuerJeux = true;
        do {
            console.afficherMenuPricipale();
            int choix = console.readNextInt("\nAction à réaliser : ", 0, 6);
            switch (choix) {
                case 0: continuerJeux = false; break;
                case 1: console.afficher(hero); console.readNextLine();break;
                case 2: console.afficherMenuPréparerCombat(hero, monstreAleatoire(), true, quete);break;
                case 3: console.afficherMenuInventaire(hero);break;
                case 4: boutique.visiter(hero);break;
                case 5: taverne.visiter(hero);break;
                case 6: console.afficherMenuQuetes(quete);break;
            }

        } while (continuerJeux);
    }
}

// TODO : faire pour qu'il y ait un boss de fin (idée : tavernier (fort si tu l'as combattu sinon gentil))