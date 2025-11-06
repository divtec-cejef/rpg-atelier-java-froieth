package Base;

import Endroit.Taverne;
import Personnages.Hero;
import Personnages.TavernierBoss;

public class Fin {
    private ConsoleIO console = new ConsoleIO();
    private Taverne taverne;

    public Fin(Taverne taverne) {
        this.taverne = taverne;
    }

    public void lancerFin(Quete quete, Hero hero, long startTime) throws InterruptedException {
        boolean déclencherCombat = false;
        if(taverne.getOuvert() && taverne.getTavernierPrésent()) {
            // Fin si on ne s'est pas battu contre le tavernier
            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Tu as l’air fatigué, voyageur. Pose ton épée.\n\t\t\t\t\t\t\t\tIci, on ne se bat pas. On se repose. »");
            console.consomerRetourLigne();
            console.afficher(hero.getNom() + " :");
            console.afficher("« Je suis juste de passage. Mon chemin est encore long. »");
            console.consomerRetourLigne();
            console.afficher("\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Alors bois. Mange. Et écoute les histoires des vieux guerriers.\n\t\t\t\t\t\t\t\tPeut-être qu’un jour, tu en seras un. »");
            console.consomerRetourLigne();
        } else if(taverne.getOuvert()) {
            // Fin si on a battu le tavernier
            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Je ne suis pas là pour parler. Je ne suis pas là pour comprendre.\n\t\t\t\t\t\t\t\tJe suis là pour te faire payer. »");
            console.consomerRetourLigne();
            console.afficher(hero.getNom() + " :");
            console.afficher("« …Tavernier ?! »");
            console.consomerRetourLigne();
            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Tu m’as attaqué. Tu m’as humilié. Tu m’as laissé pour mort.\n\t\t\t\t\t\t\t\tEt je n’ai jamais oublié. »");
            console.consomerRetourLigne();
            console.afficher(hero.getNom() + " :");
            console.afficher("« Tu ne veux pas savoir pourquoi ? »");
            console.consomerRetourLigne();
            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Je m’en fous. Ce que je veux, c’est te voir à genoux. »");
            console.consomerRetourLigne();
            déclencherCombat = true;
        } else {
            // Fin si on s'est enfui du combat contre le tavernier
            console.afficher("\n\n\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Tu m’as laissé entre deux souffles, héros.\n\t\t\t\t\t\t\t\tTu as fui le poids de tes actes. »\n");
            console.consomerRetourLigne();
            console.afficher(hero.getNom() + " :");
            console.afficher("« Je ne pensais pas te revoir.\n\tJe croyais que ce combat était derrière moi. »\n");
            console.consomerRetourLigne();
            console.afficher("\t\t\t\t\t\t\tTavernier :");
            console.afficher("\t\t\t\t\t\t\t« Ce combat n’a jamais eu de fin.\n\t\t\t\t\t\t\t\tEt je suis venu pour lui en donner une. »\n");
            console.consomerRetourLigne();
            déclencherCombat = true;
        }

        if(déclencherCombat) {
            Combat combat = new Combat(quete);
            combat.combattre(hero, new TavernierBoss(), false);
        }

        console.afficherGénériqueFin(startTime);
    }






}
