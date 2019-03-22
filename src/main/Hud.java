/**
 * 
 */
package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @author bouab
 *
 */
public class Hud {
	private Image playerbars;
	private Image inventaire ;
	private static final int P_BAR_X = 370;
	private static final int P_BAR_Y = 5;
	private static final int BAR_X = 84 + P_BAR_X;
	private static final int LIFE_BAR_Y = 4 + P_BAR_Y;
	private static final int BAR_WIDTH = 80;
	private static final int BAR_HEIGHT = 16;
	
	private static final Color LIFE_COLOR = new Color(255, 0, 0);
	
	public void init() throws SlickException {
		this.playerbars = new Image("hud/player-bar.png");
		this.inventaire = new Image("background/124173.jpg");
	}

	public void render(Graphics g) {
	  g.resetTransform();
	  g.setColor(LIFE_COLOR);
	  g.fillRect(BAR_X, LIFE_BAR_Y, .9f * BAR_WIDTH, BAR_HEIGHT);
	  g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
	  g.drawImage(this.inventaire, 0, 576, 576,750,1272 ,290, 1803,616) ;
	}
}
