package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfo;

import static azadeh.ocs.App.nbCase;

/**
 * Le codeur est celui qui joue le role de defenseur pour le jeu Recherche +/-
 * CodeurHumain est donc un humain qui joue le role de codeur. Il donne des instruction par le console.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class CodeurHumain extends CodeurCommun implements ICodeur {


    /**
     * solutionGagnante est un objet de type Proposition qui contient la solution gagnante
     *
     * @see Proposition
     */
    private Proposition solutionGagnante;

    /**
     * Générer la Solution gagnante par console
     */
    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        DemandeInfo demandeInfo = new DemandeInfo();
        this.solutionGagnante = demandeInfo.demandecombinaisonRecherche();
    }

    /**
     * Cette méthode nous donne le resultat d'un tour
     *
     * @param prop est la proposition de l'attaquant.
     * @return un objet de type RechercheResultat
     * @see RechercheResultat
     */
    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        DemandeInfo demandeInfo = new DemandeInfo();
        return demandeInfo.evaluerUnePropositionConsoleRecherche(prop);
    }


    /**
     * Verifie si le rechercheResultat est gagnant.
     *
     * @param rechercheResultat
     * @return
     */
    @Override
    public boolean isPartieGagnante(IResultat rechercheResultat) {
        return super.isPartieGagnante((RechercheResultat) rechercheResultat);
    }

    /**
     * Getteur de solutionGagnante
     *
     * @return
     */
    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }


    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente ICodeur.
     *
     * @param resultat
     * @return false

    @Override
    public boolean isPartieGagnante(int resultat) {
        return false;
    }
     */
    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente ICodeur.
     *
     * @param solutionGagnante
     * @param prop
     * @return 0

    @Override
    public int calculScore(Proposition solutionGagnante, Proposition prop) {
        return 0;
    }
     */
}
