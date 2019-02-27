package azadeh.ocs;

import azadeh.ocs.affichage.DemandeInfo;

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

    /**
     * Générer la Solution gagnante par console
     */
    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        DemandeInfo demandeInfo = new DemandeInfo();
        this.solutionGagnante = demandeInfo.demandecombinaisonMastermind();
    }


    /**
     * Cette méthode nous donne le resultat d'un tour
     *
     * @param solutionGagnante La solution gagnante
     * @param prop             La proposition de l'attaquant
     * @return le resultat sous forme d'un entier de deux digits
     */
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


    /**
     * Verifie si la resultat est gagnante.
     *
     * @param resultat
     * @return
     */
    @Override
    public boolean isPartieGagnante(IResultat resultat) {
        return super.isPartieGagnante((MastermindResultat)resultat);
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
     * @param rechercheResultat
     * @return false

    @Override
    public boolean isPartieGagnante(RechercheResultat rechercheResultat) {
        return false;
    }
*/
    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente ICodeur.
     *
     * @param prop
     * @return null

    @Override
    public RechercheResultat evaluerUneProposition(Proposition prop) {
        return null;
    }
*/
}
