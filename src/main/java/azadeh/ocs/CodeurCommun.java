package azadeh.ocs;

import static azadeh.ocs.App.nbCase;

public class CodeurCommun {

    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     * met à jour la matrice de possibilité avec la derniereEvaluation
     *
     * @ param Combinais on prop, Combinaison sol, Possibilité possib
     * @return possibilite
     */

    public Possibilite evaluerUneProposition(Combinaison prop, Combinaison sol, Possibilite possib) {
        Possibilite possibilite = new Possibilite();
        int tailleNouveauTableau = 0;
        int varTemporaire = 0;
        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i])) {
                possibilite.derniereEvaluation[i] = "=";
                possibilite.matricePossibilite[i] = new String[1];
                possibilite.matricePossibilite[i][0] = prop.getCombinaison()[i];
            } else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i])) {
                possibilite.derniereEvaluation[i] = "+";
                tailleNouveauTableau = 0;
                tailleNouveauTableau = possib.matricePossibilite[i].length - Integer.parseInt(prop.getCombinaison()[i]) - 1;
                possibilite.matricePossibilite[i] = new String[tailleNouveauTableau];//creer la bonne taille de tableau
                for (int j = 0; j < tailleNouveauTableau; j++) {
                    varTemporaire = (Integer.parseInt(prop.getCombinaison()[i])+1+j);
                    possibilite.matricePossibilite[i][j] = "" + varTemporaire;
                }
            } else {
                possibilite.derniereEvaluation[i] = "-";
                tailleNouveauTableau = 0;
                tailleNouveauTableau = Integer.parseInt(prop.getCombinaison()[i]);
                possibilite.matricePossibilite[i] = new String[tailleNouveauTableau];//creer la bonne taille de tableau
                for (int j = 0; j < tailleNouveauTableau; j++) {
                    possibilite.matricePossibilite[i][j] = "" + j;
                }
            }
        }
        return possibilite;
    }

/* @Override
    public String[] evaluerUneProposition(Combinaison prop, Combinaison sol) {
        String[] evaluation = new String[nbCase];
        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i])) evaluation[i] = "=";
            else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i]))
                evaluation[i] = "+";
            else evaluation[i] = "-";
        }
        return evaluation;
    }*/


    /**
     * Verifie si la séquance est trouvé.
     */
    public boolean isPartieGagnante(Combinaison prop, Combinaison sol) {
        int egalite = 0;
        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i])) {
                egalite += 1;
            }
        }
        if (egalite == nbCase) {
            return true;
        }
        return false;
    }
}


