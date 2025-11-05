package jeu;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur {

	private List<Carte> main;

	public MainJoueur(List<Carte> main) {
		this.main = main;
	}
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert main.contains(carte);
		main.remove(carte);
	}

	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		for (Iterator<Carte> it = main.iterator(); it.hasNext();)
			chaine.append(it.next().toString());
		return chaine.toString();
	}
	
	
	
	
	
}
