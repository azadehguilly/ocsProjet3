package azadeh.ocs.affichage;

import azadeh.ocs.Combinaison;
import azadeh.ocs.Possibilite;

import static azadeh.ocs.App.nbCase;

public class AfficheResultatRecherche {

    /**
     * affiche le resultat d'un tour de jeu de recherche à l'ecran
     */
    public void afficheResultatTour(Possibilite possibilite, Combinaison solution, Combinaison proposition) {
        String SolutionEcran = "";
        String resultatEcran = "";
        String affichageEcran = "";

        for (int i = 0; i < nbCase; i++) {
            SolutionEcran = SolutionEcran + solution.getCombinaison()[i];
            resultatEcran = resultatEcran + proposition.getCombinaison()[i];
            affichageEcran = affichageEcran + possibilite.derniereEvaluation[i];
        }
        System.out.println("(Combinaison secrète : " + SolutionEcran);
        System.out.println("");
        System.out.println("Proposition : " + resultatEcran + " -> Réponse : " + affichageEcran);
    }


    public void AfficheResultatJeu(boolean isPartieGagnante) {
        if (isPartieGagnante) System.out.println("Bravo vous avez gagné !");
        else System.out.println("Vous avez perdu ! ");
    }
}