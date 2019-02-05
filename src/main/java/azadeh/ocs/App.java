package azadeh.ocs;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        int solution[] = new int [4];
        int resultat [] = new int [4];
        String affichage[] = new String [4];

        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("A quel jeu voudriez vous jouer ? Saisissez 1 ou 2");
        System.out.println("1 - Recherche +/-");
        System.out.println("2 - Mastermind");
        int jeu = sc.nextInt();
        System.out.println("vous avez choisi " + jeu);
        */
        System.out.println("Recherche +/-");


        // génération d'un nombre >= 0 et < 10
        Random r = new Random();
        solution[0] = r.nextInt(10);
        solution[1] = r.nextInt(10);
        solution[2] = r.nextInt(10);
        solution[3] = r.nextInt(10);


        System.out.println("Tapper un chiffre de 0 à 9");
        resultat[0] = sc.nextInt();
        System.out.println("Tapper un chiffre de 0 à 9");
        resultat[1] = sc.nextInt();
        System.out.println("Tapper un chiffre de 0 à 9");
        resultat[2] = sc.nextInt();
        System.out.println("Tapper un chiffre de 0 à 9");
        resultat[3] = sc.nextInt();


        if (resultat[0]==solution[0]) affichage[0] = "=";
        else if (resultat[0]<solution[0]) affichage[0] = "-";
        else affichage[0] = "+";

        if (resultat[1]==solution[1]) affichage[1] = "=";
        else if (resultat[1]<solution[1]) affichage[1] = "-";
        else affichage[1] = "+";

        if (resultat[2]==solution[2]) affichage[2] = "=";
        else if (resultat[2]<solution[2]) affichage[2] = "-";
        else affichage[2] = "+";

        if (resultat[3]==solution[3]) affichage[3] = "=";
        else if (resultat[3]<solution[3]) affichage[3] = "-";
        else affichage[3] = "+";

        System.out.println("(Combinaison secrète : " + solution[0]+" "+solution[1]+" "+solution[2]+" "+solution[3]+")");
        System.out.println("");
        System.out.println("Proposition : " + resultat[0]+ "" + resultat[1]+ ""+ resultat[2]+ ""+ resultat[3]+ " -> Réponse : "+ affichage[0]+ "" + affichage[1]+ ""+ affichage[2]+ ""+ affichage[3]);







        //Mode développeur
       // boolean modeDeveloppeur = false;

        //Plateau plateau = new Plateau(1, 1, modeDeveloppeur);
        //Jeux :1. Recherche + / - 2. Mastermind


        //Modes :1. Mode challenger 2. Mode défenseur 3. duel



        //L'utilisateur joue. S'il perd, l'application affiche la solution.


        //À la fin de la partie, l'utilisateur peut choisir :
        // 1. de rejouer au même jeu
        // 2. de lancer un autre jeu (retour à l'écran de choix des jeux du début)
        // 3.de quitter l'application


    }
}
