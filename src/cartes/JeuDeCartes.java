package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes;
	private int nbConfigurations = 0;
	
	
	
	public JeuDeCartes() {
		super();
		typesDeCartes = new Configuration[21];
	}

	public String affichageJeuDeCartes() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < nbConfigurations; i++) {
			chaine.append(typesDeCartes[i].getNbExemplaires()+" "
					+typesDeCartes[i].getCartes().toString()+"\n");
		}
		return chaine.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[110];
		int index = 0;
		for (int i = 0; i < nbConfigurations; i++) {
			for (int y = 0; y < typesDeCartes[i].getNbExemplaires(); y++) {
				cartes[index] = typesDeCartes[i].getCartes();
				index++;
			}
		}
		return cartes;
	}
	
	
	public void ajouterConfiguration(Carte carte, int nbExemplaires) {
		if (nbConfigurations >= 21) {
			throw new IllegalStateException("Le jeu est déjà plein !");
		}
	    typesDeCartes[nbConfigurations] = new Configuration(carte, nbExemplaires);
	    nbConfigurations++;
	}


	private class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			super();
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		
		public Carte getCartes() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		
	}
}
