package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] cartes;
	private int nbCartes;

	private int nbOperations = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		nbCartes = cartes.length;
	}
	
	public Carte[] getCartes() {
		return cartes;
	}

	public int getNbCartes() {
		return nbCartes;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new ArrayIndexOutOfBoundsException("La pioche est pleine");
		}
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOperations++;
	}
	
	public Carte piocher() {
		Iterator<Carte> iterateur = iterator();
		try {
			Carte carte = iterateur.next();
			iterateur.remove();
			return carte;
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;
		
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur-1; i<nbCartes-1; i++) {
				cartes[i]=cartes[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations++;
			nbOperationsReference++;
		}
		
		private void verificationConcurrence() {
			if (nbOperations != nbOperationsReference)
				throw new ConcurrentModificationException();
		}
	}
	
}
