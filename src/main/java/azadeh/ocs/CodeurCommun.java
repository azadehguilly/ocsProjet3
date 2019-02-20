package azadeh.ocs;

public abstract class CodeurCommun {



    /**
     * Verifie si la séquance est trouvé donc la partie est gagnante
     * @param resultat
     * @return vrai si la bonne réultat est trouvé
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


