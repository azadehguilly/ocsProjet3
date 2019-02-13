/*package supp;

import azadeh.ocs.affichage.DemandeInfoRecherche;

import java.util.concurrent.ThreadLocalRandom;


public class JeuRechercheDefenseur extends Jeu {


    public JeuRechercheDefenseur(int nbCase, int nbEssais) {
        super(nbCase, nbEssais);
    }

    /**
     * fait une proposition pour le jeu de recherche en prenant en compte la proposition du tour precedent
     * met à jour l'attribut proposition
     * @return un tableau de propotiotion en plus de mettre à jour l'attribut

    public int[] lanceRandomRechercheParrapportTourPrecedent() {
        int[] resultat = new int[this.nbCase];
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
        resultat = this.proposition;
        return resultat;
    }

    /**
     * Choisir la Solution

    @Override
    public int[] choisirSolution( int nombrebCase){
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        int[] resultat = demandeInfoRecherche.demandecombinaisonRecherche(nombrebCase);
        return resultat;
    }

    /**
     * Fait une proposition pour un tour


    public int[] faitUneProposition(int nombrebCase) {
        int[] resultat = new int[nombrebCase];
        resultat = this.lanceRandomRechercheParrapportTourPrecedent();
        return resultat;
    }



    public void lanceJeuRechercheDefenseur() {
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();

        this.solution = demandeInfoRecherche.demandecombinaisonRecherche(this.nbCase);

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
*/