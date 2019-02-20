package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfoRecherche;

public class CodeurHumain extends CodeurCommun implements ICodeur {

    private Proposition solutionGagnante;

    /**
     * Générer la Solution gagnante par console
     */
    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        this.solutionGagnante = demandeInfoRecherche.demandecombinaisonRecherche();
    }

    /**
     * Nous donne le resultat d'un tour pour le jeu de recherche
     *
     * @return un résultat
     */
    @Override
    public Resultat evaluerUneProposition(Proposition prop) {
        Resultat resultat = new Resultat();
        DemandeInfoRecherche demandeInfoRecherche = new DemandeInfoRecherche();
        resultat = demandeInfoRecherche.evaluerUnePropositionConsole(prop);
        return resultat;
    }

    /**
     * Verifie si la séquance est trouvé.
     */
    @Override
    public boolean isPartieGagnante(Resultat resultat) {
        return super.isPartieGagnante(resultat);
    }


    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }


}
