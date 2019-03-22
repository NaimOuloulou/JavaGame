/**
 * 
 */
package main;

/**
 * @author bouab
 *
 */

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreenGameState extends BasicGameState {

	public static final int ID = 1;
	private Image background;
	private Image boiteDeDialogue ;
	private Image titre ;
	private StateBasedGame game;
	private int NumeroImage = 1 ;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		this.background = new Image("background/124168.png");
		this.titre = new Image("background/124171.png");
		this.boiteDeDialogue =new Image("background/124170.png");

	}

	/**
	 * Contenons nous d'afficher l'image de fond. .
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		System.out.println("Numero IMage = "+NumeroImage);
		background.draw(0, 0, container.getWidth(), container.getHeight());
		g.drawString("Appuyer sur une touche", 200, 200);
		titre.draw(80, 80,440, 90);
		switch(NumeroImage)
		{
			case 0 :
				game.enterState(MapGameState.ID);
				break ;
				
			case 1 :
				break ;
				
			case 2 :
				this.background = new Image("background/124169.jpg");
				//boiteDeDialogue.draw(0, 0, 200, 200);
				break ;
				
			default :
				break ;
		}
				
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
	}

	/**
	 * Passer à l'ecran de jeu à l'appui de n'importe quel touche.
	 */
	@Override
	public void keyReleased(int key, char c) {
		
		if(Input.KEY_ENTER == key)
		{
			if(NumeroImage ==1)
				NumeroImage++ ;
			
			else if(NumeroImage ==2)
				NumeroImage = 0 ;
		}
	}

	/**
	 * L'identifiant permet d'identifier les différentes boucles, pour passer de l'une à l'autre.
	 */
	@Override
	public int getID() {
		return ID;
	}
}
