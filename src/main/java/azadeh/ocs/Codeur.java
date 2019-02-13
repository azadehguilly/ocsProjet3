package azadeh.ocs;

public interface Codeur {

    public Combinaison genereLaSolutionGagnante(Possibilite possibilite);

    public Possibilite evaluerUneProposition(Combinaison prop, Combinaison sol, Possibilite possib);

    public boolean isPartieGagnante(Combinaison prop, Combinaison sol);

}
