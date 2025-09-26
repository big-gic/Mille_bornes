package testsfonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Type;

public class TestJeuDeCartes {	
	
	public static void affichageJeuDeCartes() {
		System.out.println("JEU :");
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		jeuDeCartes.ajouterConfiguration(new Borne(25), 10);
		jeuDeCartes.ajouterConfiguration(new Borne(50), 10);
		jeuDeCartes.ajouterConfiguration(new Borne(75), 10);
		jeuDeCartes.ajouterConfiguration(new Borne(100), 12);
		jeuDeCartes.ajouterConfiguration(new Borne(200), 4);
		jeuDeCartes.ajouterConfiguration(new Borne(50), 10);
		jeuDeCartes.ajouterConfiguration(new Parade(Type.FEU), 14);
		jeuDeCartes.ajouterConfiguration(new FinLimite(), 6);
		jeuDeCartes.ajouterConfiguration(new Parade(Type.ESSENCE), 6);
		jeuDeCartes.ajouterConfiguration(new Parade(Type.CREVAISON), 6);
		jeuDeCartes.ajouterConfiguration(new FinLimite(), 6);
		jeuDeCartes.ajouterConfiguration(new Parade(Type.ACCIDENT), 6);
		jeuDeCartes.ajouterConfiguration(new Attaque(Type.FEU), 5);
		jeuDeCartes.ajouterConfiguration(new DebutLimite(), 4);
		jeuDeCartes.ajouterConfiguration(new Attaque(Type.ESSENCE), 3);
		jeuDeCartes.ajouterConfiguration(new Attaque(Type.CREVAISON), 3);
		jeuDeCartes.ajouterConfiguration(new Attaque(Type.ACCIDENT), 3);
		jeuDeCartes.ajouterConfiguration(new Botte(Type.FEU), 1);
		jeuDeCartes.ajouterConfiguration(new Botte(Type.ESSENCE), 1);
		jeuDeCartes.ajouterConfiguration(new Botte(Type.CREVAISON), 1);
		jeuDeCartes.ajouterConfiguration(new Botte(Type.ACCIDENT), 1);
		System.out.println(jeuDeCartes.affichageJeuDeCartes());		
	}
	
	public static void main(String[] args) {
		affichageJeuDeCartes();
	}
}
