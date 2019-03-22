/**
 * 
 */
package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author bouab
 *
 */

public class StateGame extends StateBasedGame {

	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new StateGame(), 576, 750, false).start();
	}

	public StateGame() {
		super("Lesson 15 :: StateGame");
	}

	/**
	 * Ici il suffit d'ajouter nos deux boucles de jeux. La premi�re ajout�e sera celle qui sera
	 * utilis�e au d�but
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new MainScreenGameState());
		addState(new MapGameState());
	}

}