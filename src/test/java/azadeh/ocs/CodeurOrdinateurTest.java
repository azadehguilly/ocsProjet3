package azadeh.ocs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeurOrdinateurTest {

    @Test
    public void verifierLaGenerationSolutionGagnanteUnChiffre() {
        //Arrange
        CodeurOrdinateur codeur = new CodeurOrdinateur();

        //Act
        codeur.genereLaSolutionGagnante();

        //Assert
        System.out.println("La solution gagnante est : " + codeur.getSolutionGagnante().toString());
    }



    @Test
    public void verifierEvaluerUnePropositionQuandLaPropositionEgaleASolution(){
        //Arrange
        CodeurOrdinateur codeur = new CodeurOrdinateur();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        Resultat res = new Resultat();
        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"1", "2", "3", "4"}));

        //Act
        sol.setPropositions(initArrayList);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayList);
        res = codeur.evaluerUneProposition(prop);

        //Assert
        Assert.assertEquals("evaluerUneProposition ====","====", res.toString());
    }

    @Test
    public void verifierEvaluerUnePropositionQuandLaPropositionPasEgaleASolution(){
        //Arrange
        CodeurOrdinateur codeur = new CodeurOrdinateur();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        Resultat res = new Resultat();
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"5", "5", "6", "9"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"1", "5", "8", "4"}));

        //Act
        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayListProp);
        res = codeur.evaluerUneProposition(prop);

        //Assert
        Assert.assertEquals("evaluerUneProposition +=-+","+=-+", res.toString());
    }

}
