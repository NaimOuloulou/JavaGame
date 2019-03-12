/**
 * 
 */
package main;

/**
 * @author bouab
 *
 */
public class Hero extends Personnage{
	private int niveauVie;
	
	public Hero(Map map, String name,int niveauVie) {
		super(map, name);
		this.setNiveauVie(niveauVie);
		// TODO Auto-generated constructor stub
	}

	public int getNiveauVie() {
		return niveauVie;
	}

	public void setNiveauVie(int niveauVie) {
		this.niveauVie = niveauVie;
	}

}
