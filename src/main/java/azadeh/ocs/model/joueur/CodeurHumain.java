package azadeh.ocs.model.joueur;

import azadeh.ocs.affichage.DemandeInfo;
import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.jeu.RechercheResultat;

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


    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        DemandeInfo demandeInfo = new DemandeInfo();
        this.solutionGagnante = demandeInfo.demandecombinaisonRecherche();
    }


    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        DemandeInfo demandeInfo = new DemandeInfo();
        return demandeInfo.evaluerUnePropositionConsoleRecherche(prop);
    }



    @Override
    public boolean isPartieGagnante(IResultat resultat) {
        return super.isPartieGagnante((RechercheResultat) resultat);
    }


    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }


}
