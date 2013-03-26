// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all 'monster' or 'player' objects in the game
// Keeps track of X and Y positions, as well as total hit points and state

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;

public class Entity {

	private int entityX;
	private int entityY;
	private int totalHitPoints;
	private String state;
	private String entityName;
	private int entityLevel;
	private Image entityImageLeft;
	private Image entityImageRight;
	private Image entityCurrentImage;
	private Polygon entityPoly;
	
	
	public Entity(int entityX, int entityY,  int totalHitPoints, String entityName, int entityLevel, Image entityImageLeft, Polygon entityPoly)	{
		this(entityX, entityY, totalHitPoints, "alive" , entityName, entityLevel, entityImageLeft, entityPoly);
	}
	
	
	
	public Entity(int entityX, int entityY, int totalHitPoints, String state, String entityName, int entityLevel, Image entityImageLeft, Polygon entityPoly)	{
		this.entityX = entityX;
		this.entityY = entityY;
		this.totalHitPoints = totalHitPoints;
		this.state = state;
		this.entityName = entityName;
		this.entityLevel = entityLevel;
		this.entityImageLeft = entityImageLeft;
		this.entityImageRight = entityImageLeft.getFlippedCopy(true, false);
		this.entityCurrentImage = entityImageLeft;
		this.entityPoly = entityPoly;
	}
	


	public int getEntityX() {
		return entityX;
	}



	public void setEntityX(int entityX) {
		this.entityX = entityX;
		entityPoly.setX(entityX);
	}



	public int getEntityY() {
		return entityY;
	}



	public void setEntityY(int entityY) {
		this.entityY = entityY;
		entityPoly.setY(entityY);
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



	public Image getEntityCurrentImage() {
		return entityCurrentImage;
	}



	public void setEntityCurrentImage(Image entityCurrentImage) {
		this.entityCurrentImage = entityCurrentImage;
	}



	public Polygon getEntityPoly() {
		return entityPoly;
	}



	public void setEntityPoly(Polygon entityPoly) {
		this.entityPoly = entityPoly;
	}
}
