package azadeh.ocs;

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
     * @param resultat
     * @return vrai si la bonne réultat est trouvé
     */
    public boolean isPartieGagnante(Resultat resultat) {
        boolean isFound = true;
        for (String resultatAtColumn : resultat.getResultats()) {
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
     * @return vrai si la bonne réultat est trouvé
     */
    public boolean isPartieGagnante(int resultat) {
        boolean isFound = false;
        if (resultat == nbCase * 10)
            isFound = true;
        return isFound;
    }

}


