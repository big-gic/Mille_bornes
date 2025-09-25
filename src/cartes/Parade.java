package cartes;

public class Parade extends Bataille {

	protected Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return "Parade de type"+getType().getParade();
	}


	

}
