package azadeh.ocs;

public class DecodeurCommun {

    /**
     * met à jour les valeurs possible dans la matricePossibilité
     *
     * @return possibilite
     * @ param Combinais on prop, Proposition sol, Possibilité possib
     */
    public Possibilite miseAjourMatricePossibilite(Proposition prop, Proposition sol, Possibilite possib) {
        Possibilite possibilite = new Possibilite();
        int tailleNouveauTableau = 0;
        int varTemporaire = 0;
/*
        possibilite.derniereEvaluation = possib.derniereEvaluation;

        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i])) {
                possibilite.matricePossibilite[i] = new String[1];
                possibilite.matricePossibilite[i][0] = prop.getCombinaison()[i];
            } else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i])) {
                tailleNouveauTableau = 0;
                tailleNouveauTableau = Integer.parseInt(possib.matricePossibilite[i][possib.matricePossibilite.length]) - Integer.parseInt(prop.getCombinaison()[i]);
                possibilite.matricePossibilite[i] = new String[tailleNouveauTableau];//creer la bonne taille de tableau
                for (int j = 0; j < tailleNouveauTableau; j++) {
                    varTemporaire = (Integer.parseInt(prop.getCombinaison()[i]) + 1 + j);
                    possibilite.matricePossibilite[i][j] = "" + varTemporaire;
                }
            } else {
                tailleNouveauTableau = 0;
                tailleNouveauTableau = Integer.parseInt(prop.getCombinaison()[i]) - Integer.parseInt(possib.matricePossibilite[i][0]);
                possibilite.matricePossibilite[i] = new String[tailleNouveauTableau];//creer la bonne taille de tableau
                for (int j = 0; j < tailleNouveauTableau; j++) {
                    possibilite.matricePossibilite[i][j] = "" + j;
                }
            }
        }
*/
        return possibilite;
    }
}
