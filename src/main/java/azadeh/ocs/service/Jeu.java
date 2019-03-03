package azadeh.ocs.service;

import azadeh.ocs.affichage.AfficheResultat;
import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.joueur.*;

import static azadeh.ocs.App.modeDeveloppeur;
import static azadeh.ocs.App.nbEssais;

/**
 * Jeu est la classe qui initialise le jeu puis le lance.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 * @see IJeu
 */
public class Jeu implements IJeu {
    /**
     * Le codeur est le defenseur de jeu
     */
    ICodeur codeur = null;

    /**
     * Le decodeur est l'attaquant de jeu
     */
    IDecodeur decodeur = null;

    /**
     * Le codeurDuel est le deuxieme defenseur de jeu pour le mode Dual
     */
    ICodeur codeurDuel = null;

    /**
     * Le decodeur est le deuxieme attaquant de jeu pour le mode Dual
     */
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
                    codeur = new CodeurHumain();
                    decodeur = new DecodeurOrdinateur();
                    codeurDuel = new CodeurOrdinateur();
                    decodeurDuel = new DecodeurHumain();
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
                    codeur = new CodeurHumainMastermind();
                    decodeur = new DecodeurOrdinateurMastermind();
                    codeurDuel = new CodeurOrdinateurMastermind();
                    decodeurDuel = new DecodeurHumainMastermind();
                    break;
            }
        }

    }

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

        afficheResultat.afficheResultatJeu(solutionTrouvee, codeur.getSolutionGagnante());

    }


    public void lancerPartieDual() {
        AfficheResultat afficheResultat1 = new AfficheResultat();
        AfficheResultat afficheResultat2 = new AfficheResultat();
        IResultat resultat1 = null;
        IResultat resultat2 = null;
        Proposition proposition1 = null;
        Proposition proposition2 = null;
        //joueur1 humain
        System.out.println("Joueur 1 : ");
        codeur.genereLaSolutionGagnante();
        //joueur2 ordinateur
        codeurDuel.genereLaSolutionGagnante();
        if (modeDeveloppeur) {
            System.out.println("(Combinaison secrète de joueur 1 est : " + codeur.getSolutionGagnante().toString() + ")");
            System.out.println(" ");
            System.out.println("(Combinaison secrète de joueur 2 est : " + codeurDuel.getSolutionGagnante().toString() + ")");
            System.out.println(" ");
        }
        int i = 0;
        boolean solutionTrouvee1 = false;
        boolean solutionTrouvee2 = false;
        do {

            // Le decodeur fait une proposition
            //ordinateur
            proposition1 = decodeur.proposerUneCombinaison(resultat1);
            //joueur1 humain
            System.out.println("Joueur 1: ");
            proposition2 = decodeurDuel.proposerUneCombinaison(resultat2);

            //joueur1
            System.out.println("Joueur 1: ");
            // La proposition est testée par le codeur qui retourne un résultat
            resultat1 = codeur.evaluerUneProposition(proposition1);
            System.out.println("Proposition : " + proposition1.toString() + " -> Réponse : " + resultat1.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee1 = codeur.isPartieGagnante(resultat1);

            //joueur2
            System.out.println("Joueur 2: ");
            // La proposition est testée par le codeur qui retourne un résultat
            resultat2 = codeurDuel.evaluerUneProposition(proposition2);
            System.out.println("Proposition : " + proposition2.toString() + " -> Réponse : " + resultat2.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee2 = codeurDuel.isPartieGagnante(resultat2);


            i++;
        } while (!solutionTrouvee1 && !solutionTrouvee2 && i < nbEssais);


        System.out.println("Joueur 1: ");
        afficheResultat1.afficheResultatJeu(solutionTrouvee1, codeur.getSolutionGagnante());
        System.out.println("Joueur 2: ");
        afficheResultat2.afficheResultatJeu(solutionTrouvee2, codeurDuel.getSolutionGagnante());

    }

}
