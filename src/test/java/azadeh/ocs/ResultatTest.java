package azadeh.ocs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultatTest {


    @Test
    public void verifierCreationAPartirDUneSequence(){

        //Arrange
        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+", "=", "-", "-"}));

        //Act
        Resultat resultat = new Resultat(initArrayList);

        //Assert
        Assert.assertEquals("Constructeur ) partir d'un Arrayist","+=--", resultat.toString());

    }

}
