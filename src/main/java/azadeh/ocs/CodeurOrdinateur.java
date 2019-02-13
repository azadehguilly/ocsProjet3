package azadeh.ocs;

import azadeh.ocs.utilite.Conversion;
import org.apache.commons.lang.RandomStringUtils;

import static azadeh.ocs.App.nbCase;

public class CodeurOrdinateur extends CodeurCommun implements Codeur {


    /**
     * Générer la Solution gagnant
     */
    @Override
    public Combinaison genereLaSolutionGagnante(Possibilite possibilite) {
        Combinaison combinaison = new Combinaison();
        RandomStringUtils r = new RandomStringUtils();
        for (int i = 0; i < possibilite.getMatricePossibilite().length; i++) {
            //for (int j = 0; j < possibilite.getMatricePossibilite()[i].length; j++)
                combinaison.combinaison[i] = r.random(1, 0, possibilite.getMatricePossibilite()[i].length, false, true, Conversion.convertTableauStringEnTableauChar(possibilite.getMatricePossibilite()[i]));
        }
        return combinaison;
    }



    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     * met à jour la matrice de possibilité avec la derniereEvaluation
     * @param Combinaison prop, Combinaison sol, Possibilité possib
     * @return possibilite
     */
    @Override
    public Possibilite evaluerUneProposition(Combinaison prop, Combinaison sol, Possibilite possib) {
        return super.evaluerUneProposition(prop, sol, possib);
    }

        /**
         * Verifie si la séquance est trouvé.
         */
        @Override
        public boolean isPartieGagnante (Combinaison prop, Combinaison sol){
            return super.isPartieGagnante(prop, sol);
        }


    }
