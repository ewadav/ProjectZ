// David Ewald & Brandon Roth 'Project Z' 2013
// The root superclass for all 'monster' or 'player' objects in the game
// Keeps track of X and Y positions, as well as total hit points and state

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Entity {

	private int entityX; private int entityY;
	private int totalHitPoints;
	private String state;
	private String entityName;
	private int entityLevel;
	private Image entityImageLeft; private Image entityImageRight; private Image entityCurrentImage;
	private Polygon entityPoly;
	private Animation entityAniLeft; private Animation entityAniRight;
	
	
	public Entity(int entityX, int entityY,  int totalHitPoints, String entityName, int entityLevel, 
			Image entityImageLeft, Polygon entityPoly)	{
		this(entityX, entityY, totalHitPoints, "alive" , entityName, entityLevel, entityImageLeft, entityPoly);
	}
	
	public Entity(int entityX, int entityY, int totalHitPoints, String state, String entityName, 
			int entityLevel, Image entityImageLeft, Polygon entityPoly)	{
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
	
	public Entity(int entityX, int entityY, String state, String entityName, 
			Image entityCurrentImage, Polygon entityPoly)	{ //constructor for Item class
		this.entityX = entityX;
		this.entityY = entityY;
		this.state = state;
		this.entityName = entityName;
		this.entityCurrentImage = entityCurrentImage;
		this.entityPoly = entityPoly;
	}	

	
	public void setEntityAni (String spriteSheet) throws SlickException {
		SpriteSheet entitySSLeft = new SpriteSheet (spriteSheet, 77, 89, 20);
		entityAniLeft = new Animation(false);//false arg so that the ani doesnt run when still
		for (int i = 0; i < 8; i++) {
			entityAniLeft.addFrame(entitySSLeft.getSprite(i,0), 30);
		}
		
		Image tempImage = new Image (spriteSheet); //next three statements are for a flipped spritesheet
		Image tempFlipped = tempImage.getFlippedCopy(true, false);
		SpriteSheet entitySSRight = new SpriteSheet (tempFlipped, 77, 89, 20);
		entityAniRight = new Animation(false);
		for (int i = 0; i < 8; i++) {
			entityAniRight.addFrame(entitySSRight.getSprite(i,0), 30);
		}
	}
	
	public Animation getEntityAniLeft() {
		return entityAniLeft;
	}
	
	public Animation getEntityAniRight() {
		return entityAniRight;
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
