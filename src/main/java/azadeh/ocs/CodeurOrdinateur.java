package azadeh.ocs;

import org.apache.commons.lang.RandomStringUtils;

public class CodeurOrdinateur extends CodeurCommun implements ICodeur {


    /**
     * Générer la Solution gagnant
     */

    public Proposition genereLaSolutionGagnante() {
        Proposition proposition = new Proposition();
        RandomStringUtils r = new RandomStringUtils();
        /*for (int i = 0; i < possibilite.getMatricePossibilite().length; i++) {
            //for (int j = 0; j < possibilite.getMatricePossibilite()[i].length; j++)
                proposition.proposition[i] = r.random(1, 0, possibilite.getMatricePossibilite()[i].length, false, true, Conversion.convertTableauStringEnTableauChar(possibilite.getMatricePossibilite()[i]));
        }
        */
        return proposition;
    }


    @Override
    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     *
     * @ param Combinais on prop, Proposition sol
     * @return possibilite
     */
    public Resultat evaluerUneProposition(Proposition prop) {
        Resultat resultat = new Resultat();
        /*possibilite.matricePossibilite = possib.matricePossibilite;

        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i]))
                possibilite.derniereEvaluation[i] = "=";
            else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i]))
                possibilite.derniereEvaluation[i] = "+";
            else
                possibilite.derniereEvaluation[i] = "-";
        }
        */
        return resultat;
    }

        /**
         * Verifie si la séquance est trouvé.
         */
        @Override
        public boolean isPartieGagnante (Resultat resultat){
            return super.isPartieGagnante(resultat);
        }


    }
