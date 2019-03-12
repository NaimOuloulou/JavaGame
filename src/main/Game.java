package main;
//import org.newdawn.slick.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;


//import org.newdawn.
/**
 * 
 */

/**
 * @author bouab
 *
 */
public class Game extends BasicGame {
	
	private GameContainer container;
	private Map map  = new Map();
	private Hero player = new Hero(map,"Hohenheim",3);

	public Game() {
        super("Game");
    }
	
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new Game(),576, 576, false).start();
    }
	
	/* (non-Javadoc)
	 * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		this.map.renderBackground();
		this.player.render(arg1);
		this.map.renderForeground();
		
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 */
	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		this.container = arg0;
		this.map.init(); 
		this.player.init();
	    Music background = new Music("sound/Harry Potter Theme Song - YouTube.ogg");
	    background.loop();
	}

	/* (non-Javadoc)
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		// TODO Auto-generated method stub
			updateTrigger();
			this.player.update(delta);
			
		}
		
		private void updateTrigger() throws SlickException {
			this.player.setOnStair(false);
			for (int objectID = 0; objectID < this.map.getObjectCount(); objectID++) {
				if (isInTrigger(objectID)) {
					if ("teleport".equals(this.map.getObjectType(objectID))) {
												//this.map.render(0, 0, 0);
						teleport(objectID);
						this.map.changeMap("map/macartee3.tmx");

						
					} else if ("stair".equals(this.map.getObjectType(objectID))) {
						this.player.setOnStair(true);
					}
				}
			}
		}
				
		private boolean isInTrigger(int id) {
			return this.player.getX() > this.map.getObjectX(id)
					&& this.player.getX() < this.map.getObjectX(id) + this.map.getObjectWidth(id)
					&& this.player.getY() > this.map.getObjectY(id)
					&& this.player.getY() < this.map.getObjectY(id) + this.map.getObjectHeight(id);		
		}

		private void teleport(int objectID) {
			this.player.setX(Float.parseFloat(this.map.getObjectProperty(objectID, "dest-x",
					Float.toString(player.getX()))));
			this.player.setY(Float.parseFloat(this.map.getObjectProperty(objectID, "dest-y",
					Float.toString(player.getY()))));
		}

		@Override
	    public void keyReleased(int key, char c) {
		 	this.player.setMoving(false);
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	    }
	 
		@Override
		public void keyPressed(int key, char c) {
			switch (key) {
	         	case Input.KEY_UP:    this.player.setDirection(0); this.player.setMoving(true);break;
	         	case Input.KEY_LEFT:  this.player.setDirection(1); this.player.setMoving(true);break;
	         	case Input.KEY_DOWN:  this.player.setDirection(2); this.player.setMoving(true);break;
	         	case Input.KEY_RIGHT: this.player.setDirection(3); this.player.setMoving(true);break;
	     }
	 }

}
