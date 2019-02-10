package azadeh.ocs.affichage;

public class AfficheResultatRecherche {

    /**
     * affiche le resultat d'un tour de jeu de recherche à l'ecran
     */
    public void afficheResultatTour(int nbCase,int[] solution, int[] Proposition, String[] affichage) {
        String SolutionEcran = "";
        String resultatEcran = "";
        String affichageEcran = "";

        for (int i = 0; i < nbCase; i++) {
            SolutionEcran = SolutionEcran + +solution[i];
            resultatEcran = resultatEcran + Proposition[i];
            affichageEcran = affichageEcran + affichage[i];
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
