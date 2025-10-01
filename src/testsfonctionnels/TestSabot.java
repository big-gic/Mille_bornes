package testsfonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		Carte[] cartes1 = new Carte[] {new Borne(50), new Attaque(Type.FEU), new Borne(100), new Borne(200)};
		Sabot<Carte> sabot1 = new Sabot<>(cartes1);
		
		for (int i = 0; i<4; i++) {
			System.out.println("je pioche "+sabot1.piocher().toString());
		}
		
	}
}
