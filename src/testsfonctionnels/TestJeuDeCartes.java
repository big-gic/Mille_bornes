package testsfonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {	
	
	public static void affichageJeuDeCartes() {
		System.out.println("JEU :");
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		System.out.println(jeuDeCartes.affichageJeuDeCartes());		
	}
	
	public static void main(String[] args) {
		affichageJeuDeCartes();
	}
}
