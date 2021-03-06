package azadeh.ocs.model.joueur;

import azadeh.ocs.affichage.DemandeInfo;
import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;

import java.util.List;

/**
 * Le decodeur est celui qui joue le role d'attaquant pour le jeu Mastermind
 * DecodeurHumainMastermind est donc un humain qui joue le role de decodeur. Il donne des instruction par le console.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class DecodeurHumainMastermind implements IDecodeur {

    /**
     * Propose une combinaison au console
     *
     * @param resultat
     *      resultat
     * @return
     *      une proposition
     * @see Proposition
     */
    @Override
    public Proposition proposerUneCombinaison(IResultat resultat) {
        DemandeInfo demandeInfo = new DemandeInfo();
        return demandeInfo.demandecombinaisonMastermind();
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     *
     * @param listePropo
     * @return null
     */
    @Override
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo) {
        return null;
    }


    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     *
     * @param derniereProposition
     */
    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
    }
}
