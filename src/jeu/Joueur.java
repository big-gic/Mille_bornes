package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cartes.Bataille;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.Limite;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public MainJoueur getMain() {
		return main;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			return nom.equals(((Joueur)obj).nom);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31*(nom.hashCode());
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
		return carte;
	}

	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte carte) {
		zoneDeJeu.deposer(carte);
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants){
		Set<Coup> coupsValides = new HashSet<>();
		for (Joueur participant : participants) {
			for (Carte carte : main.getMain()) {
				Coup coup = new Coup(this, carte, participant);
				if (coup.estValide()) {
					coupsValides.add(coup);
				}
			}
		}
		return coupsValides;
	}
	
	public Set<Coup> coupsDefausse(){
		Set<Coup> coups = new HashSet<>();
		for (Carte carte : main.getMain()) {
			coups.add(new Coup(this, carte, null));
		}
		return coups;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.getMain().remove(carte);
	}
	
	private Coup tirageCoupAleatoire(Set<Coup> coups) {
	    int index = new Random().nextInt(coups.size());
	    return new ArrayList<>(coups).get(index);
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> coups = coupsPossibles(participants);
		if (!coups.isEmpty()) {
			return tirageCoupAleatoire(coups);
		}
		else {
			return tirageCoupAleatoire(coupsDefausse());
		}
	}
	
	public String afficherEtatJoueur() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Bottes :");
		Set<Botte> bottes = zoneDeJeu.getBottes();
		for (Botte botte : bottes) {
			chaine.append("\n"+ botte.toString());
		}
		List<Limite> pileLimite = zoneDeJeu.getPileLimite();
		chaine.append(Boolean.toString(pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1) instanceof DebutLimite)+" ");
		List<Bataille> pileBataille = zoneDeJeu.getPileBataille();
		if (pileBataille.isEmpty()) {
			chaine.append(" null");
		}else {
			chaine.append(pileBataille.get(pileBataille.size()-1).toString()+" ");
		}
		chaine.append(main.toString());
		return chaine.toString();
	}
	
}

















