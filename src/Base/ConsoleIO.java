package Base;

import Endroit.Boutique;
import Endroit.Taverne;
import Objet.*;
import Personnages.Hero;
import Personnages.Heros.Mage;
import Personnages.Monstre;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIO {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Permet de lire le prochain int
     *
     * @return la valeur du prochain int
     */
    public int readNextInt(String message,  int min, int max) {
        boolean repeterSaisi = true;
        int saisie = 0;

        while (repeterSaisi) {
            afficherSansRetourLigne(message);
            if (scanner.hasNextInt()) {
                saisie = scanner.nextInt();
                if (saisie >= min && saisie <= max) {
                    repeterSaisi = false;
                } else {
                    afficher("\nVeuillez saisir un nombre compris entre " + min + " et " + max + " !");
                }
            } else {
                scanner.next();
                afficherSansRetourLigne("\nVeuillez saisir nombre !\n");
            }
        }
        return saisie;
    }

    /**
     * Permet de lire la prochaine ligne
     *
     * @return la valeur de la porchaine ligne
     */
    public String readNextLine() {
        consomerRetourLigne(); // Prend le retour à la ligne précédent
        return scanner.nextLine();
    }

    /**
     * Permet de consomer un retour de ligne
     * @return
     */
    public String consomerRetourLigne() {
        return scanner.nextLine();
    }

    /**
     * Affiche l'objet
     *
     * @param obj Objet à afficher
     */
    public void afficher(Object obj) {
        System.out.println(obj);
    }

    /**
     * Affiche l'objet sans faire de retour à la ligne
     *
     * @param obj Objet à afficher
     */
    public void afficherSansRetourLigne(Object obj) {
        System.out.print(obj);
    }

    /**
     * Affiche une description textuelle des personnage en combat aisi que leur PV
     *                          nomHero (40/95PV) / Gobelin (20/50PV)
     * @param hero Personnage joué par l'utilisateur
     * @param monstre Monstre
     */
    public void afficherPersonnageCombat(Hero hero, Monstre monstre) {
        afficher("\n\t\t\t  " + hero.getNom() + "(" + hero.getPV() + "/" + hero.getPVMax() + "PV) / " +
                monstre.getNom() + "(" + monstre.getPV() + "/" + monstre.getPVMax() + "PV)");
    }

    /**
     * Affiche le menu pour la création du personnage
     */
    public void afficherMenuCréationPersonnage() {
        afficher("\n======================== Création du Héro ========================\n" +
                "\t[1] Guerrier\n" +
                "\t[2] Mage\n" +
                "\t[3] Archer\n");
    }

    /**
     * Affiche toutes les actions possible à faire
     */
    public void afficherMenuPricipale() {
        afficher("\n======================== Menu Pricipale ========================\n" +
                     "\t[1] Voir le héros\n" +
                     "\t[2] Préparer un combat\n" +
                     "\t[3] Inventaire\n" +
                     "\t[4] Boutique\n" +
                     "\t[5] Taverne\n" +
                     "\t[6] Quêtes\n" +
                     "\t[0] Quitter\n");
    }

    /**
     * Affiche toutes les actions possible à faire avant un combat
     */
    public void afficherMenuPréparerCombat(Hero hero, Monstre monstre, boolean récompense, Quete quete) {
        afficher("\n======================== Préparer Combat ========================\n" +
                "\t[1] Gérer inventaire\n" +
                "\t[2] Commencer combat\n" +
                "\t[0] Retour\n");

        switch(readNextInt("Action à réaliser : ", 0, 2)) {
            case 1: afficherMenuInventaire(hero); afficherMenuPréparerCombat(hero, monstre, récompense, quete);break;
            case 2: Combat combat = new Combat(quete); combat.combattre(hero, monstre, récompense);
            case 0: break;
        }
    }

    /**
     * Affiche toutes les actions possible à faire durant un combat
     */
    public void afficherMenuCombat(Hero hero, Monstre monstre) {
        afficherPersonnageCombat(hero, monstre);
        afficherSansRetourLigne("=============================== Combat ===============================\n" +
                "\t[1] Attaquer\n" +
                "\t[2] " + hero.competenceSpecialeNom());

        if(hero instanceof Mage) {
            afficherSansRetourLigne(" (" + ((Mage)hero).getCoutCompétence() + " mana)");
        }

        afficher("\n\t[3] Utiliser objet\n" +
                "\t[0] Fuir\n");
    }

    /**
     * Affiche tous les objets de l'inventaire
     */
    public void afficherMenuInventaire(Hero hero) {
        afficher("\n=========================== Inventaire ===========================");

        if (hero.getInventaire().size() == 0) {
            afficher("\tAucun objet");
        } else {
            for (int i = 0; i < hero.getInventaire().size(); i++) {
                afficher("\t[" + (i + 1) + "] " + hero.getInventaire().get(i).toString());
            }
            afficher("\t[0] Annuler");

            int objetAUtiliser = readNextInt("\nObjet à utiliser : ", 0, hero.getInventaire().size());
            if(objetAUtiliser != 0) {
                if(hero.getInventaire().get(objetAUtiliser - 1) instanceof Arme) {
                    hero.equiperArme(objetAUtiliser - 1);
                } else {
                    hero.utiliserObjetIndex(objetAUtiliser-1);
                }
            }
        }
        readNextLine();
    }

    /**
     * Affiche tous les objets achetables dans la boutique
     */
    public void afficherMenuBoutique(Boutique boutique) {
        afficher("\n======================== Boutique ========================");
        for (int i = 0; i < boutique.getObjetsBoutique().size(); i++) {
            afficher("\t[" + (i + 1) + "] " + boutique.offre(boutique.getObjetsBoutique().get(i), boutique.getPrix().get(i)));
        }
        afficher("\t[0] Annuler\n");
    }

    /**
     * Affiche toutes les actions possible dans la taverne
     */
    public void afficherMenuTaverne(int prixRepos, boolean tavernierLà, boolean menuFin) {
        if(!menuFin) {
            if(tavernierLà) {
                afficher("\n=============================== Taverne ===============================\n" +
                             "\t[1] Se reposer(" + prixRepos + " Or)\n" +
                             "\t[2] Se battre avec le tavernier\n" +
                             "\t[0] Partir\n");
            } else {
                afficher("\n=============================== Taverne ===============================\n" +
                             "\t[1] Se reposer\n" +
                             "\t[0] Partir\n");
            }
        } else {
                afficher("\n=============================== Taverne ===============================\n" +
                         "\t[1] ...\n" +
                         "\t[0] Partir\n");
        }
    }

    /**
     * Affiche toutes les quêtes non-réaliser
     */
    public void afficherMenuQuetes(Quete quete) {
        afficher("\n============================ Quêtes ============================");
        for(int i = 0; i < quete.getQuetes().size(); i++) {
            if(quete.getQueteTerminer().get(i) == false) {
                afficherSansRetourLigne("\t[X] " + quete.getQuetes().get(i));
                if(i != 3) {
                    afficher(" -> Récompense : " + quete.getRécompense().get(i).getNom());
                } else {afficher("\n");}
            }
        }
        readNextLine();
    }

    /**
     * Affiche le game over
     */
    public void gameOver() {
        afficher("\n\n" +
                "███▀▀▀██ ███▀▀▀███ ███▀█▄█▀███ ██▀▀▀▀\n" +
                "██    ██ ██     ██ ██   █   ██ ██    \n" +
                "██   ▄▄▄ ██▄▄▄▄▄██ ██   ▀   ██ ██▀▀▀▀\n" +
                "██    ██ ██     ██ ██       ██ ██    \n" +
                "███▄▄▄██ ██     ██ ██       ██ ██▄▄▄▄\n\n" +
                "███▀▀▀███ ▀██     ██▀ ██▀▀▀ ██▀▀▀▀██▄\n" +
                "██     ██   ██   ██   ██    ██     ██\n" +
                "██     ██   ██   ██   ██▀▀▀ ██▄▄▄▄▄▀▀\n" +
                "██     ██   ██   ██   ██    ██     ██\n" +
                "███▄▄▄███     ▀█▀     ██▄▄▄ ██     ██▄\n");
        System.exit(0);
    }

    /**
     * Affiche le chrono du joueur et le générique de fin
     * @param startTime Heure de début du jeu
     * @throws InterruptedException Permet d'injterrompre le programme (pour faire l'effet du générique)
     */
    public void afficherGénériqueFin(long startTime) throws InterruptedException {
        long endTime = System.currentTimeMillis();
        long elapsedMillis = endTime - startTime;

        long elapsedSeconds = elapsedMillis / 1000;
        long heures = elapsedSeconds / 3600;
        long minutes = (elapsedSeconds % 3600) / 60;
        long secondes = elapsedSeconds % 60;

        for(int i = 0; i < 10; i++) {
            afficher("\n");
            Thread.sleep(200);
        }

        afficher("Bravo. vous avez fini le jeu en " + heures + "h " + minutes + "m " + secondes + "s.\n\n\n");
        Thread.sleep(2000);
        String[] credits = {
                "Développement",
                "  • Direction technique : Ethan Froidevaux",
                "  • Programmation : Ethan Froidevaux",
                "",
                "Scénario",
                "  • Conception narrative : Ethan Froidevaux",
                "  • Dialogues : Copilot",
                "",
                "Tests",
                "  • Testeurs : Ethan Froidevaux",
                "",
                "Production",
                "  • Producteur exécutif : Ethan Froidevaux",
                "  • Coordination : Ethan Froidevaux",
                "",
                "Remerciements",
                "  • À tous les joueurs qui ont vécu cette aventure",
                "",
                "Ce jeu a été réalisé avec passion et engagement.",
                "Chaque ligne de code raconte une histoire.",
                "",
                "Merci d’avoir joué.",
                "",
        };

        for (String ligne : credits) {
            System.out.println(ligne);
            Thread.sleep(1000); // 1 seconde entre chaque ligne pour un rythme solennel
        }

        afficher("░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░      ░▒▓████████▓▒░▒▓███████▓▒░░▒▓███████▓▒░  \n" +
                     "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                     "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                     "   ░▒▓█▓▒░   ░▒▓████████▓▒░▒▓██████▓▒░        ░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                     "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                     "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                     "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░      ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░  \n");


        System.exit(0);
    }
}
