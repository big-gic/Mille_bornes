package cartes;

public class Borne extends Carte {
	
	private int km;

	public int getKm() {
		return km;
	}

	public Borne(int km) {
		super();
		this.km = km;
	}

	@Override
	public String toString() {
		return km+"KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			return km == ((Borne) obj).getKm();
		}
		return false;
	}

	

}
