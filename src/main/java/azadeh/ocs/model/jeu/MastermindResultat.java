package azadeh.ocs.model.jeu;

/**
 * Representation d'un résultat sous la forme d'un entier de 2 digits
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class MastermindResultat implements IResultat {

    /**
     * resultat d'une proposition sous la forme d'un entier de 2 digits.
     * Le chiffre des dizaines étant égal au nombre de chiffre bien placés et le chiffre des unités à celui des chiffres présents mais pas bien placés
     */
    private int resultat;

    /**
     * Instancie le resultats, avec le resultat donnée en parametre
     *
     * @param resultat
     *      le resultat donné
     */
    public MastermindResultat(int resultat) {
        this.resultat = resultat;
    }



    @Override
    public String toString() {
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

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
