// David Ewald & Brandon Roth 'Project Z' 2013
//
//

import org.newdawn.slick.Image;

public class Player extends Entity{
	
	private double money;
	private int totalMana;
	private int currentMana;
	private int currentHitPoints;
	private int experienceToLvlUp;
	private int currentExperience;
	
	
	public Player(int entityX, int entityY, int totalHitPoints, String state,
			String entityName, int entityLevel, Image entityImageLeft, int totalMana) {
		
		super(entityX, entityY, totalHitPoints, state, entityName, entityLevel, entityImageLeft); // Sets all superclass fields
		
		this.totalMana = totalMana;
		this.currentMana = totalMana;
		this.currentHitPoints = totalHitPoints;
		this.experienceToLvlUp = 100;     // Hardcode some shit here   <--------!!!!!
		this.currentExperience = 0;
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
	
	
	
}
