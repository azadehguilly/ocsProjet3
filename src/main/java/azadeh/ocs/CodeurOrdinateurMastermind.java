package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Le codeur est celui qui joue le role de defenseur pour le jeu Mastermind
 * CodeurOrdinateurMastermind est donc l'ordinateur qui joue le role de codeur.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class CodeurOrdinateurMastermind extends CodeurCommun implements ICodeur {

    /**
     * solutionGagnante est un objet de type Proposition qui contient la solution gagnante
     *
     * @see Proposition
     */
    private Proposition solutionGagnante;

    /**
     * Constructeur vide!
     */
    public CodeurOrdinateurMastermind() {
    }

    /**
     * Constructeur
     *
     * @param solutionGagnante
     */
    public CodeurOrdinateurMastermind(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }

    /**
     * Générer la Solution gagnante aleatoir
     */
    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        List<String> symbolsAtColumn = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= nbCase; i++) {
            int randomIndex = rand.nextInt(symbols.length);
            String randomElement = symbols[randomIndex];
            symbolsAtColumn.add(randomElement);
        }
        this.solutionGagnante.setPropositions(symbolsAtColumn);
    }

    /**
     * Getteur de la solutionGagnante
     *
     * @return
     */
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }

    /**
     * Setteur de la solutionGagnante
     *
     * @param solutionGagnante
     */
    public void setSolutionGagnante(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }


    /**
     * Verifie si le resultat est gagnant.
     *
     * @param resultat
     * @return
*/
    @Override
    public boolean isPartieGagnante(IResultat resultat) {
        return super.isPartieGagnante((MastermindResultat) resultat);
    }

    /**
     * Cette méthode nous donne le resultat d'un tour sous la forme d'un entier de 2 digits. le chiffre des dizaines étant égal au nombre de chiffre bien placés (pion rouge) et le chiffre des unités à celui des chiffres présents (pions blanches)
     *
     * @param solGagnante
     * @param prop
     * @return
     */
    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        Proposition proposition = new Proposition();
        int resultat = proposition.calculScore(this.solutionGagnante, prop);
        return new MastermindResultat(resultat);
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
