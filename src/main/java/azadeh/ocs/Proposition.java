package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Representation d'une proposition sous la forme d'une séquence de chiffre
 */
public class Proposition {
    /**
     * propositions est une liste de String
     */
    private List<String> propositions;

    /**
     * Constructeur
     */
    public Proposition() {
        propositions = new ArrayList<String>();
    }

    /**
     * Constructeur qui prend un string en entrée et le transforme à une proposition.
     * Prend chaque caractère de String d'entrée et le transforme a un element de la liste.
     *
     * @param listeDeSymboles
     */
    public Proposition(String listeDeSymboles){
        int longueur = listeDeSymboles.length();
        this.propositions = new ArrayList<String>();
        for (int i=0; i<longueur; i++){
            propositions.add(listeDeSymboles.substring(i, i+1));
        }
    }

    /**
     * Constructeur
     *
     * @param propositions
     */
    public Proposition(List<String> propositions) {
        this.propositions = new ArrayList<String>(propositions);
    }

    /**
     * Getteur de propositions
     *
     * @return
     */
    public List<String> getPropositions() {
        return this.propositions;
    }

    /**
     * Setteur de propositions
     *
     * @param propositions
     */
    public void setPropositions(List<String> propositions) {
        this.propositions = propositions;
    }

    /**
     * Afficher la proposition
     * @return
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int position = 0;
        for (String resultat : propositions) {
            stringBuilder.append(resultat);
            if (position != propositions.size() - 1)
                stringBuilder.append("");
            position++;
        }
        return stringBuilder.toString();
    }

    /**
     * Cette methode nous donne la symbole à la position demandé de la proposition
     *
     * @param numeroColonne
     * @return
     */
    public String symboleALaPosition(int numeroColonne) {
        return propositions.get(numeroColonne);
    }


    /**
     * Calcul du score
     * Nous donne le resultat d'un tour pour le jeu de Mastermind
     *
     * @param solutionGagnante
     * @param prop
     * @return Un entier de 2 digit. le chiffre des dizaines étant égal au nombre de chiffre bien placés (pion rouge) et le chiffre des unités à celui des chiffres présents (pions blanches)
     */
    public int calculScore(Proposition solutionGagnante, Proposition prop) {
        int resultat = 0;
        int nbRouge = 0; //nombre de pions bien placé
        int nbBlanc = 0;//nombre de pions mal placé

        nbRouge = calculNombrepionRouge(solutionGagnante,prop);
        nbBlanc = -nbRouge;
        nbBlanc = calculNombrepionBlanc(solutionGagnante, prop, nbBlanc);
        resultat = 10 * nbRouge + nbBlanc;
        return resultat;
    }

    /**
     * Calcul de nombres de pions bien placé, pions Rouge
     *
     * @param solutionGagnante
     * @param prop
     * @return
     */
    private int calculNombrepionRouge(Proposition solutionGagnante,Proposition prop) {
        int nbRouge = 0; //nombre de pion bien placé
        for (int i = 0; i < nbCase; i++) {
            // On balaye les 2 listes pour trouver le nombre de bonne couleur bien placé
            if (prop.getPropositions().get(i).equals(solutionGagnante.getPropositions().get(i)))
                nbRouge++;
        }
        return nbRouge;
    }

    /**
     * Calcul de nombres de pions mal placé, blanc
     * Tout d'abord, on calcule l'occurances de chaque couleur dans la solutionGagnante et proposition -> occuranceSolution et occuranceProposition
     * On applique la formule de nombre de pions mal placé : nbBlanc = Somme (0,symbols.length-1) min(ni,mi)-nbRouge
     *
     * @param prop
     * @param nbBlanc
     * @return
     */
    private int calculNombrepionBlanc(Proposition solutionGagnante,Proposition prop, int nbBlanc) {
        int occuranceSolution = 0; //la couleur apparaît n fois dans la solutionGagnante
        int occuranceProposition = 0; //la couleur i apparaît m fois dans la proposition

        for (int i = 0; i < symbols.length; i++) {
            occuranceSolution = 0;
            occuranceProposition = 0;
            for (int j = 0; j < nbCase; j++) {
                if (Integer.parseInt(solutionGagnante.getPropositions().get(j)) == i)
                    occuranceSolution++;
                if (Integer.parseInt(prop.getPropositions().get(j)) == i)
                    occuranceProposition++;
            }
            if (occuranceSolution < occuranceProposition) nbBlanc = nbBlanc + occuranceSolution;
            else nbBlanc = nbBlanc + occuranceProposition;
        }
        return nbBlanc;
    }

}
