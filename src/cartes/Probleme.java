package cartes;

public abstract class Probleme extends Carte {

	private Type type;
	
	
	
	protected Probleme(Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme) {
			return this.getClass().equals(obj.getClass()) && this.getType().equals(((Probleme) obj).getType());
		}
		return false;
	}


	public Type getType() {
		return type;
	}
}
