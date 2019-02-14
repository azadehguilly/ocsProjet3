package azadeh.ocs;

import org.junit.Test;

public class JeuTest {

    @Test
    public void verifierLancementPartie(){

        IJeu jeu = new Jeu();
        jeu.initialiser(0,0);

        jeu.lancerPartie();


    }
}
