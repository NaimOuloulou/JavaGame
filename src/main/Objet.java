package main;

public abstract class Objet {
	
	protected String typeObjet;
	private boolean estRamasse = false;
	
	public Objet(){
	}

	public void estRamasse(){
		estRamasse = true;
	}
	
	public String getTypeObjet() {
		return typeObjet;
	}

}
