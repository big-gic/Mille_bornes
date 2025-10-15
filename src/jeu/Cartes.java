package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public interface Cartes {
	
	final Carte PRIORITAIRE = new Botte(Type.FEU);
	final Carte FEU_ROUGE = new Attaque(Type.FEU);
	final Carte FEU_VERT = new Parade(Type.FEU);
}
