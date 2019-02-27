package azadeh.ocs;

public class MastermindResultat implements IResultat {
    private int resultat;

    public MastermindResultat(int resultat) {
        this.resultat = resultat;
    }


    /**
     * Afficher le resultat
     *
     * @return
     */
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
