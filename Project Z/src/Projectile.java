// David Ewald & Brandon Roth 'Project Z' 2013
// This class is teh superclass for all projectiles and ranged attacks
// Keeps track of visibility, position, image, speed, and damage

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;

public class Projectile {
	
	private boolean isVisible;
	private Polygon projectilePolygon;
	private double moveSpeed;
	private Image projectileImageRight;
	private Image projectileImageLeft;
	private int projectileDamage;
	
	public Projectile(boolean isVisible, Polygon projectilePolygon,
			double moveSpeed, Image projectileImageRight,
			Image projectileImageLeft, int projectileDamage) {
		
		this.isVisible = isVisible;
		this.projectilePolygon = projectilePolygon;
		this.moveSpeed = moveSpeed;
		this.projectileImageRight = projectileImageLeft.getFlippedCopy(true, false);
		this.projectileImageLeft = projectileImageLeft;
		this.projectileDamage = projectileDamage;
	}
	
	
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public Polygon getProjectilePolygon() {
		return projectilePolygon;
	}
	
	public void setProjectilePolygon(Polygon projectilePolygon) {
		this.projectilePolygon = projectilePolygon;
	}
	
	public double getMoveSpeed() {
		return moveSpeed;
	}
	
	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	public Image getProjectileImageRight() {
		return projectileImageRight;
	}
	
	public void setProjectileImageRight(Image projectileImageRight) {
		this.projectileImageRight = projectileImageRight;
	}
	
	public Image getProjectileImageLeft() {
		return projectileImageLeft;
	}
	
	public void setProjectileImageLeft(Image projectileImageLeft) {
		this.projectileImageLeft = projectileImageLeft;
	}
	
	public int getProjectileDamage() {
		return projectileDamage;
	}
	
	public void setProjectileDamage(int projectileDamage) {
		this.projectileDamage = projectileDamage;
	}
	
}
