package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultatRecherche;
import azadeh.ocs.affichage.DemandeInfoRecherche;

import java.util.concurrent.ThreadLocalRandom;


public class JeuRechercheDefenseur extends Jeu {


    public JeuRechercheDefenseur(int nbCase, int nbEssais) {
        super(nbCase, nbEssais);
    }

    /**
     * fait une proposition pour le jeu de recherche en prenant en compte la proposition du tour precedent
     * met à jour l'attribut solution
     */
    public void lanceRandomRechercheParrapportTourPrecedent() {
        for (int i = 0; i < this.nbCase; i++) {
            if (this.proposition[i] == -1) {
                this.proposition[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
            } else if (this.proposition[i] < this.solution[i]) {
                this.min[i] = proposition[i] + 1;
                this.proposition[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
            } else if (this.proposition[i] > this.solution[i]) {
                this.max[i] = proposition[i] - 1;
                this.proposition[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
            } else // (this.proposition[i] == this.solution[i]) {
                this.proposition[i] = this.proposition[i];
        }
    }

    /**
     * lance un tour de jeu de recherche en mode Defenseur
     */
    public void lanceJeuRechercheDefenseur() {
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        this.solution = demandeInfoRecherche.demandecombinaisonRecherche(this.nbCase);
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();

        int i = 0;
        while (!isPartieGagnante() && i < nbEssais) {
            this.lanceRandomRechercheParrapportTourPrecedent();
            this.calculResultatRecherche();
            afficheResultatRecherche.afficheResultatTour(this.nbCase, this.solution, this.proposition, this.affichage);
            i++;
        }

        afficheResultatRecherche.AfficheResultatJeu(isPartieGagnante());
    }

}