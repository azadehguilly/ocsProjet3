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
    public boolean isPartieGagnante(int resultat) {
        return super.isPartieGagnante(resultat);
    }

    /**
     * Cette méthode nous donne le resultat d'un tour sous la forme d'un entier de 2 digits. le chiffre des dizaines étant égal au nombre de chiffre bien placés (pion rouge) et le chiffre des unités à celui des chiffres présents (pions blanches)
     *
     * @param solutionGagnante
     * @param prop
     * @return
     */
    @Override
    public int calculScore(Proposition solutionGagnante, Proposition prop) {
        Proposition proposition = new Proposition();
        int resultat = proposition.calculScore(this.solutionGagnante, prop);
        return resultat;
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente ICodeur.
     *
     * @param resultat
     * @return false
     */
    @Override
    public boolean isPartieGagnante(Resultat resultat) {
        return false;
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente ICodeur.
     *
     * @param prop
     * @return null
     */
    @Override
    public Resultat evaluerUneProposition(Proposition prop) {
        return null;
    }

}
