package azadeh.ocs.utilite;

public class Conversion {

    /**
     * Convertir un Srting[] en char[]
     */
    public static char[] convertTableauStringEnTableauChar(String[] tableauString){
        char[] resultat = new char[tableauString.length];
        for (int i = 0; i < tableauString.length; i++) {
            resultat[i] = tableauString[i].trim().charAt(0);
        }
        return resultat;
    }
}
