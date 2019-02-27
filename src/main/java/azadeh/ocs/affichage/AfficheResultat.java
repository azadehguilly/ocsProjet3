package azadeh.ocs.affichage;

/**
 * AfficheResultat est la classe qui affiche tout les réultats des jeux à l'écran
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class AfficheResultat {

    /**
     * Affiche le resultat d'un tour de jeu à l'écran
     *
     * @param isPartieGagnante
     */
    public void afficheResultatJeu(boolean isPartieGagnante) {
        if (isPartieGagnante)
            System.out.println("Bravo vous avez gagné !");
        else
            System.out.println("Vous avez perdu ! ");
    }


    /**
     * Affiche un resultat donné en entier, en nombre de pions présents et bien placés
     *
     * @param resultat
     */
    /*public void modifieResultatMastermindIntToString(int resultat) {
        String resultatString = Integer.toString(resultat);
        if (resultat == 0) {
            System.out.println("Rien est bon");
            return;
        }
        if (resultatString.length() == 1) {
            if (resultat == 1) System.out.println("1 présent");
            else System.out.println(resultatString.charAt(0) + " présents");
        }
        if (resultatString.length() == 2) {
            if (resultat == 10) System.out.println("1 bien placé");
            else if (resultat % 10 == 0) System.out.println(resultatString.charAt(0) + " bien placés");
            else if (resultatString.charAt(0) == "1".charAt(0))
                System.out.println(resultatString.charAt(1) + " présents, 1 bien placé");
            else
                System.out.println(resultatString.charAt(1) + " présents, " + resultatString.charAt(0) + " bien placés");
        }
    }
    */

    public String modifieResultatMastermindIntToString(int resultat) {
        String  resultatAAfficher = "";
        String resultatString = Integer.toString(resultat);
        if (resultat == 0) {
            resultatAAfficher = "Rien est bon";
            return resultatAAfficher;
        }
        if (resultatString.length() == 1) {
            if (resultat == 1) resultatAAfficher = "1 présent" ;
            else resultatAAfficher = resultatString.charAt(0) + " présents";
        }
        if (resultatString.length() == 2) {
            if (resultat == 10)
                resultatAAfficher = "1 bien placé";
            else if (resultat % 10 == 0)
                resultatAAfficher = resultatString.charAt(0) + " bien placés";
            else if (resultatString.charAt(0) == "1".charAt(0)&& resultatString.charAt(1) == "1".charAt(0))
                resultatAAfficher = " 1 présent, 1 bien placé";
            else if (resultatString.charAt(0) == "1".charAt(0)&& resultatString.charAt(1) != "1".charAt(0))
                resultatAAfficher = resultatString.charAt(1) + " présents, 1 bien placé";
            else if (resultatString.charAt(1) == "1".charAt(0) && resultatString.charAt(0) != "1".charAt(0))
                resultatAAfficher = "1 présent, "+resultatString.charAt(0) +" bien placés";
            else
                resultatAAfficher = resultatString.charAt(1) + " présents, " + resultatString.charAt(0) + " bien placés";
        }
        return resultatAAfficher;
    }

}
