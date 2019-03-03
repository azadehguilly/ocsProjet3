package azadeh.ocs.model.joueur;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.MastermindResultat;
import azadeh.ocs.model.jeu.Proposition;
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
    public Proposition derniereProposition;

    /**
     * Constructeur qui initialise la liste des proposition avec toutes les proposition possible
     */
    public DecodeurOrdinateurMastermind() {
        String fragmentDepart = "";
        genererListSequence(fragmentDepart);
        this.derniereProposition = null;
    }


    @Override
    public Proposition proposerUneCombinaison(IResultat resultat) {
        List<String> symbolsAtColumn = new ArrayList<>();
        Random rand = new Random();
        List<Proposition> nouvelleListePropositions = new LinkedList<Proposition>(this.listePropositions);

        LOGGER.debug("Avant la suppression, la taille de la nouvelle liste est  : " + nouvelleListePropositions.size());

        if (resultat != null) {
            //eliminer les possibiilités qui non pas le meme resultat
            nouvelleListePropositions = reduireLaListeProposition(((MastermindResultat) resultat).getResultat(), this.listePropositions);
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
     *      la derniere resultat donnée
     * @param listePropositions
     *      liste devoir reduit
     * @return
     *      la nouvelle liste mise à jour qui a etait reduit suivant le resultat
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


    @Override
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


    @Override
    public void setDerniereProposition(Proposition derniereProposition) {
        this.derniereProposition = derniereProposition;
    }


}
