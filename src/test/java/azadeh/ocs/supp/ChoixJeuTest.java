package azadeh.ocs.supp;

import supp.LanceurDeJeu;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ChoixJeuTest {

    //feature exemple
    @Test
    public void AfficherDesJeuDisponible() {
        //arrange
        LanceurDeJeu lanceurDeJeu = new LanceurDeJeu();
        lanceurDeJeu.ajouterJeu("Mastermind");
        lanceurDeJeu.ajouterJeu("Recherche");
        lanceurDeJeu.ajouterJeu("NewGame");

        //act
        List<String> listeJeuxDisponible = lanceurDeJeu.jeuxDisponible();

        //assert
        Assert.assertEquals(3, listeJeuxDisponible.size());
        Assert.assertEquals("Mastermind", listeJeuxDisponible.get(0));
        Assert.assertEquals("Recherche", listeJeuxDisponible.get(1));
        Assert.assertEquals("NewGame", listeJeuxDisponible.get(2));
    }


    //TDD : test unitaire
    @Test
    public void AjouterUnJeu() {
        //arrange
        LanceurDeJeu lanceurDeJeu = new LanceurDeJeu();

        //act
        lanceurDeJeu.ajouterJeu("Mastermind");
        List<String> listeJeuxDisponible = lanceurDeJeu.jeuxDisponible();

        //Assert
        Assert.assertEquals("Mastermind", listeJeuxDisponible.get(0));
    }

    //feature exemple
    @Test
    public void PasDeJeux() {
        //arrange
        LanceurDeJeu lanceurDeJeu = new LanceurDeJeu();

        //act
        List<String> listeJeuxDisponible = lanceurDeJeu.jeuxDisponible();

        //Assert
        Assert.assertEquals(0, listeJeuxDisponible.size());
    }


}
