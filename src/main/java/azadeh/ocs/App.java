package azadeh.ocs;


import azadeh.ocs.affichage.DemandeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * App est la classe main qui lance un Jeu
 *
 * @see Jeu
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class App {
    public static int nbCase = 4; //nb Trous
    public static int nbEssais = 20;
    public static String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    //public static String[] symbols = {"0", "1", "2"}; //couleurs
    public static boolean modeDeveloppeur = true;

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());

    /**
     * Main du jeu qui initizlise un Jeu et lance une partie.
     *
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("Demarrage application ! ");

        int rejouer;
        DemandeInfo demandeInfo = new DemandeInfo();

        int nomJeu = demandeInfo.demandeNomJeu(); //1. Recherche +/-  2. Mastermind
        int modeJeu = demandeInfo.demandeModeJeu(); //1. Challenger 2. Défenseur 3. Duel


        //L'utilisateur joue. S'il perd, l'application affiche la solution.


        //À la fin de la partie, l'utilisateur peut choisir :
        // 1. de rejouer au même jeu
        // 2. de lancer un autre jeu (retour à l'écran de choix des jeux du début)
        // 3.de quitter l'application




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



        IJeu jeu = new Jeu();
        jeu.initialiser(nomJeu, modeJeu);

        jeu.lancerPartieRecherche();
        //jeu.lancerPartieMastermind();
    }
}
