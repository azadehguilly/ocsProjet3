package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.MastermindResultat;
import azadeh.ocs.model.jeu.Proposition;

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
     *      solution gagnante
     */
    public CodeurOrdinateurMastermind(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }


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


    @Override
    public boolean isPartieGagnante(IResultat resultat) {
        return super.isPartieGagnante((MastermindResultat) resultat);
    }


    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        Proposition proposition = new Proposition();
        int resultat = proposition.calculScore(this.solutionGagnante, prop);
        return new MastermindResultat(resultat);
    }

    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }

    public void setSolutionGagnante(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }


}
