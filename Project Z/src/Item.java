// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all items within the game, such as weapons and armor or etc
// Keeps track of item name, its worth, the image of the item and its current state;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;


public class Item extends Entity{
	
	private int itemWorth;
	private int totalItemsOnMap;
	//private ArrayList<Item> itemsOnMap;
	
	
	public Item (int entityX, int entityY, String state, String entityName, 
			Image entityCurrentImage, int itemWorth, Polygon poly) {

		super(entityX, entityY, state, entityName, entityCurrentImage, poly); // Sets all superclass fields
		
		this.itemWorth = itemWorth;
		
		//itemsOnMap = new ArrayList<Item>();
		//itemsOnMap.add(new Item (entityX, entityY, state, entityName, entityCurrentImage, itemWorth, poly));
		totalItemsOnMap = totalItemsOnMap + 1;
	}
	
	
	public int getItemWorth() {
		return itemWorth;
	}
	
	public void setItemWorth(int itemWorth) {
		this.itemWorth = itemWorth;
	}
	
	
	public int getTotalItemsOnMap() {
		return totalItemsOnMap;
	}
	
	public void setTotalItemsOnMap(int totalItemsOnMap) {
		this.totalItemsOnMap = totalItemsOnMap;
	}
	
}
