package cartes;

public class Attaque extends Bataille {

	protected Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return "Attaque de type "+getType().getAttaque();
	}



}
