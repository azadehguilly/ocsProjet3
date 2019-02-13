/*
package supp;


import azadeh.ocs.affichage.DemandeInfoRecherche;

import java.util.concurrent.ThreadLocalRandom;


public class JeuRechercheChallenger extends Jeu {

    public JeuRechercheChallenger(int nbCase, int nbEssais) {
        super(nbCase, nbEssais);
    }



     * Choisi une solution au hasard
     * @return la solution choisi au hasard

    public void lanceRandomRecherche() {
        for (int i = 0; i < this.nbCase; i++)
            this.solution[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
    }



     * Choisir la Solution

    @Override
    public int[] choisirSolution( int nombrebCase){
        int[] resultat = new int[nombrebCase];
        for (int i = 0; i < nombrebCase; i++)
            resultat[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
        return resultat;
    }


     * Fait une proposition pour un tour


    public int[] faitUneProposition(int nombrebCase) {
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        int[] resultat = demandeInfoRecherche.demandecombinaisonRecherche(nombrebCase);
        return resultat;
    }


    /**
     * lance un tour de jeu de recherche en mode Cahllenger

    public void lanceJeuRechercheChallenger() {
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();

        this.lanceRandomRecherche();

        int i = 0;
        do {
            this.proposition = demandeInfoRecherche.demandecombinaisonRecherche(this.nbCase);
            this.calculResultatRecherche();
            afficheResultatRecherche.afficheResultatTour(this.nbCase, this.solution, this.proposition, this.affichage);
            i++;
        } while (!isPartieGagnante() && i < nbEssais);

        afficheResultatRecherche.AfficheResultatJeu(isPartieGagnante());
    }



     * lance un tour de jeu de recherche en mode Cahllenger

    public void lanceJeuRechercheChallenger() {
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();

        this.lanceRandomRecherche();

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

*/