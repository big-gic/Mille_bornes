package cartes;

public enum Type {
	
	
	FEU("Prioritaire","Feu rouge","Feu vert"),
	ESSENCE("Citerne","Panne d'essence","Essence"),
	CREVAISON("Increvable","Crevaison","Roue "),
	ACCIDENT("As du volant","Accident","Réparation");

	private Type(String botte, String attaque, String parade) {
		this.botte = botte;
		this.attaque = attaque;
		this.parade = parade;
	}
	
	private String botte;
	private String attaque;
	private String parade;
	
	public String getBotte() {
		return botte;
	}
	public String getAttaque() {
		return attaque;
	}
	public String getParade() {
		return parade;
	}
	
	
	
}
