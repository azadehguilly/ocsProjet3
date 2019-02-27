package azadeh.ocs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

/**
 * Le decodeur est celui qui joue le role d'attaquant pour le jeu Mastermind
 * DecodeurOrdinateurMastermind est donc un ordinateur qui joue le role de decodeur.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class DecodeurOrdinateurMastermind implements IDecodeur {

    /**
     * LOGGER sert à la mise en place des log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DecodeurOrdinateurMastermind.class.getName());

    /**
     * listePropositions, est une liste de type Proposition, qui contient toutes les propositions possible
     *
     * @see Proposition
     */
    public List<Proposition> listePropositions = new LinkedList<Proposition>();

    /**
     * derniereProposition est un objet de type Proposition qui contient la derniere proposition faite par l'attaquant
     *
     * @see Proposition
     */
    Proposition derniereProposition;

    /**
     * Constructeur qui initialise la liste des proposition avec toutes les proposition possible
     */
    public DecodeurOrdinateurMastermind() {
        String fragmentDepart = "";
        genererListSequence(fragmentDepart);
        this.derniereProposition = null;
    }

    /**
     * Cette méthode propose une combinaison dans la liste des propositions
     * Tout d'abord elle reduit la liste des propositions: elle met à jour la listePropositions en effacant les propositions qui ne repondent pas à la solution
     * Ensuite elle choisit une proposition parmis la nouvelle liste
     * Et elle met à jour la derniereProposition avec cette valeur
     *
     * @param resultat
     * @return combinaison
     */
    public Proposition proposerUneCombinaison(IResultat resultat) {
        List<String> symbolsAtColumn = new ArrayList<>();
        Random rand = new Random();
        List<Proposition> nouvelleListePropositions = new LinkedList<Proposition>(this.listePropositions);

        LOGGER.debug("Avant la suppression, la taille de la nouvelle liste est  : " + nouvelleListePropositions.size());

        if (resultat != null) {
            //eliminer les possibiilités qui non pas le meme resultat
            nouvelleListePropositions = reduireLaListeProposition(((MastermindResultat)resultat).getResultat(), this.listePropositions);
            this.listePropositions = nouvelleListePropositions;
        }
        LOGGER.debug("Apres la suppression, la taille de la nouvelle liste est  : " + nouvelleListePropositions.size());
        try {
            this.derniereProposition = choisirUnPropositionAuHasard(nouvelleListePropositions);
        } catch (java.lang.IllegalArgumentException e) {
            System.out.println("Le resultat donné est incorrecte. Le jeu est arreté");
            System.exit(-1);
            //Comment sortir proprement si le resultat donné n'est pas bon?
            //On a a déjà reduit la nouvelle liste à ce stade. On ne peut pas revenir en arriere.
            // Il faut arreter le jeu.
            // Pour eviter de sortir pas proprement j'ai comparé le resultat donné avec le resultat de l'ordinateur
        }

        return this.derniereProposition;
    }

    /**
     * Cette méthode reduit la listProposition suivant un resultat
     *
     * @param resultat
     * @param listePropositions
     * @return
     */
    private List<Proposition> reduireLaListeProposition(int resultat, List<Proposition> listePropositions) {
        List<Proposition> nouvelleListePropositions = new LinkedList<Proposition>(listePropositions);
        for (int i = 0; i < listePropositions.size(); i++) {
            Proposition propositionATester = new Proposition();
            propositionATester = listePropositions.get(i);

            int resultatATester = propositionATester.calculScore(propositionATester, this.derniereProposition);
            LOGGER.debug("propositionATester : " + propositionATester.toString() + "    this.derniereProposition : " + this.derniereProposition.toString() + "  resultatATester : " + resultatATester);
            LOGGER.debug("Pi:  " + propositionATester.toString() + ", P0: " + derniereProposition.toString() + " -> resultat 2 : " + resultatATester + " ------- resultat :" + resultat);
            if (resultatATester != resultat) {
                LOGGER.debug("proposition à supprimer ------" + propositionATester.getPropositions().toString());
                nouvelleListePropositions.remove(propositionATester);
            }
        }
        //affichage de la nouvelle liste reduit
        LOGGER.debug("la nouvelle liste des proposition est : ");
        for (int i = 0; i < nouvelleListePropositions.size(); i++) {
            LOGGER.debug(nouvelleListePropositions.get(i).toString());
        }

        return nouvelleListePropositions;
    }

    /**
     * Choisir une proposition au hasard dans la listePropo
     * Cette fonction est public juste pour les tests unitaires, sinon il doit etre en private.
     *
     * @param listePropo
     * @return
     */
    public Proposition choisirUnPropositionAuHasard(List<Proposition> listePropo) {
        Proposition randomProposition = new Proposition();
        Random rand = new Random();

        int randomIndex = rand.nextInt(listePropo.size());
        randomProposition = listePropo.get(randomIndex);

        return randomProposition;
    }

    /**
     * Cette méthode genere la liste de toutes les propositions possible.
     * C'est une fonction recurssif qui appelle lui même
     * Elle aliment l'attribut listePropositions
     *
     * @param fragmentChaine
     *      est un bout d'une proposition
     */
    public void genererListSequence(String fragmentChaine) {
        LOGGER.debug("n : " + fragmentChaine);

        if (fragmentChaine.length() == nbCase) {
            LOGGER.debug("Combinaison trouvée: " + fragmentChaine);
            listePropositions.add(new Proposition(fragmentChaine));
            return;
        }

        for (String symbol : symbols) {
            String nouveauFragmentChaine = fragmentChaine + symbol;
            genererListSequence(nouveauFragmentChaine);
        }

    }

    /**
     * Setteur de derniereProposition
     *
     * @param derniereProposition
     */
    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }

    /**
     * Cette methode n'est pas implementée pour cette classe. Elle existe ici car la classe implemente IDecodeur.
     *
     * @param rechercheResultat
     * @return null

    @Override
    public Proposition proposerUneCombinaison(RechercheResultat rechercheResultat) {
        return null;
    }
     */
}
