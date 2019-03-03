package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.MastermindResultat;
import azadeh.ocs.model.jeu.RechercheResultat;

import static azadeh.ocs.App.nbCase;

/**
 * CodeurCommun est la classe qui contient les méthodes commun au CodeurOrdinateur, CodeurHumain, CodeurOrdinateurMastermind et CodeurHumainMastermind
 *
 * @author Azadeh GUILLY
 * @version 1.0
 * @see CodeurOrdinateur
 * @see CodeurHumain
 * @see CodeurOrdinateurMastermind
 * @see CodeurHumainMastermind
 */
public abstract class CodeurCommun {


    /**
     * Verifie si la partie est gagnante pour le jeu recherche +/-
     *
     * @param rechercheResultat
     *      resultat donnée que nous voulons de tester
     * @return
     *      vrai si la bonne réultat est trouvé
     */
    public boolean isPartieGagnante(RechercheResultat rechercheResultat) {
        boolean isFound = true;
        for (String resultatAtColumn : rechercheResultat.getResultats()) {
            if (!"=".equals(resultatAtColumn)) {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    /**
     * Verifie si la partie est gagnante pour le jeu Mastermind
     *
     * @param resultat
     *      resultat donnée que nous voulons de tester
     * @return
     *      vrai si la bonne réultat est trouvé
     */
    public boolean isPartieGagnante(MastermindResultat resultat) {
        boolean isFound = false;
        if (resultat.getResultat() == nbCase * 10)
            isFound = true;
        return isFound;
    }

}


