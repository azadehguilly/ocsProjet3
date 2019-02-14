package azadeh.ocs;

import java.util.ArrayList;

/**
 * Representation d'un résultat sous la forme d'une séquence de + ou - ou =
 */
public class Resultat {
    private ArrayList<String> resultats;

    public Resultat() {
        resultats = new ArrayList<>();
    }

    public Resultat(ArrayList<String> resultats) {
        this.resultats = new ArrayList<>(resultats);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int position = 0;
        for (String resultat : resultats) {
            stringBuilder.append(resultat);
            if (position != resultats.size() - 1)
                stringBuilder.append(" ");
            position++;
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> getResultats(){
        return resultats;
    }
}
