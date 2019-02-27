package azadeh.ocs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CodeurOrdinateurMastermindTest {

    @Test
    public void verifierLaGenerationSolutionGagnanteMastermind() {
        //Arrange
        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();

        //Act
        codeur.genereLaSolutionGagnante();

        //Assert
        System.out.println("La solution gagnante est : " + codeur.getSolutionGagnante().toString());
    }


    @Test
    public void verifiercalculScore10() {
        //Arrange
        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat res;
        //ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"3", "1", "3", "2"}));
        //ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"2", "3", "3", "0"}));
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "0", "2"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"0", "0", "0"}));
        //Act
        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayListProp);
        res = codeur.evaluerUneProposition(prop);
        System.out.println("le score est : " + res.toString());
        //Assert
        Assert.assertEquals("evaluerUneProposition 10", 10, res.toString());
    }



    @Test
    public void verifiercalculScore30() {
        //Arrange
        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat res;
       // ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"3", "1", "3", "2"}));
        //ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"3", "1", "3", "2"}));
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "0", "2"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"1", "0", "2"}));
        //Act
        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayListProp);
        res = codeur.evaluerUneProposition(prop);
        System.out.println("le score est : " + res.toString());
        //Assert
        Assert.assertEquals("evaluerUneProposition 30", 30, res.toString());
    }

    @Test
    public void verifiercalculScore20() {
        //Arrange
        CodeurOrdinateurMastermind codeur = new CodeurOrdinateurMastermind();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat res;
        //ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"3", "1", "3", "2"}));
        //ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"2", "3", "3", "0"}));
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "1", "0"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"1", "1", "1"}));
        //Act
        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayListProp);
        res = codeur.evaluerUneProposition(prop);
        System.out.println("le score est : " + res.toString());
        //Assert
        Assert.assertEquals("evaluerUneProposition 10", 20, res.toString());
    }

}
