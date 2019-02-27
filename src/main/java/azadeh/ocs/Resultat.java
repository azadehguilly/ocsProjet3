package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un résultat sous la forme d'une séquence de + ou - ou =
 */
public class Resultat {

    /**
     * resultats est une liste de String qui contient +, - et =
     */
    private List<String> resultats;

    /**
     * Constructeur
     * Instancie le resultats à une nouvelle liste
     */
    public Resultat() {
        resultats = new ArrayList<String>();
    }

    /**
     * Constructeur
     * Instancie le resultats, avec une liste donnée en parametre
     *
     * @param resultats
     */
    public Resultat(ArrayList<String> resultats) {
        this.resultats = new ArrayList<>(resultats);
    }

    /**
     * Afficher le resultat
     *
     * @return
     */
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

    /**
     * Getteur de resultats
     * @return
     */
    public List<String> getResultats() {
        return resultats;
    }

    /**
     * Setteur de resultats
     * @param resultats
     */
    public void setResultats(List<String> resultats) {
        this.resultats = resultats;
    }
}
