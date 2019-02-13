package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultatRecherche;

import static azadeh.ocs.App.nbEssais;

public class Jeu {

    public Jeu() {
    }

    /**
     * lance un tour de jeu de recherche
     * mode D : defenseur ou C : Chellenger
     */
    public void lanceJeuRecherche(String mode) {
        Codeur codeur = null;
        Decodeaur decodeur = null;
        switch (mode) {
            case "D": { //defenseur
                codeur = new CodeurHumain();
                decodeur = new DecodeurOrdinateur();
                break;
            }
            case "C": { //Challenger
                codeur = new CodeurOrdinateur();
                decodeur = new DecodeurHumain();
                break;
            }
        }

        Combinaison solution = new Combinaison();
        Combinaison proposition = new Combinaison();
        Possibilite possibilite = new Possibilite();
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();
        int i = 0;
        solution = codeur.genereLaSolutionGagnante(possibilite);
        do {
            proposition = decodeur.proposerUneCombinaison(possibilite);
            possibilite = codeur.evaluerUneProposition(proposition, solution, possibilite);
            afficheResultatRecherche.afficheResultatTour(possibilite, solution, proposition);
            i++;
        } while (!codeur.isPartieGagnante(proposition, solution) && i < nbEssais);
        afficheResultatRecherche.AfficheResultatJeu(codeur.isPartieGagnante(proposition, solution));
    }
}
