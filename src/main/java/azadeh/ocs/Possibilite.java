package azadeh.ocs;

import java.util.ArrayList;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

public class Possibilite {
    //public String[][] matricePossibilite; //0 à 9 , nbCasse fois (min et max de la possibilité) toute les possibilité
    //public String[] derniereEvaluation; //contient +, - et = pour le jeu de recherche
    private ArrayList<ArrayList<String>> possibilites;


    public Possibilite() {
        possibilites = new ArrayList();
    }

    public void initialiseMatricePossibilite() {
        for (int i = 1; i <= nbCase; i++) {
            ArrayList<String> symbolsAtColumn = new ArrayList<>();
            for (int j = 0; j < symbols.length; j++) {
                symbolsAtColumn.add(symbols[j]);
            }
            possibilites.add(symbolsAtColumn);
        }
    }

    /*
        public String[][] getMatricePossibilite() {
            return matricePossibilite;
        }

        public void setMatricePossibilite(String[][] matricePossibilite) {
            this.matricePossibilite = matricePossibilite;
        }
        */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int nbPositions = 0;
        for (ArrayList<String> symbolsAtColumn : possibilites){
            int nbSymbols = 0;
            for (String symbol : symbolsAtColumn){
                stringBuilder.append(symbol);
                if (nbSymbols!=symbolsAtColumn.size()-1)
                    stringBuilder.append(",");
                ++nbSymbols;
            }
            if (nbPositions!=possibilites.size()-1)
                stringBuilder.append(" ; ");
            ++nbPositions;
        }
        return stringBuilder.toString();
    }

}
