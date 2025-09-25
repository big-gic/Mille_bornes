package cartes;

public class Parade extends Bataille {

	protected Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Parade de type"+getType().getParade();
	}


	

}
