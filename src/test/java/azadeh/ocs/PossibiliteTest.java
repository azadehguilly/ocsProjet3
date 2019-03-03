package azadeh.ocs;

import azadeh.ocs.model.jeu.Possibilite;
import azadeh.ocs.technique.LireFichierProperties;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.symbols;

public class PossibiliteTest {

    @Test
    public void verifierLInitialisation(){

        //Arrange
        LireFichierProperties lireFichierProperties = new LireFichierProperties();
        lireFichierProperties.importerLesParametres();
        symbols = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        nbCase = 4;


        Possibilite possibilite = new Possibilite();

        //Act
        possibilite.initialiseToutesLesPossibilitesRecherche();

        //Assert
        String representation = possibilite.toString();

        Assert.assertEquals("Method toString works as expected", "0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9 ; 0,1,2,3,4,5,6,7,8,9", representation);
    }

    @Test
    public void verifieSuppressionSymboleALaPositionDonnee(){
        //Arrange
        ArrayList<String> intPossibilite = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        Possibilite possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite);

        //Act
        System.out.println("Avant : "+ possibilite.toString());
        possibilite.effacerSymboleAtPossibilite(0,"2");
        System.out.println("Apres : "+possibilite.toString());

        //Assert
        String representation = possibilite.toString();
        Assert.assertEquals("Method effacerSymboleAtPossibilite works as expected", "0,1,3,4,5,6,7,8,9", possibilite.toString());
    }





}
