package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
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
	private Set<Botte> bottes = new HashSet<>();
	
	public ZoneDeJeu() {
		super();
	}
	
	public int donnerLimitationVitesse() {
		if (!estPrioritaire() && !pileLimite.isEmpty() && (pileLimite.get(pileLimite.size()-1) instanceof DebutLimite)) {
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
	
	public void deposer(Carte carte) {
		if (carte instanceof Borne) {
			collectionBornes.add((Borne)carte);
		}
		else if (carte instanceof Limite) {
			pileLimite.add((Limite)carte);
		}
		else if (carte instanceof Bataille) {
			pileBataille.add((Bataille)carte);
		}
		else {
			bottes.add((Botte)carte);
		}
	}
	
	public boolean peutAvancer() {
		if (pileBataille.isEmpty() && estPrioritaire()) {
			return true;
		}
		if (!pileBataille.isEmpty()) {
			Bataille sommet = pileBataille.get(pileBataille.size()-1);
			if (sommet.equals(new Parade(Type.FEU))) {
				return true;
			}
			if (sommet instanceof Parade && estPrioritaire()) {
				return true;
			}
			if (sommet.equals(new Attaque(Type.FEU)) && estPrioritaire()) {
				return true;
			}
			if (sommet instanceof Attaque && bottes.contains(new Botte(sommet.getType())) && estPrioritaire()){
				return true;
			}
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
		if (!estPrioritaire()) {
			if (pileBataille.isEmpty()) {
				return true;
			}else {
				Bataille sommet = pileBataille.get(pileBataille.size()-1);
				if (sommet.equals(new Attaque(Type.FEU))) {
					return true;
				}
				if (sommet instanceof Parade && !pileBataille.get(pileBataille.size()-1).getType().equals(Type.FEU)) {
					return true;
				}
				if (sommet instanceof Attaque && bottes.contains(new Botte(sommet.getType()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm()<=donnerLimitationVitesse() && donnerKmParcourus()<=1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (!estPrioritaire()) {
			if (limite instanceof DebutLimite) {
				return pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1) instanceof FinLimite;
			}
			return !pileLimite.isEmpty() && pileLimite.get(pileLimite.size()-1) instanceof DebutLimite;
		}
		return false;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (!bottes.contains(new Botte(bataille.getType()))) {
			if (bataille instanceof Attaque) {
				return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size()-1) instanceof Parade;
			}
			if (bataille.getType().equals(Type.FEU)) {
				return estDepotFeuVertAutorise();
			}
			return !pileBataille.isEmpty() && bataille.getType().equals(pileBataille.get(pileBataille.size()-1).getType())
					&& pileBataille.get(pileBataille.size()-1) instanceof Attaque;
		}
		return false;
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
		return true;
	}
		
	public boolean estPrioritaire() {
		return bottes.contains(new Botte(Type.FEU));
	}

	public List<Limite> getPileLimite() {
		return pileLimite;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public Collection<Borne> getCollectionBornes() {
		return collectionBornes;
	}

	public Set<Botte> getBottes() {
		return bottes;
	}
	
	
	
}






