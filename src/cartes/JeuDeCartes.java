package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes =
		{new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1)};
	
	
	
	public JeuDeCartes() {
		super();
		
	}

	public String affichageJeuDeCartes() {
		StringBuilder chaine = new StringBuilder();
		for (Configuration conf : typesDeCartes) {
			chaine.append(conf.getNbExemplaires()+" "
					+conf.getCarte().toString()+"\n");
		}
		return chaine.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[106];
		int index = 0;
		for (Configuration conf : typesDeCartes) {
			for (int y = 0; y < conf.getNbExemplaires(); y++) {
				cartes[index] = conf.getCarte();
				index++;
			}
		}
		return cartes;
	}
	
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for (Configuration conf : typesDeCartes) {
			int nbExemplaires = conf.getNbExemplaires();
			for (int i = 0; i < cartes.length; i++) {
				if (cartes[i] == conf.getCarte()) {
					nbExemplaires--;
					if (nbExemplaires < 0) {
						return false;
					}
				}
			}
			if (nbExemplaires > 0) {
				return false;
			}
		}
		return true;
	}


	private class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(Carte carte, int nbExemplaires) {
			super();
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		
		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		
	}
}
