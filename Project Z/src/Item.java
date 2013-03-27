// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all items within the game, such as weapons and armor or etc
// Keeps track of item name, its worth, the image of the item and its current state;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;


public class Item extends Entity{
	private int itemWorth;

	
	
	public Item (int entityX, int entityY, String state, String entityName, 
			Image entityCurrentImage, int itemWorth, Polygon poly) {

		super(entityX, entityY, state, entityName, entityCurrentImage, poly); // Sets all superclass fields
		
		this.itemWorth = itemWorth;
	}
	
	
	public int getItemWorth() {
		return itemWorth;
	}
	
	public void setItemWorth(int itemWorth) {
		this.itemWorth = itemWorth;
	}
	
}
