package azadeh.ocs.affichage;

import azadeh.ocs.Proposition;

import java.util.Scanner;

import static azadeh.ocs.App.nbCase;

public class DemandeInfoRecherche {


    Scanner sc = new Scanner(System.in);

    /**
     * Demande d'une combinaison
     * si on tape des lettres ou moins de chiffre ou plus de chiffre, on affiche une message d'erreur
     * @return une Proposition

    public Proposition demandecombinaisonRecherche() {
        boolean isIntValue;
        Proposition resultat = new Proposition();
        String valeurEntree = null;
        String[] tableauValeurEntree = null;

        do {
            sc = new Scanner(System.in);
            System.out.println("Taper un chiffre de " + nbCase + " charactères");
            isIntValue = sc.hasNextInt();
            if (isIntValue) {
                valeurEntree = sc.next();
                if (valeurEntree.length() == nbCase) {
                    tableauValeurEntree = valeurEntree.split("");
                    break;
                }
            }
            System.out.println("La valeur saisie est fausse");
            System.out.println("Tapez que des chiffres de " + nbCase + " charactères");

        } while (!isIntValue || valeurEntree.length() != nbCase);
        for (int i = 0; i < nbCase; i++) {
            resultat.combinaison[i] = tableauValeurEntree[i];
        }
        return resultat;
    }

*/

}
