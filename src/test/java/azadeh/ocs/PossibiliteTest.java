package azadeh.ocs;

import org.junit.Assert;
import org.junit.Test;

public class PossibiliteTest {

    @Test
    public void verifierLInitialisation(){

        //Arrange
        Possibilite possibilite = new Possibilite();

        //Act
        possibilite.initialiseMatricePossibilite();

        //Assert
        String representation = possibilite.toString();

        Assert.assertEquals("Method toString works as expected", "0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9", representation);

    }
}
