package azadeh.ocs.affichage;

import azadeh.ocs.Proposition;
import azadeh.ocs.Resultat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static azadeh.ocs.App.nbCase;

public class DemandeInfoRecherche {


    /**
     * Demande d'une combinaison
     * si on tape des lettres ou moins de chiffre ou plus de chiffre, on affiche une message d'erreur
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



    public Resultat evaluerUnePropositionConsole(Proposition prop){
        Resultat resultat = new Resultat();
        Scanner sc;
        String valeurEntree = null;
        List<String> symbolsAtColumn = new ArrayList<>();
        String[] values = {"-","+","="};
        boolean contains;
        int nbContains ;
        String[] valeurEntreeSplit;

        do {
            contains = false;
            nbContains = 0;
            sc = new Scanner(System.in);
            System.out.println("Evaluer le proposition " + prop.toString());
            valeurEntree = sc.next();
            valeurEntreeSplit = valeurEntree.split("");
            for (int i = 0; i<valeurEntree.length() ; i++){
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
}
