package azadeh.ocs.supp;

import azadeh.ocs.Proposition;
import org.junit.Assert;
import org.junit.Test;

public class PropositionTest {

    @Test
    public void verifierConstructeur(){
        Proposition prop = new Proposition("ABDFF");
        Assert.assertEquals("Constructeur à partir de chaine de caracteres", "ABDFF", prop.toString());
        Assert.assertEquals("Constructeur à partir de chaine de caracteres", 5, prop.getPropositions().size());
    }
}
