package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	private Set<Joueur> joueurs = new LinkedHashSet<>();
	
	public Jeu() {
		Carte[] cartes = new JeuDeCartes().donnerCartes();
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, cartes);
		GestionCartes.melanger(listeCartes);
		cartes = listeCartes.toArray(new Carte[0]);
		sabot = new Sabot(cartes);
	}
	
	public Sabot getSabot() {
		return sabot;
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public NavigableSet<Joueur> classement(Joueur... joueurs){
		return new TreeSet<>(
				new Comparator<Joueur>() {
					@Override
					public int compare(Joueur j1, Joueur j2) {
							return j2.donnerKmParcourus() -  j1.donnerKmParcourus();
			        }
				});
	}
	
	public void inscrire(Joueur...joueursAInscrire) {
		joueurs.addAll(Arrays.asList(joueursAInscrire));
	}
	
	public void distribuerCartes() {
		for (int i = 0; i<6; i++) {
			for (Joueur joueur : joueurs) {
				joueur.prendreCarte(sabot);
			}
		}
	}
	
	public String jouerTour(Joueur joueur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le joueur "+joueur.toString()+" a pioche "+joueur.prendreCarte(sabot).toString());
		chaine.append("Il a dans sa main : "+joueur.getMain().toString());
		Set<Joueur> adversaires = new HashSet<>();
		adversaires.addAll(joueurs);
		adversaires.remove(joueur);
		Coup coup = joueur.choisirCoup(adversaires);
		joueur.retirerDeLaMain(coup.getCarte());
		if (coup.getJoueurCible() == null) {
			sabot.ajouterCarte(coup.getCarte());
		}else {
			coup.getJoueurCible().deposer(coup.getCarte());
		}
		chaine.append("Le joueur "+joueur.toString()+" "+coup.toString());
		return chaine.toString();
	}
	
}












