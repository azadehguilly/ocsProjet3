package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Representation de toutes les combinaisons possible
 */
public class Possibilite {

    private List<List<String>> possibilites;


    public Possibilite() {
        possibilites = new ArrayList();
    }

    /**
     * Initialisation de toute les possibilités
     */
    public void initialiseMatricePossibilite() {
        for (int i = 1; i <= nbCase; i++) {
            List<String> symbolsAtColumn = new ArrayList<>();
            for (int j = 0; j < symbols.length; j++) {
                symbolsAtColumn.add(symbols[j]);
            }
            possibilites.add(symbolsAtColumn);
        }
    }


    public List<List<String>> getPossibilites() {
        return possibilites;
    }

    /**
     * Ajouter une liste à la liste des possibilités
     *
     * @param possibilite
     */
    public void addListToPossibilite(List<String> possibilite) {
        this.possibilites.add(possibilite);
    }

    /**
     * Afficher les possibilités
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int nbPositions = 0;
        for (List<String> symbolsAtColumn : possibilites) {
            int nbSymbols = 0;
            for (String symbol : symbolsAtColumn) {
                stringBuilder.append(symbol);
                if (nbSymbols != symbolsAtColumn.size() - 1)
                    stringBuilder.append(",");
                ++nbSymbols;
            }
            if (nbPositions != possibilites.size() - 1)
                stringBuilder.append(" ; ");
            ++nbPositions;
        }
        return stringBuilder.toString();
    }

    /**
     * Effacer une symbole dans la nieme liste des possibilités
     *
     * @param numeroColonne
     * @param symbole
     */
    public void effacerSymboleAtPossibilite(int numeroColonne, String symbole) {
        if (this.possibilites.size() > numeroColonne) {
            this.possibilites.get(numeroColonne).remove(symbole);
        }
    }

    /**
     * Affecte un symbole à une colonne donnée.
     *
     * @param numeroColonne
     * @param symbole
     */
    public void affecterSymboleALaPosition(int numeroColonne, String symbole) {
        ArrayList<String> nouvelleListe = new ArrayList<String>();
        nouvelleListe.add(symbole);
        possibilites.set(numeroColonne, nouvelleListe);
    }


    /**
     * Renvoie la longeur de la nieme liste des possibilités
     * @param numeroColonne
     * @return
     */
    public int tailleListeALaPositionDonnee(int numeroColonne){
        int taille = this.possibilites.get(numeroColonne).size();
        return taille;
    }

    /**
     * Renvoie la borne minimum de la nieme liste des possibilités
     * @param numeroColonne
     * @return
     */
    public int minListeALaPositionDonnee(int numeroColonne){
        int minList = Integer.parseInt(this.possibilites.get(numeroColonne).get(0));
        return minList;
    }

    /**
     * Renvoie la borne maximum de la nieme liste des possibilités
     * @param numeroColonne
     * @return
     */
    public int maxListeALaPositionDonnee(int numeroColonne){
        int maxList = Integer.parseInt(this.possibilites.get(numeroColonne).get(tailleListeALaPositionDonnee(numeroColonne)-1));
        return maxList;
    }
}
