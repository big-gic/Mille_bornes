package testsfonctionnels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Limite;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	
	
	public static void main(String[] args) {
		List<Limite> pileLimite = new ArrayList<>();
		List<Bataille> pileBataille = new ArrayList<>();
		Collection<Borne> collectionBornes = new ArrayList<>();
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu(pileLimite, pileBataille, collectionBornes);
		
	}
	
}
