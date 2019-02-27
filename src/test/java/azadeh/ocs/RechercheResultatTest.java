package azadeh.ocs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RechercheResultatTest {


    @Test
    public void verifierCreationAPartirDUneSequence(){

        //Arrange
        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+", "=", "-", "-"}));

        //Act
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        //Assert
        Assert.assertEquals("Constructeur ) partir d'un Arrayist","+=--", rechercheResultat.toString());

    }

}
