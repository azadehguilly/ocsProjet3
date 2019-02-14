package azadeh.ocs;

public class CodeurCommun {



/* @Override
    public String[] evaluerUneProposition(Proposition prop, Proposition sol) {
        String[] evaluation = new String[nbCase];
        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i])) evaluation[i] = "=";
            else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i]))
                evaluation[i] = "+";
            else evaluation[i] = "-";
        }
        return evaluation;
    }*/


    /**
     * Verifie si la séquance est trouvé.
     */
    public boolean isPartieGagnante(Resultat resultat) {
        boolean isFound = true;
        for (String resultatAtColumn : resultat.getResultats()) {
            if (!"=".equals(resultatAtColumn)) {
                isFound = false;
                break;
            }
        }
        return isFound;
    }
}


