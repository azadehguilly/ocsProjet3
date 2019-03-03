package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.jeu.RechercheResultat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Le codeur est celui qui joue le role de defenseur pour le jeu Recherche +/-
 * CodeurOrdinateur est donc l'ordinateur qui joue le role de codeur.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class CodeurOrdinateur extends CodeurCommun implements ICodeur {

    /**
     * solutionGagnante est un objet de type Proposition qui contient la solution gagnante
     *
     * @see Proposition
     */
    private Proposition solutionGagnante;


    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        String symbolRandom = new String();
        List<String> symbolsAtColumn = new ArrayList<>();

        for (int i = 1; i <= nbCase; i++) {
            int rand = ThreadLocalRandom.current().nextInt(0, symbols.length);
            symbolRandom = Integer.toString(rand);
            symbolsAtColumn.add(symbolRandom);
        }
        this.solutionGagnante.setPropositions(symbolsAtColumn);
    }


    @Override
    public IResultat evaluerUneProposition(Proposition prop) {
        RechercheResultat rechercheResultat = new RechercheResultat();

        for (int i = 0; i < nbCase; i++) {
            if (prop.getPropositions().get(i).equals(this.solutionGagnante.getPropositions().get(i)))
                rechercheResultat.getResultats().add(i, "=");
            else if (Integer.parseInt(prop.getPropositions().get(i)) < Integer.parseInt(this.solutionGagnante.getPropositions().get(i)))
                rechercheResultat.getResultats().add(i, "+");
            else
                rechercheResultat.getResultats().add(i, "-");
        }
        return rechercheResultat;
    }


    @Override
    public boolean isPartieGagnante(IResultat rechercheResultat) {
        return super.isPartieGagnante((RechercheResultat) rechercheResultat);
    }


    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }


    public void setSolutionGagnante(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }


}
