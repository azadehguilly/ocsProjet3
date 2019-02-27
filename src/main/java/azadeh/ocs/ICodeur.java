package azadeh.ocs;

/**
 * ICodeur est un interface pour le role de defenseur
 */
public interface ICodeur {

    /**
     * Générer la Solution gagnante aleatoir
     */
    public void genereLaSolutionGagnante();

    /**
     * Cette méthode nous donne le resultat d'un tour sous la forme +, - et =
     *
     * @param prop est la proposition de l'attaquant.
     * @return un objet de type Resultat
     * @see Resultat
     */
    public Resultat evaluerUneProposition(Proposition prop); //pour jeu recherche

    /**
     * Cette méthode nous donne le resultat d'un tour sous la forme d'un entier de 2 digits. le chiffre des dizaines étant égal au nombre de chiffre bien placés (pion rouge) et le chiffre des unités à celui des chiffres présents (pions blanches)
     *
     * @param solutionGagnante
     * @param prop
     * @return
     */
    public int calculScore(Proposition solutionGagnante, Proposition prop); //pour le jeu mastermind

    /**
     * Verifie si le resultat est gagnant.
     *
     * @param resultat
     * @return
     */
    public boolean isPartieGagnante(Resultat resultat);

    /**
     * Verifie si le resultat est gagnant.
     *
     * @param resultat
     * @return
     */
    public boolean isPartieGagnante(int resultat);

    /**
     * Getteur de la solutionGagnante
     *
     * @return
     */
    public Proposition getSolutionGagnante();
}
