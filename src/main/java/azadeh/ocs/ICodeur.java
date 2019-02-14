package azadeh.ocs;

public interface ICodeur {

    public Proposition genereLaSolutionGagnante();

    public Resultat evaluerUneProposition(Proposition prop);

    public boolean isPartieGagnante(Resultat resultat);

}
