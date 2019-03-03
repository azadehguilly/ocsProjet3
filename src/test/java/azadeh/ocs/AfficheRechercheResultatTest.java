package azadeh.ocs;

import azadeh.ocs.model.jeu.IResultat;
import azadeh.ocs.model.jeu.MastermindResultat;
import org.junit.Assert;
import org.junit.Test;

public class AfficheRechercheResultatTest {

    @Test
    public void verifierModifieResultatMastermindIntToString0() {
        //Arrange
        IResultat resultat = new MastermindResultat(0);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 0", "Rien est bon", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString1() {
        //Arrange
        IResultat resultat = new MastermindResultat(1);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 1", "1 présent", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString2() {
        //Arrange
        IResultat resultat = new MastermindResultat(2);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 2", "2 présents", resultat.toString());

    }

    @Test
    public void verifierModifieResultatMastermindIntToString10() {
        //Arrange
        IResultat resultat = new MastermindResultat(10);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 10", "1 bien placé", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString20() {
        //Arrange
        IResultat resultat = new MastermindResultat(20);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 20", "2 bien placés", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString12() {
        //Arrange
        IResultat resultat = new MastermindResultat(12);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 12", "2 présents, 1 bien placé", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString22() {
        //Arrange
        IResultat resultat = new MastermindResultat(22);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 22", "2 présents, 2 bien placés", resultat.toString());
    }

    @Test
    public void verifierModifieResultatMastermindIntToString21() {
        //Arrange
        IResultat resultat = new MastermindResultat(21);
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 21", "1 présent, 2 bien placés", resultat.toString());
    }

}
