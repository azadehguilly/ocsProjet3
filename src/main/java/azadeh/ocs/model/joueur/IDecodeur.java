package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;

import java.util.List;

/**
 * IDecodeur est un interface pour le role attaquant
 *
 * @author Azadeh GUILLY
 * @version 1.0
 *
 */
public interface IDecodeur {

    /**
     * Cette méthode propose une combinaison dans la matrice des possibilité ou dans la liste des propositions
     *
     * Tout d'abord elle reduit la matrice des possibilités ou la liste des propositions (elle met à jour la listePropositions en effacant les propositions qui ne repondent pas à la solution)
     * Ensuite elle fait une proposition par rapport à la nouvelle matrice des possibilités ou la nouvelle liste
     * Finalement elle met à jour la derniereProposition avec cette valeur
     *
     * @param resultat
     *      le resultat de la derniere proposition
     * @return
     *      nouvelle proposition
     */
    public Proposition proposerUneCombinaison(IResultat resultat);


    /**
     * Choisir une proposition au hasard dans la listePropo
     * Cette fonction est public juste pour les tests unitaires, sinon il doit etre en private.
     *
     * @param listePropo
     *      liste des proposition dans la quelle nous allons choisir une proposition
     * @return
     *      une proposition qui existe dans la listePropo
     */
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo);

    /**
     * Setteur de derniereProposition
     *
     * @param derniereProposition
     */
    public void setDerniereProposition(Proposition derniereProposition);


}
