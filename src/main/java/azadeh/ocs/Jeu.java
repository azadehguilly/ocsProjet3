package azadeh.ocs;

public class Jeu {

    protected int nbCase;
    protected int nbEssais;
    protected int[] solution;
    protected int[] proposition;
    protected String[] affichage;
    protected int[] max;
    protected int[] min;


    public Jeu(int nbCase, int nbEssais) {
        this.nbCase = nbCase;
        this.nbEssais = nbEssais;
        this.solution = new int[this.nbCase];
        this.proposition = new int[this.nbCase];
        this.affichage = new String[this.nbCase];
        this.max = new int[this.nbCase];
        this.min = new int[this.nbCase];
        for (int i = 0; i < this.nbCase; i++) {
            this.proposition[i] = -1;
            this.max[i] = 9;
            this.min[i] = 0;
        }
    }


    /**
     * fait une proposition pour le jeu de recherche en prenant en compte la proposition du tour precedent
     * met à jour l'attribut solution
     * ?????????????cette fonction ici marche pour les deux mode de jeux challenger et defenseur. Je l'ai separé pour mettre dans chaque class
     * Je ne sais pas quelle solution est mieux???????????

     public int[] lanceRandomRechercheParrapportTourPrecedent() {
     int[] resultat = new int[nbCase];

     for (int i = 0; i < this.nbCase; i++) {

     if (this.proposition[i] == -1) {
     resultat[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
     } else if (this.proposition[i] < this.solution[i]) {
     this.min[i] = proposition[i] + 1;
     resultat[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
     } else if (this.proposition[i] > this.solution[i]) {
     this.max[i] = proposition[i] - 1;
     resultat[i] = ThreadLocalRandom.current().nextInt(min[i], max[i] + 1);
     } else // (this.proposition[i] == this.solution[i]) {
     resultat[i] = this.proposition[i];
     }
     return resultat;
     }
     */

    /**
     * nous donne le resultat d'un tour pour le jeu de recherche
     * met à jour l'attribut affichage
     * ?????????? je ne sais pas si je dois mettre cette fonction dans l affichage ou pas? parcequ il affiche des choses mais egalement calcule le resultat d'un tour !???????
     */
    public void calculResultatRecherche() {
        for (int i = 0; i < this.nbCase; i++) {
            if (this.proposition[i] == this.solution[i]) this.affichage[i] = "=";
            else if (this.proposition[i] < this.solution[i]) this.affichage[i] = "+";
            else this.affichage[i] = "-";
        }
    }

    /**
     * la partie est gagnante
     */
    public boolean isPartieGagnante() {
        int egalite = 0;
        for (int i = 0; i < this.nbCase; i++) {
            if (this.proposition[i] == this.solution[i]) {
                egalite += 1;
            }
        }
        if (egalite == this.nbCase) {
            return true;
        }
        return false;
    }


}