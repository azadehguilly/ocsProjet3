package azadeh.ocs;

import azadeh.ocs.utilite.Conversion;
import org.apache.commons.lang.RandomStringUtils;

public class DecodeurOrdinateur implements Decodeaur {


    /**
     * Propose une combinaison par rapport à un matrice de possibilité
     *
     * @param possibilite
     * @return combinaison
     */
    @Override
    public Combinaison proposerUneCombinaison(Possibilite possibilite) {
        int tailleTableauMatrice=0;
        char[] tableauSolutionPossible=null;
        Combinaison combinaison = new Combinaison();
        RandomStringUtils r = new RandomStringUtils();

        for (int i = 0; i < possibilite.getMatricePossibilite().length; i++) {
            tailleTableauMatrice = possibilite.getMatricePossibilite()[i].length;
            if (tailleTableauMatrice==1){
                combinaison.combinaison[i] = possibilite.getMatricePossibilite()[i][0];
            }
            else {
                tableauSolutionPossible = Conversion.convertTableauStringEnTableauChar(possibilite.getMatricePossibilite()[i]);
                combinaison.combinaison[i] = r.random(1, 0, tailleTableauMatrice, false, true, tableauSolutionPossible);
            }
        }
        return combinaison;
    }
}