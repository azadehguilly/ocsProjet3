package azadeh.ocs;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.Proposition;
import azadeh.ocs.model.jeu.RechercheResultat;
import azadeh.ocs.model.joueur.CodeurOrdinateur;
import azadeh.ocs.technique.LireFichierProperties;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static azadeh.ocs.App.*;

public class CodeurOrdinateurTest {

    @Test
    public void verifierLaGenerationSolutionGagnanteUnChiffre() {
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        symbols = new String[symbolsRechercheTable.length];
        System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);

        CodeurOrdinateur codeur = new CodeurOrdinateur();

        //Act
        codeur.genereLaSolutionGagnante();

        //Assert
        System.out.println("La solution gagnante est : " + codeur.getSolutionGagnante().toString());
    }



    @Test
    public void verifierEvaluerUnePropositionQuandLaPropositionEgaleASolution(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        //symbols = new String[symbolsRechercheTable.length];
        //System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);
        symbols = new String[]{"0","1","2"};
        nbCase = 3;

        CodeurOrdinateur codeur = new CodeurOrdinateur();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat res = new RechercheResultat();
        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"1", "2", "2"}));

        //Act
        sol.setPropositions(initArrayList);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayList);
        res = codeur.evaluerUneProposition(prop);

        //Assert
        Assert.assertEquals("evaluerUneProposition ===","===", res.toString());
    }

    @Test
    public void verifierEvaluerUnePropositionQuandLaPropositionPasEgaleASolution(){
        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        //symbols = new String[symbolsRechercheTable.length];
        //System.arraycopy(symbolsRechercheTable, 0, symbols, 0, symbolsRechercheTable.length);
        symbols = new String[]{"0","1","2"};
        nbCase = 3;

        CodeurOrdinateur codeur = new CodeurOrdinateur();
        Proposition sol = new Proposition();
        Proposition prop = new Proposition();
        IResultat res = new RechercheResultat();
        ArrayList<String> initArrayListSol = new ArrayList<String>(Arrays.asList(new String[]{"1", "2", "0"}));
        ArrayList<String> initArrayListProp = new ArrayList<String>(Arrays.asList(new String[]{"0", "0", "2"}));

        //Act
        sol.setPropositions(initArrayListSol);
        codeur.setSolutionGagnante(sol);
        prop.setPropositions(initArrayListProp);
        res = codeur.evaluerUneProposition(prop);

        //Assert
        Assert.assertEquals("evaluerUneProposition +-+","++-", res.toString());
    }

}
