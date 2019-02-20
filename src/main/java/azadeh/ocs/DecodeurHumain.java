package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;

public class DecodeurHumain implements IDecodeur{

    private Proposition derniereProposition;

    /**
     * Propose une combinaison au console
     *
     * @return combinaison
     */
    @Override
    public Proposition proposerUneCombinaison(Resultat resultat) {
        Proposition proposition= new Proposition();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        proposition = demandeInfoRecherche.demandecombinaisonRecherche();
        return proposition;
    }

    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }
}


