package cartes;

public abstract class Carte {
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte) {
			return this.getClass().equals(obj.getClass());
		}
		return false;
	}
}
