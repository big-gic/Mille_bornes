package jeu;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.Limite;

public class ZoneDeJeu {

	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collectionBornes;
	
	public ZoneDeJeu(List<Limite> pileLimite, List<Bataille> pileBataille, Collection<Borne> collectionBornes) {
		super();
		this.pileLimite = pileLimite;
		this.pileBataille = pileBataille;
		this.collectionBornes = collectionBornes;
	}
	
	public int donnerLimitationVitesse() {
		ListIterator<Limite> it = pileLimite.listIterator();
		if (it.previous() instanceof DebutLimite) {
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
		if (carte instanceof Limite) {
			pileLimite.add((Limite)carte);
		}
		if (carte instanceof Bataille) {
			pileBataille.add((Bataille)carte);
		}
		if (carte instanceof Borne) {
			collectionBornes.add((Borne)carte);
		}
	}
	
}
