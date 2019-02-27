package azadeh.ocs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DecodeurOrdinateurMastermindTest {

    @Test
    public void verifieGenererListSequence(){
        //Arrange
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
