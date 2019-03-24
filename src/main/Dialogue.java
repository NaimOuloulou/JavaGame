package main;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Dialogue extends BasicGameState{
 
	public Dialogue(int state){}
	public int getID() {return 1;}
 
	private UnicodeFont fontTest;
	private TextField nomPerso;
	private Color colorNomPerso;
 
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		fontTest = new UnicodeFont(new java.awt.Font("DejaVu Serif", java.awt.Font.PLAIN, 20));
		fontTest.addAsciiGlyphs();
		fontTest.addGlyphs(400,600);
		fontTest.getEffects().add(new ColorEffect(java.awt.Color.black));
		fontTest.loadGlyphs();
		nomPerso = new TextField(gc, fontTest, 100, 30, 300, 40);
		nomPerso.setBackgroundColor(colorNomPerso.white);

 
	}
 
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
 
		nomPerso.setFocus(true);
		
	}
 
 
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		nomPerso.render(gc, g);
	}
 
}
	
