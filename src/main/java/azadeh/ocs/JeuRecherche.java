package azadeh.ocs;

import java.util.Random;
import java.util.Scanner;

public class JeuRecherche {

    private int nbCase;
    private int nbEssais;
    private int[] solution;
    private int[] resultat;
    private String[] affichage;


    Scanner sc = new Scanner(System.in);


    public JeuRecherche(int nbCase, int nbEssais) {
        this.nbCase = nbCase;
        this.nbEssais = nbEssais;
        this.solution = new int[this.nbCase];
        this.resultat = new int[this.nbCase];
        this.affichage = new String[this.nbCase];
    }


    /**
     * lance une solution en random pour le jeu de recherche
     * met à jour l'attribut solution
     */
    public void lanceRandomRecherche() {
        // génération de nombre aleatoire >= 0 et < 10
        Random r = new Random();
        for (int i = 0; i < this.nbCase; i++) {
            this.solution[i] = r.nextInt(10);
        }
    }

    /**
     * Demande de rentrer n chiffres pour le jeu de recherche
     * met à jour l'attribut resultat
     */
    public void demandeCombinaisonRecherche() {
        for (int i = 0; i < this.nbCase; i++) {
            System.out.println("Tapper un chiffre de 0 à 9");
            this.resultat[i] = sc.nextInt();
        }
    }


    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     * met à jour l'attribut affichage
     */
    public void calculResultatRecherche() {
        for (int i = 0; i < this.nbCase; i++) {
            if (this.resultat[i] == this.solution[i]) this.affichage[i] = "=";
            else if (this.resultat[i] < this.solution[i]) this.affichage[i] = "+";
            else this.affichage[i] = "-";
        }
    }

    /**
     * la partie est gagnante
     */
    public boolean isPartieGagnante() {
        int egalite = 0;
        for (int i = 0; i < this.nbCase; i++) {
            if (this.resultat[i] == this.solution[i]) {
                egalite += 1;
            }
        }
        if (egalite == this.nbCase) {
            System.out.println("Bravo vous avez gagné !");
            return true;
        }
        return false;
    }


    /**
     * affiche le resultat d'un tour de jeu de recherche à l'ecran
     */
    public void afficheResultatTour() {
        String SolutionEcran = "";
        String resultatEcran = "";
        String affichageEcran = "";

        for (int i = 0; i < this.nbCase; i++) {
            SolutionEcran = SolutionEcran + +this.solution[i];
            resultatEcran = resultatEcran + this.resultat[i];
            affichageEcran = affichageEcran + this.affichage[i];
        }
        System.out.println("(Combinaison secrète : " + SolutionEcran);
        System.out.println("");
        System.out.println("Proposition : " + resultatEcran + " -> Réponse : " + affichageEcran);
    }

    /**
     * lance un tour de jeu de recherche
     */
    public void lanceJeuRecherche() {

        this.lanceRandomRecherche();
        int i = 0;
        do {
            this.demandeCombinaisonRecherche();
            this.calculResultatRecherche();
            this.afficheResultatTour();
            i++;
        } while (!isPartieGagnante() && i < nbEssais);

        if (i == nbEssais) System.out.println("Vous avez perdu ! ");
    }


}
