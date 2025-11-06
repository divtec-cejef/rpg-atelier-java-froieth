package Base;

import Endroit.Boutique;
import Endroit.Taverne;
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

    static void main(String[] args) throws InterruptedException {
        ConsoleIO console = new ConsoleIO();

        Boutique boutique = new  Boutique();
        Taverne taverne = new Taverne();
        Hero hero;

        console.afficherMenuCréationPersonnage();
        int classeHero = console.readNextInt("Classe du Héro : ", 1, 3);

        console.afficherSansRetourLigne("Nom du Héro : ");
        String nomHero = console.readNextLine();

        // Met la première lettre en majuscule si besoin
        if (nomHero != null && !nomHero.isEmpty()) {
            char premiereLettre = nomHero.charAt(0);
            if (Character.isLetter(premiereLettre) && !Character.isUpperCase(premiereLettre)) {
                char majuscule = Character.toUpperCase(premiereLettre);
                nomHero = majuscule + nomHero.substring(1);
            }
        }


        switch(classeHero) {
            default:
            case 1: hero = new Guerrier(nomHero); break;
            case 2: hero = new Mage(nomHero); break;
            case 3: hero = new Archer(nomHero); break;
        }

        hero.gagnerOr(50);

        Quete quete = new Quete(hero);
        boolean continuerJeux = true;
        long startTime = System.currentTimeMillis();;
        do {
            console.afficherMenuPricipale();
            int choix = console.readNextInt("\nAction à réaliser : ", 0, 6);
            switch (choix) {
                case 0: continuerJeux = false; break;
                case 1: console.afficher(hero); console.readNextLine();break;
                case 2: console.afficherMenuPréparerCombat(hero, monstreAleatoire(), true, quete);break;
                case 3: console.afficherMenuInventaire(hero);break;
                case 4: boutique.visiter(hero);break;
                case 5: taverne.visiter(hero, quete, startTime);break;
                case 6: console.afficherMenuQuetes(quete);break;
            }

        } while (continuerJeux);
    }
}