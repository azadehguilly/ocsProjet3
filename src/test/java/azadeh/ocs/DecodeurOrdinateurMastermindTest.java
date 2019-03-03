package azadeh.ocs;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.joueur.CodeurOrdinateurMastermind;
import azadeh.ocs.model.joueur.DecodeurOrdinateurMastermind;
import azadeh.ocs.technique.LireFichierProperties;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static azadeh.ocs.App.*;

public class DecodeurOrdinateurMastermindTest {

    @Test
    public void verifieGenererListSequence(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        symbols = new String[symbolsMastermindTable.length];
        System.arraycopy(symbolsMastermindTable, 0, symbols, 0, symbolsMastermindTable.length);

        DecodeurOrdinateurMastermind decodeur = new DecodeurOrdinateurMastermind();
        String fragmentDepart = "";

        //Act
        decodeur.genererListSequence(fragmentDepart);

        //Assert

        System.out.println("-------" + decodeur.listePropositions.size());
        //Assert.assertEquals("La liste des possibilité est de 27 possibilité", "AA", possibilite.toString());
    }

    @Test
    public void verifieChoisirUnPropositionAuHasard(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        symbols = new String[symbolsMastermindTable.length];
        System.arraycopy(symbolsMastermindTable, 0, symbols, 0, symbolsMastermindTable.length);

        DecodeurOrdinateurMastermind decodeur = new DecodeurOrdinateurMastermind();
        String fragmentDepart = "";
        decodeur.genererListSequence(fragmentDepart);

        //Act
        Proposition proposition = decodeur.choisirUnPropositionAuHasard(decodeur.listePropositions);


        //Assert
        System.out.println("Proposition choisi est "+ proposition.toString());
    }

    @Test
    public void verifieProposerUneCombinaisonPasPremiereFois(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        //symbols = new String[symbolsRechercheTable.length];
        //System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);
        symbols = new String[]{"0","1","2"};
        nbCase = 3;

        DecodeurOrdinateurMastermind decodeur = new DecodeurOrdinateurMastermind();

        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();

        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat resultat;
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "0", "2"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"0", "0", "0"}));

        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);

        prop.setPropositions(initArrayListProp);
        decodeur.derniereProposition = prop;

        resultat = codeur.evaluerUneProposition(prop);
        System.out.println("resultat doit etre egale a 10 : " + resultat);

        //Act
        Proposition nouvelleProposition = new Proposition();
        nouvelleProposition = decodeur.proposerUneCombinaison(resultat);

        //Assert
        System.out.println("La nouvelle proposition est : "+ nouvelleProposition.toString());
    }


    @Test
    public void verifieProposerUneCombinaisonPremiereFois(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        //symbols = new String[symbolsRechercheTable.length];
        //System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);
        symbols = new String[]{"0","1","2"};
        nbCase = 3;

        DecodeurOrdinateurMastermind decodeur = new DecodeurOrdinateurMastermind();
        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();

        Proposition sol = new Proposition();
        IResultat resultat=null;
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "0", "2"}));

        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);

        //Act
        Proposition prop = new Proposition();
        prop = decodeur.proposerUneCombinaison(resultat);
        resultat = codeur.evaluerUneProposition(prop);

        //Assert
        System.out.println("Pour la solution : "+  sol.toString()+ " et la proposition : "+ prop.toString() +" le resultat est egale à : " + resultat);
    }

}
