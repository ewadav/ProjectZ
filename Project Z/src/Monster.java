// David Ewald & Brandon Roth 'Project Z' 2013
//
//

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;

public class Monster extends Entity{
	
	private int upperDamageBound;
	private int moneyDrop;
	private int armor;
	private int currentHitPoints;
	private double moveSpeed;
	
	public Monster(int entityX, int entityY, int totalHitPoints, String state,
			String entityName, int entityLevel, Image entityImage, int upperDamageBound,
			int armor, double moveSpeed, Polygon poly) {
		super(entityX, entityY, totalHitPoints, state, entityName, entityLevel,
				entityImage, poly);
		this.upperDamageBound = upperDamageBound;
		this.moneyDrop = entityLevel * 10;
		this.armor = armor;
		this.currentHitPoints = totalHitPoints;
		this.moveSpeed = moveSpeed;
		
		
	}
	
	
	
	public int getUpperDamageBound() {
		return upperDamageBound;
	}
	
	public void setUpperDamageBound(int upperDamageBound) {
		this.upperDamageBound = upperDamageBound;
	}
	
	public int getMoneyDrop() {
		return moneyDrop;
	}
	
	public void setMoneyDrop(int moneyDrop) {
		this.moneyDrop = moneyDrop;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}
	
	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}



	public double getMoveSpeed() {
		return moveSpeed;
	}



	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	
	
}
