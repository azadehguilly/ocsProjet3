package azadeh.ocs.supp;

import java.util.ArrayList;
import java.util.List;

public class LanceurDeJeu {

    List<String> listeDeJeux = new ArrayList<String>();


    public void ajouterJeu(String nomDuJeu) {
        listeDeJeux.add(nomDuJeu);

    }

    public List<String> jeuxDisponible() {
        return listeDeJeux;
    }
}
