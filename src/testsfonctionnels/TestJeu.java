package testsfonctionnels;

import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Joueur j1 = new Joueur("Jack");
		Joueur j2 = new Joueur("Bill");
		Joueur j3 = new Joueur("Luffy");
		
		jeu.inscrire(j1,j2,j3);
		jeu.distribuerCartes();
		for (Joueur joueur : jeu.getJoueurs()) {
			System.out.println("Le joueur "+joueur.toString()+" a dans sa main : "+joueur.getMain().toString());
		}
		
		jeu.jouerTour(j1);
		jeu.jouerTour(j2);
		jeu.jouerTour(j3);
		System.out.println("ok?");
	}
	
	
}
