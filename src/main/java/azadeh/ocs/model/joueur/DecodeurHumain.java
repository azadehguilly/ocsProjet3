package azadeh.ocs.model.joueur;

import azadeh.ocs.affichage.DemandeInfo;
import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;

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


    @Override
    public Proposition proposerUneCombinaison(IResultat rechercheResultat) {
        Proposition proposition = new Proposition();
        DemandeInfo demandeInfo = new DemandeInfo();
        proposition = demandeInfo.demandecombinaisonRecherche();
        return proposition;
    }


    @Override
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo) {
        return null;
    }


    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }


}


