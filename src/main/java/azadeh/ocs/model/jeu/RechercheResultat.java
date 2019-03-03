package azadeh.ocs.model.jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un résultat sous la forme d'une séquence de + ou - ou =
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class RechercheResultat implements IResultat {

    /**
     * resultats est une liste de String qui contient +, - et =
     */
    private List<String> resultats;

    /**
     * Constructeur
     * Instancie le resultats à une nouvelle liste
     */
    public RechercheResultat() {
        resultats = new ArrayList<String>();
    }

    /**
     * Constructeur
     * Instancie le resultats, avec une liste donnée en parametre
     *
     * @param resultats
     *      une liste avec la quelle on instancie le resultat
     */
    public RechercheResultat(ArrayList<String> resultats) {
        this.resultats = new ArrayList<>(resultats);
    }


   @Override
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



    public List<String> getResultats() {
        return resultats;
    }

    public void setResultats(List<String> resultats) {
        this.resultats = resultats;
    }
}
