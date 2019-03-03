package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.MastermindResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.jeu.RechercheResultat;

/**
 * ICodeur est un interface pour le role de defenseur
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public interface ICodeur {

    /**
     * Générer la Solution gagnante
     */
    public void genereLaSolutionGagnante();

    /**
     * Cette méthode nous donne le resultat d'un tour
     *
     * @param prop
     *      est la proposition de l'attaquant.
     * @return
     *      un objet de type IResultat
     * @see IResultat
     * @see MastermindResultat
     * @see RechercheResultat
     */
    public IResultat evaluerUneProposition(Proposition prop);


    /**
     * Verifie si le resultat est gagnant.
     *
     * @param resultat
     *      resultat à verifier
     * @return
     *      true si la partie est gagné. false sinon
     */
    public boolean isPartieGagnante(IResultat resultat);


    /**
     * Getteur de la solutionGagnante
     *
     * @return
     *      la solution gagnante
     */
    public Proposition getSolutionGagnante();
}
