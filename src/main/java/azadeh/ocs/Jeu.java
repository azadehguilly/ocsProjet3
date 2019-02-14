package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultatRecherche;

import static azadeh.ocs.App.nbEssais;

public class Jeu implements IJeu{

    ICodeur codeur = null;
    IDecodeur decodeur = null;

    public Jeu() {
    }


    @Override
    public void initialiser(int mode, int type) {
        codeur = new CodeurOrdinateur();
        decodeur = new DecodeurOrdinateur();
    }

    @Override
    public void lancerPartie() {
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();
        Resultat resultat = null;
        Proposition proposition = null;
        Proposition solution = codeur.genereLaSolutionGagnante();
        int i=0;
        boolean solutionTrouvee = false;
        do {
            // Le decodeur fait une proposition
            proposition = decodeur.proposerUneCombinaison(resultat);

            System.out.println("Proposition: " + proposition.toString());

            // La proposition est testée par le codeur qui retourne un résultat
            resultat = codeur.evaluerUneProposition(proposition);

            System.out.println("Résultat: " + resultat.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee = codeur.equals(resultat);

            i++;
        } while (!solutionTrouvee && i < nbEssais);

        afficheResultatRecherche.AfficheResultatJeu(solutionTrouvee);

    }
}
