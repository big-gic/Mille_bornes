package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes;

	public String affichageJeuDeCartes() {
		String chaine;
		
	}
	
	private class Configuration {
		private int nbExemplaires;

		private Configuration(Carte carte, int nbExemplaires) {
			super();
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCartes() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		
		
	}
}
