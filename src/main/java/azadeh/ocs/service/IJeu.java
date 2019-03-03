package azadeh.ocs.service;

/**
 * Cette interface permet dinitialiser un jeu puis le lancer
 * Elle n'est pas complet.
 * Je voulais utiliser le designe pattern factory pour initialiser un jeu.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public interface IJeu {

    /**
     * Initialise un jeu Recherche +/- ou Mastermind avec le bon attaquant et defenseur
     *
     * @param nomJeu
     *      1. Recherche +/-  2. Mastermind  3.Sortir
     * @param modeJeu
     *      1. Challenger 2. Défenseur 3. Duel
     */
    public void initialiser(int nomJeu, int modeJeu);


    /**
     * Lance une partie avec un 1 joueur
     */
    public void lancerPartie();


    /**
     * Lance une partie avec 2 joueurs
     */
    public void lancerPartieDual();
}
