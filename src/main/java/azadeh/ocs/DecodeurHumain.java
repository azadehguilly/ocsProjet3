package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfo;

import java.util.List;

/**
 * Le decodeur est celui qui joue le role d'attaquant pour le jeu Recherche +/-
 * DecodeurHumain est donc un humain qui joue le role de decodeur. Il donne des instruction par le console.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class DecodeurHumain implements IDecodeur {
    /**
     * derniereProposition est un objet de type Proposition qui contient la derniere proposition faite par l'attaquant
     *
     * @see Proposition
     */
    private Proposition derniereProposition;

    /**
     * Propose une combinaison au console
     *
     * @param resultat n'est pas utilisé dans cette classe
     * @return
     *      une proposition
     * @see Proposition
     */
    @Override
    public Proposition proposerUneCombinaison(Resultat resultat) {
        Proposition proposition = new Proposition();
        DemandeInfo demandeInfo = new DemandeInfo();
        proposition = demandeInfo.demandecombinaisonRecherche();
        return proposition;
    }

    /**
     * Setteur de derniereProposition
     *
     * @param derniereProposition
     */
    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     *
     * @param resultat
     * @return null
     */
    @Override
    public Proposition proposerUneCombinaison(int resultat) {
        return null;
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     * La fonction est public pour être visible dans les tests unitaires.
     *
     * @param listePropo
     * @return null
     */
    @Override
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo) {
        return null;
    }

}


