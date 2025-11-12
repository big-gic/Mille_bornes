package testsfonctionnels;

import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
	Jeu jeu = new Jeu();
	Joueur j1 = new Joueur("Jack");
	Joueur j2 = new Joueur("Bill");
	Joueur j3 = new Joueur("Luffy");
	jeu.inscrire(j1,j2,j3);
	jeu.distribuerCartes();
	for (Joueur joueur : jeu.getJoueurs()) {
		System.out.println(joueur.getMain().toString());
	}
		
	
}
