package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultat;

import static azadeh.ocs.App.modeDeveloppeur;
import static azadeh.ocs.App.nbEssais;

public class Jeu implements IJeu {

    ICodeur codeur = null;
    IDecodeur decodeur = null;
    ICodeur codeurDuel = null;
    IDecodeur decodeurDuel = null;


    public Jeu() {
    }


    @Override
    public void initialiser(int nomJeu, int modeJeu) {
        if (nomJeu == 1) { // Recherche +/-
            switch (modeJeu) {
                case 1: //challenger
                    codeur = new CodeurOrdinateur();
                    decodeur = new DecodeurHumain();
                    break;
                case 2: //Defenseur
                    codeur = new CodeurHumain();
                    decodeur = new DecodeurOrdinateur();
                    break;
                case 3:
                    codeur = new CodeurOrdinateur();
                    decodeur = new DecodeurHumain();
                    codeurDuel = new CodeurHumain();
                    decodeurDuel = new DecodeurOrdinateur();
                    break;
            }
        } else if (nomJeu == 2) {// Mastermind
            switch (modeJeu) {
                case 1: //challenger
                    codeur = new CodeurOrdinateurMastermind();
                    decodeur = new DecodeurHumainMastermind();
                    break;
                case 2: //Defenseur
                    codeur = new CodeurHumainMastermind();
                    decodeur = new DecodeurOrdinateurMastermind();
                    break;
                case 3:
                    codeur = new CodeurOrdinateurMastermind();
                    decodeur = new DecodeurHumainMastermind();
                    codeurDuel = new CodeurHumainMastermind();
                    decodeurDuel = new DecodeurOrdinateurMastermind();
                    break;
            }
        }

    }
/*
    @Override
    public void lancerPartieRecherche() {
        AfficheResultat afficheResultat = new AfficheResultat();
        IResultat rechercheResultat = null;
        Proposition proposition = null;
        codeur.genereLaSolutionGagnante();
        if (modeDeveloppeur) {
            System.out.println("(Combinaison secrète : " + codeur.getSolutionGagnante().toString() + ")");
            System.out.println(" ");
        }
        int i = 0;
        boolean solutionTrouvee = false;
        do {
            // Le decodeur fait une proposition
            proposition = decodeur.proposerUneCombinaison(rechercheResultat);

            // La proposition est testée par le codeur qui retourne un résultat
            rechercheResultat = codeur.evaluerUneProposition(proposition);

            System.out.println("Proposition : " + proposition.toString() + " -> Réponse : " + rechercheResultat.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee = codeur.isPartieGagnante(rechercheResultat);
            //System.out.println("sol trouvé : " + solutionTrouvee);

            i++;
        } while (!solutionTrouvee && i < nbEssais);

        afficheResultat.afficheResultatJeu(solutionTrouvee);

    }
*/

    @Override
    public void lancerPartie() {
        AfficheResultat afficheResultat = new AfficheResultat();
        IResultat resultat = null;
        Proposition proposition = null;
        codeur.genereLaSolutionGagnante();
        if (modeDeveloppeur) {
            System.out.println("(Combinaison secrète : " + codeur.getSolutionGagnante().toString() + ")");
            System.out.println(" ");
        }
        int i = 0;
        boolean solutionTrouvee = false;
        do {
            // Le decodeur fait une proposition
            proposition = decodeur.proposerUneCombinaison(resultat);

            // La proposition est testée par le codeur qui retourne un résultat
            resultat = codeur.evaluerUneProposition(proposition);


            System.out.println("Proposition : " + proposition.toString() + " -> Réponse : " + resultat.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee = codeur.isPartieGagnante(resultat);
            //System.out.println("sol trouvé : " + solutionTrouvee);

            i++;
        } while (!solutionTrouvee && i < nbEssais);

        afficheResultat.afficheResultatJeu(solutionTrouvee);
    }


}
