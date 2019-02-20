package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un résultat sous la forme d'une séquence de + ou - ou =
 */
public class Resultat {

    private List<String> resultats;

    public Resultat() {
        resultats = new ArrayList<String>();
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
                stringBuilder.append("");
            position++;
        }
        return stringBuilder.toString();
    }

    public List<String> getResultats(){
        return resultats;
    }

    public void setResultats(List<String> resultats) {
        this.resultats = resultats;
    }
}
