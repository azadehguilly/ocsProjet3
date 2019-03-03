package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Possibilite;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.jeu.RechercheResultat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static azadeh.ocs.App.nbCase;

/**
 * Le decodeur est celui qui joue le role d'attaquant pour le jeu Recherche +/-
 * DecodeurOrdinateur est donc un ordinateur qui joue le role de decodeur.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class DecodeurOrdinateur implements IDecodeur {
    /**
     * LOGGER sert à la mise en place des log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DecodeurOrdinateur.class.getName());

    /**
     * possibilite est un objet de type Possibilite qui contient toutes les possibilites.
     *
     * @see Possibilite
     */
    private Possibilite possibilite;

    /**
     * derniereProposition est un objet de type Proposition qui contient la derniere proposition faite par l'attaquant
     *
     * @see Proposition
     */
    private Proposition derniereProposition;

    /**
     * Constructeur
     * Initialise la matrice des possibilités
     *
     * @param possibilite
     *      la matrice des possibilités
     */
    public DecodeurOrdinateur(Possibilite possibilite) {
        possibilite.initialiseToutesLesPossibilitesRecherche();
        this.possibilite = possibilite;
        this.derniereProposition = null;
    }

    /**
     * Constructeur
     *
     * @param possibilite
     *      la matrice des possibilités
     * @param derniereProposition
     *      derniere proposition faite
     */
    public DecodeurOrdinateur(Possibilite possibilite, Proposition derniereProposition) {
        this.possibilite = possibilite;
        this.derniereProposition = derniereProposition;
    }

    /**
     * Constructeur
     */
    public DecodeurOrdinateur() {
        this.possibilite = new Possibilite();
        possibilite.initialiseToutesLesPossibilitesRecherche();
        this.derniereProposition = null;
    }


    @Override
    public Proposition proposerUneCombinaison(IResultat rechercheResultat) {
        Proposition proposition = new Proposition();

        if (rechercheResultat != null)
            // Premiere etape: eliminer les possibilites non valides sur la base du rechercheResultat et de la derniere proposition
            reduireLesPossibilites((RechercheResultat) rechercheResultat);

        // Seconde etape: choisir une combinaison à partir des possibilites restantes
        proposition = choisirUneCombinaison(this.possibilite);
        this.derniereProposition = proposition;
        return proposition;
    }

    /**
     * Reduire les prossibilités par rapport au resultat et la derniereProposition
     *
     * @param rechercheResultat
     *      dernière resultat donnée
     */
    public void reduireLesPossibilites(RechercheResultat rechercheResultat) {
        int numColonne = 0;
        for (String resultatColonne : rechercheResultat.getResultats()) {
            LOGGER.debug("colonne: " +numColonne + " > " + resultatColonne);
            String symbol = this.derniereProposition.symboleALaPosition(numColonne);

            switch (resultatColonne) {
                case "+":
                    // On efface les nombres de 0 jusqu'à la de valeur proposée inclus
                    LOGGER.debug("Effacement symbole " + symbol + " à la position " + numColonne);
                    for (int valeurAEffacer = 0; valeurAEffacer <= Integer.valueOf(symbol); valeurAEffacer++) {
                        possibilite.effacerSymboleAtPossibilite(numColonne, Integer.toString(valeurAEffacer));
                    }
                    break;
                case "-":
                    // On efface les nombres de la valeur proposée inclus, au 9
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
        LOGGER.debug(derniereProposition.toString() + ">> RechercheResultat: " + rechercheResultat.toString() + " > Nouvelle version de possibilités: " + possibilite);
    }


    /**
     * Fait une proposition au hasard, parmis les possibilités existantes
     * Normelement cette methode doit être private. Il a etait mis en public pour poivoir faire des tests unitaire dessus.
     *
     * @param possibiliteActuel
     *      la liste des possibilites à cette instant
     * @return
     *      la possibilité choisi au hasard
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


    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     *
     * @param listePropo
     * @return null
     */
    @Override
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo) {
        return null;
    }


}
