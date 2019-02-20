package azadeh.ocs;

import azadeh.ocs.affichage.AfficheResultatRecherche;

import static azadeh.ocs.App.nbEssais;

public class Jeu implements IJeu {

    ICodeur codeur = null;
    IDecodeur decodeur = null;

    public Jeu() {
    }


    @Override
    public void initialiser(int mode, int type) {
        codeur = new CodeurHumain();
        //decodeur = new DecodeurHumain();
        //codeur = new CodeurOrdinateur();
        decodeur = new DecodeurOrdinateur();
    }

    @Override
    public void lancerPartie() {
        AfficheResultatRecherche afficheResultatRecherche = new AfficheResultatRecherche();
        Resultat resultat = null;
        Proposition proposition = null;
        codeur.genereLaSolutionGagnante();
        System.out.println("Solution gagnate: " + codeur.getSolutionGagnante().toString());
        int i = 0;
        boolean solutionTrouvee = false;
        do {
            // Le decodeur fait une proposition
            proposition = decodeur.proposerUneCombinaison(resultat);
            decodeur.setDerniereProposition(proposition);
            System.out.println("Proposition: " + proposition.toString());

            // La proposition est testée par le codeur qui retourne un résultat
            resultat = codeur.evaluerUneProposition(proposition);
            System.out.println("Résultat: " + resultat.toString());

            //Tester si la combinaison a été trouvée
            solutionTrouvee = codeur.isPartieGagnante(resultat);
            System.out.println("sol trouvé : " + solutionTrouvee);

            i++;
        } while (!solutionTrouvee && i < nbEssais);

        afficheResultatRecherche.AfficheResultatJeu(solutionTrouvee);

    }
}
