package azadeh.ocs.affichage;

import azadeh.ocs.Proposition;
import azadeh.ocs.Possibilite;

public class AfficheResultatRecherche {

    /**
     * affiche le resultat d'un tour de jeu de recherche à l'ecran
     */
    public void afficheResultatTour(Possibilite possibilite, Proposition solution, Proposition proposition) {
        String SolutionEcran = "";
        String resultatEcran = "";
        String affichageEcran = "";
/*
        for (int i = 0; i < nbCase; i++) {
            SolutionEcran = SolutionEcran + solution.getCombinaison()[i];
            resultatEcran = resultatEcran + proposition.getCombinaison()[i];
            affichageEcran = affichageEcran + possibilite.derniereEvaluation[i];
        }
        System.out.println("(Proposition secrète : " + SolutionEcran);
        System.out.println("");
        System.out.println("Proposition : " + resultatEcran + " -> Réponse : " + affichageEcran);
        */
    }


    public void AfficheResultatJeu(boolean isPartieGagnante) {
        if (isPartieGagnante)
            System.out.println("Bravo vous avez gagné !");
        else
            System.out.println("Vous avez perdu ! ");
    }
}
