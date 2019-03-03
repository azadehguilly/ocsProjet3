package azadeh.ocs;


import azadeh.ocs.affichage.DemandeInfo;
import azadeh.ocs.exceptions.JeuException;
import azadeh.ocs.service.IJeu;
import azadeh.ocs.service.Jeu;
import azadeh.ocs.technique.LireFichierProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * App est la classe main qui lance un Jeu
 *
 * @author Azadeh GUILLY
 * @version 1.0
 * @see Jeu
 */
public class App {

    /**
     * LOGGER pour loger dans un ficher les points essentiel à tracer pour pouvoir gerer les erreur, les bugs et les infos.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());

    /**
     * nombre de case pour le jeux Recherche +/- et nombre de trous pour le jeux Mastermind
     */
    public static int nbCase = 0;

    /**
     * Nombre d'essai qu'un joueur a pour trouver la solution gagnante
     */
    public static int nbEssais = 0;

    /**
     * les symboles possible pour les jeux. Ici ce sont des chiffres
     */
    public static String[] symbols = null;

    /**
     * les symboles possible pour les jeux Recherche +/- que nous avons lu du fichier config.properties
     */
    public static String[] symbolsRechercheTable = null;

    /**
     * les symboles possible pour les jeu Mastermind que nous avons lu du fichier config.properties
     */
    public static String[] symbolsMastermindTable = null;
    /**
     * Mode developpeur egale à vrai, permet d'afficher la solution gagnante,  à l'ecran.
     */
    public static boolean modeDeveloppeur = false;


    /**
     * Main du jeu.
     * Il importe les parametres du fichier config.properties.
     * Initizlise un Jeu
     * Lance une partie
     * Redemande si l'utilisateur veut rejouer ou pas
     *
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("Demarrage application ! ");

        int nomJeu = 0;
        int modeJeu = 0;

        modeDev(args);
        do {

            DemandeInfo demandeInfo = new DemandeInfo();
            nomJeu = demandeInfo.demandeNomJeu(); //1. Recherche +/-  2. Mastermind  3.Sortir
            if (nomJeu == 3) break;
            modeJeu = demandeInfo.demandeModeJeu(); //1. Challenger 2. Défenseur 3. Duel

            //alimentation de symbols
            if (nomJeu == 1) {
                symbols = new String[symbolsRechercheTable.length];
                System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);
            } else {
                symbols = new String[symbolsMastermindTable.length];
                System.arraycopy(symbolsMastermindTable, 0, symbols, 0, symbolsMastermindTable.length);
            }


            IJeu jeu = new Jeu();
            jeu.initialiser(nomJeu, modeJeu);

            try {
                switch (modeJeu) {
                    case 3: //dual
                        jeu.lancerPartieDual();
                        break;

                    default:
                        jeu.lancerPartie();
                        break;
                }
            } catch (JeuException e) {
                LOGGER.error("Impossible de trouver une solution, les resultats que vous avez donné sont incorrects, Vous avez triché ;)");
            }
        } while (nomJeu != 3);
    }


    private static void modeDev(String[] args) {
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();

        String modeDeveloppeurString = System.getProperty("modeDeveloppeur");
        if (modeDeveloppeurString.equals("true"))
            modeDeveloppeur = true;
        else System.out.println("Le mode developpeur n'est pas déclanché");

    }
}