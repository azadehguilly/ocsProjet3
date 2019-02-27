package azadeh.ocs;

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

    /**
     * Générer la Solution gagnante aleatoir
     */
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


    /**
     * Cette méthode nous donne le resultat d'un tour sous la forme +, - et =
     *
     * @param prop est la proposition de l'attaquant.
     * @return un objet de type RechercheResultat
     * @see RechercheResultat
     */
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
     * Getteur de la solutionGagnante
     *
     * @return
     */
    @Override
    public Proposition getSolutionGagnante() {
        return solutionGagnante;
    }

    /**
     * Setteur de la solutionGagnante
     * @param solutionGagnante
     */
    public void setSolutionGagnante(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }

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
