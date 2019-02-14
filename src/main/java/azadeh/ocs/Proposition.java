package azadeh.ocs;

import java.util.ArrayList;

public class Proposition {

    private ArrayList<String> propositions;

    public Proposition() {
        propositions = new ArrayList<>();
    }

    public Proposition(ArrayList<String> propositions) {
        this.propositions = new ArrayList<>(propositions);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int position = 0;
        for (String resultat : propositions) {
            stringBuilder.append(resultat);
            if (position != propositions.size() - 1)
                stringBuilder.append(" ");
            position++;
        }
        return stringBuilder.toString();
    }
}
