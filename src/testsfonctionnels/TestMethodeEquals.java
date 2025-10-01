package testsfonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	
	public static void main(String[] args) {
		System.out.println("Deux cartes de 25km sont identiques ?"+new Borne(25).equals(new Borne(25)));
		System.out.println("Deux cartes de feux rouges sont identiques ?"+new Attaque(Type.FEU).equals(new Attaque(Type.FEU)));
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ?"+new Attaque(Type.FEU).equals(new Parade(Type.FEU)));
	}
		
}
