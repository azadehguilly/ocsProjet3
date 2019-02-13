package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;

import static azadeh.ocs.App.nbCase;

public class CodeurHumain extends CodeurCommun implements Codeur {


    /**
     * Générer la Solution gagnant
     */
    @Override
    public Combinaison genereLaSolutionGagnante(Possibilite possibilite) {
        Combinaison combinaison = new Combinaison();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();

        possibilite.initialiseMatricePossibilite();
        combinaison = demandeInfoRecherche.demandecombinaisonRecherche();
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



/* @Override
    public String[] evaluerUneProposition(Combinaison prop, Combinaison sol) {
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
    @Override
    public boolean isPartieGagnante(Combinaison prop, Combinaison sol) {
        return super.isPartieGagnante(prop, sol);
    }
}
