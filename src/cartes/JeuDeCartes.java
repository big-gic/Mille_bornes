package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = {new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),new Configuration(new Borne(50), 10),
			new Configuration(new Parade(Type.FEU), 14),new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new FinLimite(), 6),new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5),new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1)};
	private int nbConfigurations = 0;
	
	
	
	public JeuDeCartes() {
		super();
		
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
	
	
	public boolean checkCount(Carte[] cartes) {
		//configuration vs cartes
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
