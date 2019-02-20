package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'une proposition sous la forme d'une séquence de chiffre
 */
public class Proposition {

    private List<String> propositions;

    public Proposition() {
        propositions = new ArrayList<String>();
    }

    public Proposition(List<String> propositions) {
        this.propositions = new ArrayList<String>(propositions);
    }

    public List<String> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<String> propositions) {
        this.propositions = propositions;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int position = 0;
        for (String resultat : propositions) {
            stringBuilder.append(resultat);
            if (position != propositions.size() - 1)
                stringBuilder.append("");
            position++;
        }
        return stringBuilder.toString();
    }

    public String symboleALaPosition(int numeroColonne) {
        return propositions.get(numeroColonne);
    }

}
