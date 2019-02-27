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


        IJeu jeu = new Jeu();
        jeu.initialiser(nomJeu, modeJeu);

        jeu.lancerPartie();
    }
}
