package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;

public class CodeurHumain {


    /**
     * Générer la Solution gagnant

    public Proposition genereLaSolutionGagnante() {
        Proposition proposition = new Proposition();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        proposition = demandeInfoRecherche.demandecombinaisonRecherche();
        return proposition;
    }


    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     * met à jour la matrice de possibilité avec la derniereEvaluation
     * @ param Proposition prop, Proposition sol, Possibilité possib
     * @return possibilite

    @Override
    public Possibilite evaluerUneProposition(Proposition prop, Proposition sol, Possibilite possib) {
        System.out.println("A faire pour un codeur Humain!!!!!!!!  modifier la methode !!!!!!!");

        Possibilite possibilite = new Possibilite();
        possibilite.matricePossibilite = possib.matricePossibilite;

        for (int i = 0; i < nbCase; i++) {
            if (prop.getCombinaison()[i].equals(sol.getCombinaison()[i]))
                possibilite.derniereEvaluation[i] = "=";
            else if (Integer.parseInt(prop.getCombinaison()[i]) < Integer.parseInt(sol.getCombinaison()[i]))
                possibilite.derniereEvaluation[i] = "+";
            else
                possibilite.derniereEvaluation[i] = "-";
        }

        return possibilite;


    }



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

    @Override
    public boolean isPartieGagnante(Proposition prop, Proposition sol) {
        return super.isPartieGagnante(prop, sol);
    }
    */
}
