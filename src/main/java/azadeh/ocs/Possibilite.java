package azadeh.ocs;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbole;

public class Possibilite {
    public String[][] matricePossibilite; //0 à 9 , nbCasse fois (min et max de la possibilité) toute les possibilité
    public String[] derniereEvaluation; //contient +, - et = pour le jeu de recherche

    public Possibilite() {
        this.matricePossibilite = new String[nbCase][symbole.length];
        this.derniereEvaluation = new String[nbCase];
    }

    public void initialiseMatricePossibilite() {
        for (int i = 0; i < nbCase; i++)
            this.matricePossibilite [i] = symbole;
    }

    public String[][] getMatricePossibilite() {
        return matricePossibilite;
    }

    public void setMatricePossibilite(String[][] matricePossibilite) {
        this.matricePossibilite = matricePossibilite;
    }
}
