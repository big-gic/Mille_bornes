package cartes;
import cartes.Type;

public abstract class Probleme extends Carte {

	private Type type;
	
	
	
	protected Probleme(Type type) {
		super();
		this.type = type;
	}



	public Type getType() {
		return type;
	}
}
