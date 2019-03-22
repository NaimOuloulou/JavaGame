/**
 * 
 */
package main;

import org.newdawn.slick.SlickException;

/**
 * @author bouab
 *
 */
public class TriggerController {
	
	private Map map;
	private Personnage player;

	public TriggerController(Map map, Personnage player) {
		this.map = map;
		this.player = player;
	}
	  
	public void updateTrigger() throws SlickException {
		this.player.setOnStair(false);			    
	    for (int objectID = 0; objectID < this.map.getObjectCount(); objectID++) {
	        if (isInTrigger(objectID)) {
	            String type = this.map.getObjectType(objectID);
	            if ("teleport".equals(type)) {
	                teleport(objectID);
	            } else if ("stair".equals(type)) {
	            	this.player.setOnStair(true);
	            } else if ("change-map".equals(type)) {
	            	teleport(objectID);
	                this.map.changeMap(this.map.getObjectProperty(objectID, "dest-map", "undefined"));
	                
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
}
