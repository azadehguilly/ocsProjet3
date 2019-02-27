package azadeh.ocs;

import java.util.List;

/**
 * ICodeur est un interface pour le role attaquant
 */
public interface IDecodeur {

    /**
     * Cette méthode propose une combinaison dans la matrice des possibilité
     * Tout d'abord elle reduit la matrice des possibilités
     * Ensuite elle fait une proposition par rapport à la nouvelle matrice des possibilités
     *
     * @param rechercheResultat
     * @return
     */
    public Proposition proposerUneCombinaison(IResultat rechercheResultat);

    /**
     * Setteur de derniereProposition
     *
     * @param derniereProposition
     */
    public void setDerniereProposition(Proposition derniereProposition);


    /**
     * Cette méthode propose une combinaison dans la liste des propositions
     * Tout d'abord elle reduit la liste des propositions: elle met à jour la listePropositions en effacant les propositions qui ne repondent pas à la solution
     * Ensuite elle choisit une proposition parmis la nouvelle liste
     * Et elle met à jour la derniereProposition avec cette valeur
     *
     * @param resultat
     * @return combinaison
     */
    //public Proposition proposerUneCombinaison(int resultat);

    /**
     * Choisir une proposition au hasard dans la listePropo
     * Cette fonction est public juste pour les tests unitaires, sinon il doit etre en private.
     *
     * @param listePropo
     * @return
     */
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo);

}
