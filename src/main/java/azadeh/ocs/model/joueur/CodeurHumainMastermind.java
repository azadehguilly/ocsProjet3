package azadeh.ocs.model.joueur;

import azadeh.ocs.affichage.DemandeInfo;
import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.MastermindResultat;
import azadeh.ocs.model.jeu.Proposition;

/**
 * Le codeur est celui qui joue le role de defenseur pour le jeu Mastermind
 * CodeurHumainMastermind est donc un humain qui joue le role de codeur. Il donne des instruction par le console.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class CodeurHumainMastermind extends CodeurCommun implements ICodeur {

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
        this.solutionGagnante = demandeInfo.demandecombinaisonMastermind();
    }



    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        int resultat = 0;
        DemandeInfo demandeInfo = new DemandeInfo();
        int resultatOrdi = prop.calculScore(this.solutionGagnante, prop);
        do {
            resultat = demandeInfo.evaluerUnePropositionConsoleMastermind(prop);
            if (resultat != resultatOrdi)
                System.out.println("Le resultat que vous avez donné est incorrect, refaite votre calcul : ");
        } while (resultat != resultatOrdi);

        return new MastermindResultat(resultat);
    }



    @Override
    public boolean isPartieGagnante(IResultat resultat) {
        return super.isPartieGagnante((MastermindResultat) resultat);
    }


    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }


}
