package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static azadeh.ocs.App.nbCase;

public class CodeurOrdinateur extends CodeurCommun implements ICodeur {

    private Proposition solutionGagnante;

    /**
     * Générer la Solution gagnant aleatoir pour le jeux Recherche +/-
     */
    @Override
    public void genereLaSolutionGagnante() {
        this.solutionGagnante = new Proposition();
        String symbolRandom = new String();
        List<String> symbolsAtColumn = new ArrayList<>();

        for (int i = 1; i <= nbCase; i++) {
            int rand = ThreadLocalRandom.current().nextInt(0, 10);
            symbolRandom = Integer.toString(rand);
            symbolsAtColumn.add(symbolRandom);
        }
        this.solutionGagnante.setPropositions(symbolsAtColumn);
    }


    /**
     * Nous donne le resultat d'un tour pour le jeu de recherche
     *
     * @param prop
     * @return un résultat
     */
    @Override
    public Resultat evaluerUneProposition(Proposition prop) {
        Resultat resultat = new Resultat();

        for (int i = 0; i < nbCase; i++) {
            if (prop.getPropositions().get(i).equals(solutionGagnante.getPropositions().get(i)))
                resultat.getResultats().add(i, "=");
            else if (Integer.parseInt(prop.getPropositions().get(i)) < Integer.parseInt(solutionGagnante.getPropositions().get(i)))
                resultat.getResultats().add(i, "+");
            else
                resultat.getResultats().add(i, "-");
        }
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

    public void setSolutionGagnante(Proposition solutionGagnante) {
        this.solutionGagnante = solutionGagnante;
    }
}
