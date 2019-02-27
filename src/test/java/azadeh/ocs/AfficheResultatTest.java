package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultat;
import org.junit.Assert;
import org.junit.Test;

public class AfficheResultatTest {

    @Test
    public void verifierModifieResultatMastermindIntToString0() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 0","Rien est bon", afficheResultat.modifieResultatMastermindIntToString(0));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString1() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 1","1 présent" ,afficheResultat.modifieResultatMastermindIntToString(1));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString2() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 2" ,"2 présents", afficheResultat.modifieResultatMastermindIntToString(2));

    }

    @Test
    public void verifierModifieResultatMastermindIntToString10() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 10","1 bien placé",afficheResultat.modifieResultatMastermindIntToString(10));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString20() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 20","2 bien placés", afficheResultat.modifieResultatMastermindIntToString(20));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString12() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 12","2 présents, 1 bien placé",afficheResultat.modifieResultatMastermindIntToString(12));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString22() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 22","2 présents, 2 bien placés", afficheResultat.modifieResultatMastermindIntToString(22));
    }

    @Test
    public void verifierModifieResultatMastermindIntToString21() {
        //Arrange
        AfficheResultat afficheResultat = new AfficheResultat();
        //Act

        //Assert
        Assert.assertEquals("evaluer un resultat 21","1 présent, 2 bien placés", afficheResultat.modifieResultatMastermindIntToString(21));
    }
}
