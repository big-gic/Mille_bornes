package jeu;

import java.util.Objects;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	
	private Joueur joueurCourant;
	private Carte carte;
	private Joueur joueurCible;
	
	public Coup(Joueur joueurCourant, Carte carte, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.carte = carte;
		this.joueurCible = joueurCible;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}
	
	public boolean estValide() {
		if (joueurCible.estDepotAutorise(carte)) {
			if (joueurCible.equals(joueurCourant)) {
				return !(carte instanceof Attaque) && !(carte instanceof DebutLimite);
			}
			else {
				return (carte instanceof Attaque) || (carte instanceof DebutLimite);
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (joueurCible != null) {
			return "depose la carte "+carte.toString()+" dans la zone de jeu de "+joueurCible.toString();
		}else {
			return "defausse la carte "+carte.toString();
		}
	}

	@Override
	public int hashCode() {
		int joueurCibleHashCode = 0;
		if (joueurCible != null) {
			joueurCibleHashCode = joueurCible.hashCode();
		}
		return 31*(carte.hashCode()+ joueurCibleHashCode + joueurCourant.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coup) {
			Coup other = (Coup) obj;
			return carte.equals(other.carte) &&
					(joueurCible == other.joueurCible || (joueurCible != null && joueurCible.equals(other.joueurCible)))
					&& joueurCourant.equals(other.joueurCourant);			
		}
		return false;
	}
	
	
	
	
}








