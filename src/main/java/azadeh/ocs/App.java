package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;
import org.apache.log4j.Logger;

import java.util.Scanner;


public class App {
    public static int nbCase = 4;
    public static int nbEssais = 10;
    public static String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


    private static Logger logger = Logger.getLogger(App.class);


    public static void main(String[] args) {

        int rejouer;
/*
        switch (mode) {
            case "D": { //defenseur
                codeur = new CodeurHumain();
                decodeur = new DecodeurOrdinateur();
                break;
            }
            case "C": { //Challenger
                codeur = new CodeurOrdinateur();
                decodeur = new DecodeurHumain();
                break;
            }
        }
        */



        // JeuRechercheChallenger jeuRechercheChallenger = new JeuRechercheChallenger(nbCase, nbEssais);
        //JeuRechercheDefenseur jeuRechercheDefenseur = new JeuRechercheDefenseur(nbCase, nbEssais);
/*
        do {
            //jeuRechercheChallenger.lanceJeuRecherche();
            //jeuRechercheDefenseur.lanceJeuRecherche();
            Jeu jeu = new Jeu();
            jeu.lanceJeuRecherche("D");
            logger.debug("Vouslez vous rejouer le même jeu? tappez 1");
            System.out.println("Vouslez vous lancer un autre jeu (retour à l'écran de choix des jeux du début)? tappez 2");
            System.out.println("Vouslez vous quitter l'application? tapper 3");
            rejouer = sc.nextInt();
            if (rejouer == 1) {
                //jeuRechercheChallenger = new JeuRechercheChallenger(nbCase, nbEssais);
                //jeuRechercheDefenseur = new JeuRechercheDefenseur(nbCase, nbEssais);
                jeu.lanceJeuRecherche("D");
            }
        } while (rejouer == 1);
*/

        //Mode développeur
        // boolean modeDeveloppeur = false;

        //Plateau plateau = new Plateau(1, 1, modeDeveloppeur);
        //Jeux :1. Recherche + / - 2. Mastermind


        //Modes :1. Mode challenger 2. Mode défenseur 3. duel


        //L'utilisateur joue. S'il perd, l'application affiche la solution.


        //À la fin de la partie, l'utilisateur peut choisir :
        // 1. de rejouer au même jeu
        // 2. de lancer un autre jeu (retour à l'écran de choix des jeux du début)
        // 3.de quitter l'application



        /* tester demandeInfoRecherche.demandecombinaisonRecherche()
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        Proposition proposition = new Proposition();
        proposition = demandeInfoRecherche.demandecombinaisonRecherche();
        System.out.println("la proposition tapper à l ecran est : " + proposition.toString());
*/
        /* tester demandeInfoRecherche.evaluerUnePropositionConsole()
        Resultat resultat = new Resultat();
        resultat = demandeInfoRecherche.evaluerUnePropositionConsole(proposition);
        System.out.println("le resultat tapper à l ecran est : " + resultat.toString());
*/



        IJeu jeu = new Jeu();
        jeu.initialiser(0, 0);

        jeu.lancerPartie();

    }
}
