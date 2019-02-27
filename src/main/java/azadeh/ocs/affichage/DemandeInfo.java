package azadeh.ocs.affichage;

import azadeh.ocs.Proposition;
import azadeh.ocs.Resultat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * DemandeInfo est la classe qui demande des information à l'utilisateur à l'écran
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class DemandeInfo {


    /**
     * Demande d'une combinaison à l'utilisateur à l'écran pour le jeu de Recherche +/-
     * si l'utilisateur tape des lettres ou moins de chiffre que prévu ou plus, un message d'erreur sera affiché à l'écran
     *
     * @return une Proposition
     */
    public Proposition demandecombinaisonRecherche() {
        boolean isIntValue;
        Scanner sc;
        Proposition resultat = new Proposition();
        String valeurEntree = null;
        List<String> symbolsAtColumn = new ArrayList<>();

        do {
            sc = new Scanner(System.in);
            System.out.println("Taper un chiffre de " + nbCase + " charactères");
            isIntValue = sc.hasNextInt();
            if (isIntValue) {
                valeurEntree = sc.next();
                if (valeurEntree.length() == nbCase) {
                    break;
                }
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez que des chiffres de " + nbCase + " charactères");

        } while (!isIntValue || valeurEntree.length() != nbCase);


        symbolsAtColumn = Arrays.asList(valeurEntree.split(""));

        resultat.setPropositions(symbolsAtColumn);
        return resultat;
    }

    /**
     * Demande d'une combinaison de n chiffres en base demandé à l'utilisateur à l'écran pour le jeu de Mastermind
     * n chiffre, represente le nombre de trous et les chiffres en base demandé, represente les symboles possibles
     * <p>
     * Si l'utilisateur tape des lettres ou moins de chiffre que prévu ou plus, un message d'erreur sera affiché à l'écran
     *
     * @return une Proposition
     */
    public Proposition demandecombinaisonMastermind() {
        Scanner sc;
        Proposition resultat = new Proposition();
        String valeurEntree = null;
        List<String> symbolsAtColumn = new ArrayList<>();
        String[] valeurEntreeSplit;
        boolean contains;
        int nbContains;

        do {
            contains = false;
            nbContains = 0;
            sc = new Scanner(System.in);
            System.out.println("Taper un chiffre de " + nbCase + " charactères. Avec les symboles de 0 à " + (symbols.length - 1));
            valeurEntree = sc.next();
            valeurEntreeSplit = valeurEntree.split("");
            for (int i = 0; i < valeurEntree.length(); i++) {
                contains = Arrays.stream(symbols).anyMatch(valeurEntreeSplit[i]::equals);
                if (contains) nbContains++;
            }
            if (nbContains == nbCase) {
                if (valeurEntree.length() == nbCase) {
                    //symbolsAtColumn.add(valeurEntree);
                    break;
                }
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez que " + nbCase + " chiffres, chacun de 0 à " + (symbols.length - 1));

        } while ((nbContains != nbCase) || valeurEntree.length() != nbCase);

        symbolsAtColumn = Arrays.asList(valeurEntree.split(""));

        resultat.setPropositions(symbolsAtColumn);
        return resultat;
    }

    /**
     * Cette fonction demande à l'utilisateur d'évaluer une proposition donnée à l'écran pour le jeu de Recherche +/-
     * L'utilisateur indique pour chaque chiffre de la proposition si le chiffre est plus grand (+), plus petit (-) ou si c'est le bon chiffre (=).
     *
     * @param prop Proposition à évaluer
     * @return un objet Resultat sous forme de +, - ou =
     * @see Resultat
     */
    public Resultat evaluerUnePropositionConsoleRecherche(Proposition prop) {
        Resultat resultat = new Resultat();
        Scanner sc;
        String valeurEntree = null;
        List<String> symbolsAtColumn = new ArrayList<>();
        String[] values = {"-", "+", "="};
        boolean contains;
        int nbContains;
        String[] valeurEntreeSplit;

        do {
            contains = false;
            nbContains = 0;
            sc = new Scanner(System.in);
            System.out.println("Evaluer le proposition " + prop.toString());
            valeurEntree = sc.next();
            valeurEntreeSplit = valeurEntree.split("");
            for (int i = 0; i < valeurEntree.length(); i++) {
                contains = Arrays.stream(values).anyMatch(valeurEntreeSplit[i]::equals);
                if (contains) nbContains++;
            }
            if (nbContains == nbCase) {
                if (valeurEntree.length() == nbCase) {
                    //symbolsAtColumn.add(valeurEntree);
                    break;
                }
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez que des +, - ou = " + nbCase + " fois");

        } while ((nbContains != nbCase) || valeurEntree.length() != nbCase);


        symbolsAtColumn = Arrays.asList(valeurEntree.split(""));
        resultat.setResultats(symbolsAtColumn);

        return resultat;
    }

    /**
     * Cette fonction demande à l'utilisateur d'évaluer une proposition donnée à l'écran pour le jeu de Mastermind
     * L'utilisateur indique pour chaque proposition le nombre de chiffre de la proposition qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.
     *
     * @param prop Proposition à évaluer
     * @return Un entier de 2 digit. le chiffre des dizaines étant égal au nombre de chiffre bien placés (pion rouge) et le chiffre des unités à celui des chiffres présents (pions blanches)
     */
    public int evaluerUnePropositionConsoleMastermind(Proposition prop) {
        boolean isIntValue;
        int resultat = 0;
        Scanner sc;
        do {
            sc = new Scanner(System.in);
            System.out.println("Evaluer le proposition " + prop.toString());
            isIntValue = sc.hasNextInt();
            if (isIntValue) {
                resultat = sc.nextInt();
                if (resultat < nbCase * 10 && resultat >= 0) break;
                ;
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez un entier de maximum 2 chiffres. Le chiffre des dizaines étant égal au nombre de jetons bien placés et le chiffre des unités au nombre de jetons mal placés.");
        } while ((resultat > nbCase * 10) || !isIntValue);

        return resultat;
    }

    /**
     * Cette méthode demande le nom de jeu au quel l'utilisateur veut jouer
     *
     * @return
     */
    public int demandeNomJeu() {
        int resultat = 0;
        Scanner sc;
        boolean isIntValue;
        do {
            sc = new Scanner(System.in);
            System.out.println("A quel jeu voulez vous jouer?  1. Recherche +/-     2. Mastermind ");
            isIntValue = sc.hasNextInt();
            if (isIntValue) {
                resultat = sc.nextInt();
                System.out.println("resultat" + resultat);
                break;
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez 1 ou 2");
        } while (!isIntValue || resultat != 1 || resultat != 2);

        return resultat;
    }

    /**
     * Cette méthode demande le mode de jeu au quel l'utilisateur veut jouer
     *
     * @return
     */
    public int demandeModeJeu() {
        int resultat = 0;
        Scanner sc;
        boolean isIntValue;
        do {
            sc = new Scanner(System.in);
            System.out.println("A quel mode de jeu voulez vous jouer?  1. Challenger 2. Défenseur 3. Duel");
            isIntValue = sc.hasNextInt();
            if (isIntValue) {
                resultat = sc.nextInt();
                break;
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez 1, 2 ou 3");
        } while (!isIntValue || resultat != 1 || resultat != 2 || resultat != 3);

        return resultat;
    }

}
