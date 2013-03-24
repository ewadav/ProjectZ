// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all 'monster' or 'player' objects in the game
// Keeps track of X and Y positions, as well as total hit points and state

import org.newdawn.slick.Image;

public class Entity {

	private int entityX;
	private int entityY;
	private int totalHitPoints;
	private String state;
	private String entityName;
	private int entityLevel;
	private Image entityImageLeft;
	private Image entityImageRight;
	
	
	public Entity(int entityX, int entityY,  int totalHitPoints, String entityName, int entityLevel, Image entityImageLeft)	{
		this(entityX, entityY, totalHitPoints, "alive" , entityName, entityLevel, entityImageLeft);
	}
	
	
	
	public Entity(int entityX, int entityY, int totalHitPoints, String state, String entityName, int entityLevel, Image entityImageLeft)	{
		this.entityX = entityX;
		this.entityY = entityY;
		this.totalHitPoints = totalHitPoints;
		this.state = state;
		this.setEntityName(entityName);
		this.setEntityLevel(entityLevel);
		this.setEntityImageLeft(entityImageLeft);
		this.setEntityImageRight(entityImageLeft.getFlippedCopy(true, false));
	}
	


	public int getEntityX() {
		return entityX;
	}



	public void setEntityX(int entityX) {
		this.entityX = entityX;
	}



	public int getEntityY() {
		return entityY;
	}



	public void setEntityY(int entityY) {
		this.entityY = entityY;
	}



	public int getTotalHitPoints() {
		return totalHitPoints;
	}



	public void setTotalHitPoints(int totalHitPoints) {
		this.totalHitPoints = totalHitPoints;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getEntityLevel() {
		return entityLevel;
	}



	public void setEntityLevel(int entityLevel) {
		this.entityLevel = entityLevel;
	}



	public String getEntityName() {
		return entityName;
	}



	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}



	public Image getEntityImageLeft() {
		return entityImageLeft;
	}



	public void setEntityImageLeft(Image entityImageLeft) {
		this.entityImageLeft = entityImageLeft;
	}



	public Image getEntityImageRight() {
		return entityImageRight;
	}



	public void setEntityImageRight(Image entityImageRight) {
		this.entityImageRight = entityImageRight;
	}
}
