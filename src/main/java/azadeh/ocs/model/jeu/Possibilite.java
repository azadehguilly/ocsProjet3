package azadeh.ocs.model.jeu;

import azadeh.ocs.model.joueur.DecodeurOrdinateurMastermind;
import azadeh.ocs.exceptions.JeuException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Representation de toutes les combinaisons possible pour le jeu Recherche +/-
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class Possibilite {

    /**
     * LOGGER sert à la mise en place des log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Possibilite.class.getName());


    /**
     * possibilites est la matrice de possibilités
     * Elle a nbCase lignes. Chasue ligne represente, les possibilité d'un chiffre de la solution gagnante
     */
    private List<List<String>> possibilites;


    public Possibilite() {
        possibilites = new ArrayList();
    }


    /**
     * Initialisation de toutes les possibilités
     * On initialise la matrice des possibilites à nbCase lignes et pour chaque ligne de 0 à 9 chiffres
     */
    public void initialiseToutesLesPossibilitesRecherche() {
        for (int i = 1; i <= nbCase; i++) {
            List<String> symbolsAtColumn = new ArrayList<>();
            for (int j = 0; j < symbols.length; j++) {
                symbolsAtColumn.add(symbols[j]);
            }
            possibilites.add(symbolsAtColumn);
        }
    }



    /**
     * Ajouter une liste à la liste des possibilités
     * Cette methode est utilisée pour les tests unitaires
     *
     * @param possibilite
     *      est la possibilité à ajouter dans la liste existant
     */
    public void addListToPossibilite(List<String> possibilite) {
        this.possibilites.add(possibilite);
    }

    /**
     * Afficher les possibilités
     *
     * @return
     *       les possibilités sous forme lisible
     */
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
     *      numéro de la liste ou il faut supprimer le symbole
     * @param symbole
     *      le symbole à supprimer
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
     *      numéro de la liste ou il faut ajouter le symbole
     * @param symbole
     *      le symbole à ajouter
     */
    public void affecterSymboleALaPosition(int numeroColonne, String symbole) {
        ArrayList<String> nouvelleListe = new ArrayList<String>();
        nouvelleListe.add(symbole);
        possibilites.set(numeroColonne, nouvelleListe);
    }


    /**
     * Renvoie la longeur de la nieme liste des possibilités
     *
     * @param numeroColonne
     *      numéro de la liste ou on veut connaitre la taille
     * @return
     *      la taille de la liste
     */
    public int tailleListeALaPositionDonnee(int numeroColonne) {
        int taille = this.possibilites.get(numeroColonne).size();
        return taille;
    }

    /**
     * Renvoie la borne minimum de la nieme liste des possibilités
     *
     * @param numeroColonne
     *      numéro de la liste ou on veut connaitre la borne inferieur
     * @throws JeuException si possibilites.get(numeroColonne) est null
     * @return
     *      la borne inferieur de la liste selectioné
     */
    public int minListeALaPositionDonnee(int numeroColonne) {
        if (possibilites.get(numeroColonne).size() == 0) {
            LOGGER.error("Impossible de trouver une solution, les resultats que vous avez donné sont incorrects. Vous avez triché ;)");
            throw new JeuException("Impossible de trouver une solution, les resultats que vous avez donné sont incorrects. Vous avez triché ;)");
        }
        int minList = Integer.parseInt(this.possibilites.get(numeroColonne).get(0));
        return minList;
    }

    /**
     * Renvoie la borne maximum de la nieme liste des possibilités
     *
     * @param numeroColonne
     *      numéro de la liste ou on veut connaitre la borne superieur
     * @throws JeuException si possibilites.get(numeroColonne) est null
     * @return
     *       la borne superieur de la liste selectioné
     */
    public int maxListeALaPositionDonnee(int numeroColonne) {
        if (possibilites.get(numeroColonne).size() == 0) {
            LOGGER.error("Impossible de trouver une solution, les resultats que vous avez donné sont incorrects, Vous avez triché ;)");
            throw new JeuException("Impossible de trouver une solution, les resultats que vous avez donné sont incorrects");
        }

        int maxList = Integer.parseInt(this.possibilites.get(numeroColonne).get(tailleListeALaPositionDonnee(numeroColonne) - 1));
        return maxList;
    }

    public List<List<String>> getPossibilites() {
        return possibilites;
    }
}
