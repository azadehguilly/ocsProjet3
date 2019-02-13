package azadeh.ocs;

import static azadeh.ocs.App.nbCase;

public class Combinaison {
    public String[] combinaison;


    public Combinaison() {
        this.combinaison = new String[nbCase];
    }

    public String[] getCombinaison() {
        return combinaison;
    }

    public void setCombinaison(String[] combinaison) {
        this.combinaison = combinaison;
    }
}
