package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;

public class DecodeurHumain implements Decodeaur{


    /**
     * Propose une combinaison par rapport à un matrice de possibilité
     * @param possibilite
     * @return combinaison
     */
    @Override
    public Combinaison proposerUneCombinaison(Possibilite possibilite) {
        Combinaison combinaison = new Combinaison();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        combinaison = demandeInfoRecherche.demandecombinaisonRecherche();
        return combinaison;
    }


}


