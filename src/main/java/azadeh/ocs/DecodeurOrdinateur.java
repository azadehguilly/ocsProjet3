package azadeh.ocs;

import org.apache.commons.lang.RandomStringUtils;

public class DecodeurOrdinateur extends DecodeurCommun implements IDecodeur {

    private Possibilite possibilite;
    private Proposition derniereProposition;

    /**
     * Propose une combinaison par rapport à un matrice de possibilité
     *
     * @return combinaison
     */
    @Override
    public Proposition proposerUneCombinaison(Resultat resultat) {

        // Premiere etape: eliminer les possibilites non valides sur la base du resultat et de la derniere proposition


        // Seconde etape: choisir une combinaison à partir des possibilites restantes

        int tailleTableauMatrice=0;
        char[] tableauSolutionPossible=null;
        Proposition proposition = new Proposition();
        RandomStringUtils r = new RandomStringUtils();
/*
        for (int i = 0; i < possibilite.getMatricePossibilite().length; i++) {
            tailleTableauMatrice = possibilite.getMatricePossibilite()[i].length;
            if (tailleTableauMatrice==1){
                proposition.proposition[i] = possibilite.getMatricePossibilite()[i][0];
            }
            else {
                tableauSolutionPossible = Conversion.convertTableauStringEnTableauChar(possibilite.getMatricePossibilite()[i]);
                proposition.proposition[i] = r.random(1, 0, tailleTableauMatrice, false, true, tableauSolutionPossible);
            }
        }
        */
        return proposition;
    }



}