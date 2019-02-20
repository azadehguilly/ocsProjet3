package azadeh.ocs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static azadeh.ocs.App.nbCase;

public class DecodeurOrdinateur implements IDecodeur {

    private Possibilite possibilite;
    private Proposition derniereProposition;

    /**
     * Constructeur
     * Initialise la matrice des possibilités
     *
     * @param possibilite
     */
    public DecodeurOrdinateur(Possibilite possibilite) {
        possibilite.initialiseMatricePossibilite();
        this.possibilite = possibilite;
        this.derniereProposition = null;
    }

    public DecodeurOrdinateur(Possibilite possibilite, Proposition derniereProposition) {
        this.possibilite = possibilite;
        this.derniereProposition = derniereProposition;
    }

    public DecodeurOrdinateur() {
        this.possibilite = new Possibilite();
        possibilite.initialiseMatricePossibilite();
        this.derniereProposition = null;
    }

    /**
     * Propose une combinaison par rapport à un matrice de possibilité
     *
     * @return combinaison
     */
    @Override
    public Proposition proposerUneCombinaison(Resultat resultat) {
        Proposition proposition = new Proposition();

        if (resultat != null)
            // Premiere etape: eliminer les possibilites non valides sur la base du resultat et de la derniere proposition
            reduireLesPossibilites(resultat);

        // Seconde etape: choisir une combinaison à partir des possibilites restantes
        proposition = choisirUneCombinaison(this.possibilite);

        return proposition;
    }

    /**
     * Reduire les listes des prossibilités par rapport à un Resultat et une Proposition
     *
     * @param resultat
     */
    public void reduireLesPossibilites(Resultat resultat) {
        int numColonne = 0;
        for (String resultatColonne : resultat.getResultats()) {
            //System.out.println("colonne: " +numColonne + " > " + resultatColonne);
            String symbol = derniereProposition.symboleALaPosition(numColonne);

            switch (resultatColonne) {
                case "+":
                    //System.out.println("Effacement symbole " + symbol + " à la position " + numColonne);
                    for (int valeurAEffacer = 0; valeurAEffacer <= Integer.valueOf(symbol); valeurAEffacer++) {
                        possibilite.effacerSymboleAtPossibilite(numColonne, Integer.toString(valeurAEffacer));
                    }
                    break;
                case "-":
                    // On efface les nombres de 0 à la valeur proposée
                    for (int valeurAEffacer = Integer.valueOf(symbol); valeurAEffacer <= 9; valeurAEffacer++) {
                        possibilite.effacerSymboleAtPossibilite(numColonne, Integer.toString(valeurAEffacer));
                    }
                    break;
                case "=":
                    possibilite.affecterSymboleALaPosition(numColonne, symbol);
                    break;
            }
            numColonne++;
        }
        //System.out.println(derniereProposition.toString() + ">> Resultat: " + resultat.toString() + " > Nouvelle version de possibilités: " + possibilite);
    }


    /**
     * Proposer une combinaison parmis les possibilités existant
     *
     * @param possibiliteActuel
     * @return
     */
    public Proposition choisirUneCombinaison(Possibilite possibiliteActuel) {
        int rand;
        Proposition proposition = new Proposition();
        String symbolRandom = new String();
        List<String> symbolsAtColumn = new ArrayList<>();

        for (int i = 0; i < nbCase; i++) {
            rand = ThreadLocalRandom.current().nextInt(possibiliteActuel.minListeALaPositionDonnee(i), possibiliteActuel.maxListeALaPositionDonnee(i) + 1);
            symbolRandom = Integer.toString(rand);
            symbolsAtColumn.add(symbolRandom);
        }
        proposition.setPropositions(symbolsAtColumn);
        return proposition;
    }

    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }
}
