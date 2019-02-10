package azadeh.ocs.affichage;

import java.util.Scanner;

public class DemandeInfoRecherche {


    Scanner sc = new Scanner(System.in);

    /**
     * Demande de entrer n chiffres pour le jeux de Recherche
     * si on tape des lettres ou moins de chiffre ou plus de chiffre, on affiche une message d'erreur
     * @param nbCase nombre de case
     * @return un tableau d'int resultat
     */
    public int[] demandecombinaisonRecherche(int nbCase) {
        boolean isIntValue;
        int[] resultat = new int[nbCase];
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
            resultat[i] = Integer.parseInt(tableauValeurEntree[i]);
        }
        return resultat;
    }



}
