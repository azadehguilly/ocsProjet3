package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultatRecherche;
import azadeh.ocs.affichage.DemandeInfoRecherche;

import java.util.concurrent.ThreadLocalRandom;


public class JeuRechercheChallenger extends Jeu {

    public JeuRechercheChallenger(int nbCase, int nbEssais) {
        super(nbCase, nbEssais);
    }


    /**
     * Choisi une solution au hasard
     * @return la solution choisi au hasard
     */
    public void lanceRandomRecherche() {
        for (int i = 0; i < this.nbCase; i++)
            this.solution[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
    }


    /**
     * lance un tour de jeu de recherche en mode Cahllenger
     */
    public void lanceJeuRechercheChallenger() {
        this.lanceRandomRecherche();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();
        int i = 0;
        do {
            this.proposition = demandeInfoRecherche.demandecombinaisonRecherche(this.nbCase);
            this.calculResultatRecherche();
            afficheResultatRecherche.afficheResultatTour(this.nbCase, this.solution, this.proposition, this.affichage);
            i++;
        } while (!isPartieGagnante() && i < nbEssais);

        afficheResultatRecherche.AfficheResultatJeu(isPartieGagnante());
    }


}
