// David Ewald & Brandon Roth 'Project Z' 2013
//
//

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;


public class Player extends Entity {
	
	private double money;
	private int totalMana;
	private int currentMana;
	private int currentHitPoints;
	private int experienceToLvlUp;
	private int currentExperience;
	private String lastInput;
	
	
	public Player(int entityX, int entityY, int totalHitPoints, String state,
			String entityName, int entityLevel, int totalMana, Image playerImage, Polygon poly) {
		
		super(entityX, entityY, totalHitPoints, state, entityName, entityLevel, playerImage, poly); // Sets all superclass fields
		
		this.totalMana = totalMana;
		this.currentMana = totalMana;
		this.currentHitPoints = totalHitPoints;
		this.experienceToLvlUp = 100;     // Hardcode some shit here   <--------!!!!!
		this.currentExperience = 0;
	}
	
	
	public void render(GameContainer gc, Graphics g)	{	
		g.setColor(Color.white);
		if (lastInput == null) { //before any input, just draw the ani
			super.getEntityAniLeft().draw(super.getEntityX(), super.getEntityY());
		}
		if (lastInput == "left") { //if last input was left, draw left ani
			super.getEntityAniLeft().draw(super.getEntityX(), super.getEntityY());
		}
		if (lastInput == "right") { //if last input was right, draw right ani
			super.getEntityAniRight().draw(super.getEntityX(), super.getEntityY());
		}
		g.drawString(super.getEntityName() , super.getEntityX() + 20, super.getEntityY() + 95);
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	public int getTotalMana() {
		return totalMana;
	}
	
	public void setTotalMana(int totalMana) {
		this.totalMana = totalMana;
	}
	
	
	public int getCurrentMana() {
		return currentMana;
	}
	
	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}
	
	
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}
	
	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}
	
	
	public int getExperienceToLvlUp() {
		return experienceToLvlUp;
	}
	
	public void setExperienceToLvlUp(int experienceToLvlUp) {
		this.experienceToLvlUp = experienceToLvlUp;
	}
	
	
	public int getCurrentExperience() {
		return currentExperience;
	}
	
	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}

	
	public String getLastInput() {
		return lastInput;
	}
	
	public void setLastInput (String input) {
		this.lastInput = input;
	}
	
}
