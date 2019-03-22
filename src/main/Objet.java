package main;

public abstract class Objet {
	
	protected String typeObjet;
	private boolean estRamasse = false;
	
	private float x1,x2,y1,y2;
	
	public Objet(){
	}
	

	public void estRamasse(){
		estRamasse = true;
	}
	
	public String getTypeObjet() {
		return typeObjet;
	}

}
