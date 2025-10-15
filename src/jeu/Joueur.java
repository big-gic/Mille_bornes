package jeu;

import cartes.Borne;
import cartes.Carte;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			return nom.equals(((Joueur)obj).nom);
		}
		return false;
	}

	@Override
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher();
		if (carte != null) {
			main.prendre(carte);
		}
		return null;
	}

	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	
}
