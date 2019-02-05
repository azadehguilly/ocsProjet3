package azadeh.ocs;

public class Plateau {

    private int jeuChoisi;
    private int modeChoisi;
    private boolean modeDeveloppeur;

    public Plateau(int jeuChoisi, int modeChoisi, boolean modeDeveloppeur) {
        this.jeuChoisi = jeuChoisi;
        this.modeChoisi = modeChoisi;
        this.modeDeveloppeur = modeDeveloppeur;
    }

    public int getJeuChoisi() {
        return jeuChoisi;
    }

    public void setJeuChoisi(int jeuChoisi) {
        this.jeuChoisi = jeuChoisi;
    }

    public int getModeChoisi() {
        return modeChoisi;
    }

    public void setModeChoisi(int modeChoisi) {
        this.modeChoisi = modeChoisi;
    }

    public boolean isModeDeveloppeur() {
        return modeDeveloppeur;
    }

    public void setModeDeveloppeur(boolean modeDeveloppeur) {
        this.modeDeveloppeur = modeDeveloppeur;
    }

    /**
     * Renvoie le jeu choisi
     *
     * @param jeu 1 Recherche +/- , 2 Mastermind
     * @return jeu choisi
     */
    public int jeuChoisi(String jeu) {

        switch (jeu) {
            case "recherche":
                jeuChoisi = 1;
                break;
            case "mastermind":
                jeuChoisi = 2;
                break;
            default:
                jeuChoisi = 0;
                break;
        }
        return jeuChoisi;
    }

    /**
     * Renvoie le mode choisi pour le jeu
     *
     * @param mode le mode de jeu choisi, 1 challenger, 2 defenseur ou 3 duel
     * @return le mode choisi
     */
    public int modeChoisi(String mode) {

        switch (mode) {
            case "challenger":
                modeChoisi = 1;
                break;
            case "defenseur":
                modeChoisi = 2;
                break;
            case "duel":
                modeChoisi = 3;
                break;
            default:
                modeChoisi = 0;
                break;
        }
        return modeChoisi;
    }


}
