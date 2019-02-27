package azadeh.ocs;

/**
 * Cette interface permet dinitialiser un jeu.
 * Elle n'est pas complet.
 * Je voulais utiliser le designe pattern factory pour initialiser un jeu.
 */
public interface IJeu {

    public void initialiser(int mode, int type);
    public void lancerPartie();
}
