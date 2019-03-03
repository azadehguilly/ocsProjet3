package azadeh.ocs.affichage;

import azadeh.ocs.model.jeu.Proposition;

/**
 * AfficheResultat est la classe qui affiche tout les réultats des jeux à l'écran
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class AfficheResultat {

    /**
     * Affiche le resultat d'un tour de jeu à l'écran
     *
     * @param isPartieGagnante
     *      est vrai si la partie est gagnante
     */
    public void afficheResultatJeu(boolean isPartieGagnante, Proposition solGagnante) {
        if (isPartieGagnante)
            System.out.println("Bravo vous avez gagné !");
        else
            System.out.println("Vous avez perdu ! La solution était :" + solGagnante.toString());
    }

}
