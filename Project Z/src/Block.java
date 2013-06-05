// David Ewald & Brandon Roth 'Project Z' 2013
// This class keeps track of blocks on the map
// It holds the polygon of the block, its X and Y and the type of block

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;


public class Block {
	
	private Polygon blockPoly;
	private String blockType;
	private int blockX;
	private int blockY;
	private double speedMultiplier;
	
	
	public Block(int x, int y, int test[], String type, double speedMultiplier)	{
		 blockPoly = new Polygon(new float[]{
		            x+test[0], y+test[1],
		            x+test[2], y+test[3],
		            x+test[4], y+test[5],
		            x+test[6], y+test[7], });   
		blockType = type;
		blockX = x;
		blockY = y;
		this.speedMultiplier = speedMultiplier;
		
	}
	
	
	public void draw(Graphics g) {
	    g.draw(blockPoly);
	}

	
	public Polygon getBlockPoly() {
		return blockPoly;
	}

	public void setBlockPoly(Polygon blockPoly) {
		this.blockPoly = blockPoly;
	}

	
	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	
	public int getBlockX() {
		return blockX;
	}

	public void setBlockX(int blockX) {
		this.blockX = blockX;
	}

	
	public int getBlockY() {
		return blockY;
	}

	public void setBlockY(int blockY) {
		this.blockY = blockY;
	}

	
	public double getSpeedMultiplier() {
		return speedMultiplier;
	}

	public void setSpeedMultiplier(double speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
	}
	
}
