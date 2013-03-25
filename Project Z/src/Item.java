// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all items within the game, such as weapons and armor or etc
// Keeps track of item name, its worth, the image of the item and its current state;

import org.newdawn.slick.Image;

public class Item {
	
	private String itemName;
	private int itemWorth;
	private Image itemImage;
	private String state;
	
	
	public Item(String itemName, int itemWorth, Image itemImage)	{
		this(itemName, itemWorth, itemImage, "NiceItem!");
	}
	
	public Item(String itemName, int itemWorth, Image itemImage, String state)	{
		this.itemName = itemName;
		this.itemWorth = itemWorth;
		this.itemImage = itemImage;
		this.state = state;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getItemWorth() {
		return itemWorth;
	}
	
	public void setItemWorth(int itemWorth) {
		this.itemWorth = itemWorth;
	}
	
	public Image getItemImage() {
		return itemImage;
	}
	
	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	
}
