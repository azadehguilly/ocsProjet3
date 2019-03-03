# OpenClassrooms, Développeur d'application - Java, 
# Présentation de projet 3: Jeux Recherche +/- et Mastermind

Cette application permet de jouer aux deux jeux de sociétés avec 3 modes chacun.

Deux jeux 
1. Recherche + / -
2. Mastermind

Trois modes : 
1. Mode challenger : trouver la combinaison secrète de l'ordinateur ( defenseur = ordinateur, attaquant = humain)
2. Mode défenseur où c'est à l'ordinateur de trouver la combinaison secrète (defenseur = humain, attaquant = ordinateur)
3. Mode duel où l'ordinateur et l'humain jouent tour à tour, le premier à trouver la combinaison secrète de l'autre a gagné

### Prerequis

Mode développement : 
maven et java 8.

Sinon que java 8

### Compilation

Lancer la ligne de commande : 
    
    mvn clean compile package

Le fichier jar sera dans le repertoire target

### Lancement du programme

Les valeurs dans le fichier properties sont les suivant: 

nombre dechiffres ou symboles pour les deux jeux est 4
nombres d'essai avant de perdre est 6
symboles pour le jeu de Recherche +/- est 0,1,2,3,4,5,6,7,8,9
symboles pour le jeu de Mastermind est 0,1,2

Vous pouvez les modifier mais il faut recompiler l'application.

Placer vous dans le repertoir target et lancez le jeu avec la ligne de commande suivante:

    java  -DmodeDeveloppeur=false -jar  mastermind-1.0-SNAPSHOT-jar-with-dependencies.jar 

ou pour lancer le jeux en mode developpeur pour avoir le résultat dès le début:

    java  -DmodeDeveloppeur=true -jar  mastermind-1.0-SNAPSHOT-jar-with-dependencies.jar 



## Fonctionnement du jeu

1. Au démarrage, l'utilisateur doit choisir le jeu auquel il veut jouer parmi les choix proposés.
2. L'utilisateur sélectionne le jeu et le mode de son choix. L'application lance le jeu sélectionné.
3. L'utilisateur joue.
4. À la fin de la partie, l'utilisateur peut choisir :
	1. de rejouer à un des jeux en mode choisi
	2. de quitter l'application

Pour plus de détail sur le jeu Mastermind vous pouvez consultez le site : https://fr.wikipedia.org/wiki/Mastermind