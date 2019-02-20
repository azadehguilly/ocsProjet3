package azadeh.ocs;

public interface ICodeur {

    public void genereLaSolutionGagnante();

    public Resultat evaluerUneProposition(Proposition prop);

    public boolean isPartieGagnante(Resultat resultat);

    public Proposition getSolutionGagnante();
}
