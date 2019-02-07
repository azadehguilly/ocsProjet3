package azadeh.ocs;

import org.apache.log4j.Logger;

import java.util.Scanner;



public class App {

    private static Logger logger = Logger.getLogger(App.class);


    public static void main(String[] args) {
        int nbCase = 4;
        int nbEssais = 3;
        int rejouer;


        Scanner sc = new Scanner(System.in);

        JeuRecherche jeu = new JeuRecherche(nbCase, nbEssais);

        do {
            jeu.lanceJeuRecherche();
            logger.debug("Vouslez vous rejouer le même jeu? tappez 1***********");
            System.out.println("Vouslez vous lancer un autre jeu (retour à l'écran de choix des jeux du début)? tappez 2");
            System.out.println("Vouslez vous quitter l'application? tapper 3");
            rejouer = sc.nextInt();
        } while (rejouer == 1);


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


    }
}
