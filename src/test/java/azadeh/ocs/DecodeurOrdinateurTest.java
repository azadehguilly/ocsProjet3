package azadeh.ocs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DecodeurOrdinateurTest {

    Possibilite possibilite;

    @Before
    public void initialisation(){
        ArrayList<String> intPossibilite1 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite2 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite3 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite4 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite1);
        possibilite.addListToPossibilite(intPossibilite2);
        possibilite.addListToPossibilite(intPossibilite3);
        possibilite.addListToPossibilite(intPossibilite4);
    }

    @Test
    public void verifierNouvelleProposition() {
        //Arrange

        ArrayList<String> intPossibilite1 = new ArrayList<String>(Arrays.asList(new String[]{"2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite2 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite3 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite4 = new ArrayList<String>(Arrays.asList(new String[]{"3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite1);
        possibilite.addListToPossibilite(intPossibilite2);
        possibilite.addListToPossibilite(intPossibilite3);
        possibilite.addListToPossibilite(intPossibilite4);

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+", "-", "=", "-"}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        ArrayList<String> intDernierePropos = new ArrayList<String>(Arrays.asList(new String[]{"4", "4", "3", "7"}));
        Proposition dernierePropo = new Proposition(intDernierePropos);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, dernierePropo);

        //Act
        decodeur.proposerUneCombinaison(rechercheResultat);
        System.out.println(possibilite.toString());

        //Assert
        System.out.println("La proposition est : " + decodeur.proposerUneCombinaison(rechercheResultat).toString());
    }


    @Test
    public void reduireLesPossibilitesTestInf(){
        // Arrange
        ArrayList<String> intPossibilite = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite);

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+"}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        ArrayList<String> intDernierePropos = new ArrayList<String>(Arrays.asList(new String[]{"4"}));
        Proposition dernierePropo = new Proposition(intDernierePropos);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, dernierePropo);

        // Act
        decodeur.reduireLesPossibilites(rechercheResultat);
        System.out.println(possibilite.toString());

        // Assert
        Assert.assertTrue("Gestion du résultat +", "5,6,7,8,9".equals(possibilite.toString()));

    }

    @Test
    public void reduireLesPossibilitesTestSupp(){
        // Arrange
        ArrayList<String> intPossibilite = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite);

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"-"}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        ArrayList<String> intDernierePropos = new ArrayList<String>(Arrays.asList(new String[]{"4"}));
        Proposition dernierePropo = new Proposition(intDernierePropos);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, dernierePropo);

        // Act
        decodeur.reduireLesPossibilites(rechercheResultat);
        System.out.println(possibilite.toString());

        // Assert
        Assert.assertTrue("Gestion du résultat +", "0,1,2,3".equals(possibilite.toString()));

    }


    @Test
    public void reduireLesPossibilitesTestEgal(){
        // Arrange
        ArrayList<String> intPossibilite = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite);

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"="}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        ArrayList<String> intDernierePropos = new ArrayList<String>(Arrays.asList(new String[]{"4"}));
        Proposition dernierePropo = new Proposition(intDernierePropos);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, dernierePropo);

        // Act
        decodeur.reduireLesPossibilites(rechercheResultat);
        System.out.println(possibilite.toString());

        // Assert
        Assert.assertTrue("Gestion du résultat +", "4".equals(possibilite.toString()));

    }

    @Test
    public void reduireLesPossibilitesTestInf4(){
        // Arrange
        ArrayList<String> intPossibilite1 = new ArrayList<String>(Arrays.asList(new String[]{"2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite2 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite3 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        ArrayList<String> intPossibilite4 = new ArrayList<String>(Arrays.asList(new String[]{"3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite1);
        possibilite.addListToPossibilite(intPossibilite2);
        possibilite.addListToPossibilite(intPossibilite3);
        possibilite.addListToPossibilite(intPossibilite4);

        ArrayList<String> initArrayList = new ArrayList<String>(Arrays.asList(new String[]{"+", "-","+","-"}));
        RechercheResultat rechercheResultat = new RechercheResultat(initArrayList);

        ArrayList<String> intDernierePropos = new ArrayList<String>(Arrays.asList(new String[]{"4", "4", "3", "9"}));
        Proposition dernierePropo = new Proposition(intDernierePropos);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, dernierePropo);

        // Act
        decodeur.reduireLesPossibilites(rechercheResultat);
        System.out.println(possibilite.toString());

        // Assert
        Assert.assertTrue("Gestion du résultat +-+-", "5,6,7,8,9 ; 0,1,2,3 ; 4,5,6,7,8,9 ; 3,4,5,6,7,8".equals(possibilite.toString()));

    }



    @Test
    public void verifierLaGenerationDUneCombinaison() {
        //Arrange
        ArrayList<String> intPossibilite1 = new ArrayList<String>(Arrays.asList(new String[]{"2", "3", "4", "5"}));
        ArrayList<String> intPossibilite2 = new ArrayList<String>(Arrays.asList(new String[]{"5", "6", "7"}));
        ArrayList<String> intPossibilite3 = new ArrayList<String>(Arrays.asList(new String[]{"3"}));
        ArrayList<String> intPossibilite4 = new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        possibilite = new Possibilite();
        possibilite.addListToPossibilite(intPossibilite1);
        possibilite.addListToPossibilite(intPossibilite2);
        possibilite.addListToPossibilite(intPossibilite3);
        possibilite.addListToPossibilite(intPossibilite4);

        DecodeurOrdinateur decodeur = new DecodeurOrdinateur(possibilite, null);
        //Act
        decodeur.choisirUneCombinaison(possibilite);

        //Assert
        System.out.println("La combinaison choisi est : " + decodeur.choisirUneCombinaison(possibilite).toString());
    }

}
