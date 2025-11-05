package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {

	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private Collection<Borne> collectionBornes = new ArrayList<>();
	
	public ZoneDeJeu() {
		super();
	}
	
	public int donnerLimitationVitesse() {
		if (!pileLimite.isEmpty() && (pileLimite.get(pileLimite.size()-1) instanceof DebutLimite)) {
				return 50;
		}
		return 200;
	}
	
	public int donnerKmParcourus() {
		int countKm = 0;
		for (Borne borne : collectionBornes) {
			countKm += borne.getKm();
		}
		return countKm;
	}
	
	public void deposer (Carte carte) {
		if (carte instanceof Borne) {
			collectionBornes.add((Borne)carte);
		}
		if (carte instanceof Limite) {
			pileLimite.add((Limite)carte);
		}
		if (carte instanceof Bataille) {
			pileBataille.add((Bataille)carte);
		}
	}
	
	public boolean peutAvancer() {
		return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size()-1).equals(new Parade(Type.FEU));
	}
	
	private boolean estDepotFeuVertAutorise() {
		return pileBataille.isEmpty() || pileBataille.get(pileBataille.size()-1).equals(new Attaque(Type.FEU))
				|| (pileBataille.get(pileBataille.size()-1) instanceof Parade
						&& !pileBataille.get(pileBataille.size()-1).getType().equals(Type.FEU));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm()<=donnerLimitationVitesse() && donnerKmParcourus()<=1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1) instanceof FinLimite;
		}
		return !pileLimite.isEmpty() && pileLimite.get(pileLimite.size()-1) instanceof DebutLimite;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size()-1) instanceof Parade;
		}
		if (bataille.getType().equals(Type.FEU)) {
			return estDepotFeuVertAutorise();
		}
		Bataille sommetPile = pileBataille.get(pileBataille.size()-1);
		return !pileBataille.isEmpty() && bataille.getType().equals(sommetPile.getType())
				&& sommetPile instanceof Attaque;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Bataille) {
			return estDepotBatailleAutorise((Bataille)carte);
		}
		if (carte instanceof Limite) {
			return estDepotLimiteAutorise((Limite)carte);
		}
		if (carte instanceof Borne) {
			return estDepotBorneAutorise((Borne)carte);
		}
		else {
			throw new UnsupportedOperationException("La classe Botte n'est pas gérée dans estDepotAutorise.");
	    }
	}
}
