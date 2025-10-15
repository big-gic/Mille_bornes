package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	
	public Jeu() {
		Carte[] cartes = new JeuDeCartes().donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, cartes);
		GestionCartes.melanger(listeCartes);
		cartes = listeCartes.toArray(new Carte[0]);
		sabot = new Sabot(cartes);
	}
}
