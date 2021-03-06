package azadeh.ocs;

import azadeh.ocs.model.jeu.RechercheResultat;
import azadeh.ocs.model.joueur.CodeurOrdinateur;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CodeurCommunTest {

    @Test
    public void verificationPartieGagnanteQuandPasGagnante(){
        //Arrange
        CodeurOrdinateur codeur = new CodeurOrdinateur();

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+", "=", "-"}));

        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);
        //Act
        boolean isFound = codeur.isPartieGagnante(rechercheResultat);
        //Assert
        Assert.assertTrue("Verif partie gagnante", !isFound);

    }

    @Test
    public void verificationPartieGagnanteQuandGagnante(){
        //Arrange
        CodeurOrdinateur codeur = new CodeurOrdinateur();

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"=", "=", "="}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);
        //Act
        boolean isFound = codeur.isPartieGagnante(rechercheResultat);
        //Assert
        Assert.assertTrue("Verif partie gagnante", isFound);

    }
}
