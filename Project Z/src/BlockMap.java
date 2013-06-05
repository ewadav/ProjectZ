 // David Ewald & Brandon Roth 'Project Z' 2013
// This class holds the TiledMap as well as the Width and Height
// Also Holds the size of the blocks, as well as the blocks which are colideable

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class BlockMap {
	
	private TiledMap tileMap;
	private int mapWidth;
	private int mapHeight;
	private List<Block> colideableBlocks;
	private int[] blockSize = {1,1,15,1,15,15,1,15};
	private Portal entryPortal;
	private Portal exitPortal;
	
	
	public BlockMap(String tileMap, Portal entryPortal, Portal exitPortal) throws SlickException	{
		colideableBlocks = new ArrayList<Block>();
		this.tileMap = new TiledMap(tileMap);
		setMapWidth(this.tileMap.getWidth() * this.tileMap.getTileWidth());
	    setMapHeight(this.tileMap.getHeight() * this.tileMap.getTileHeight());
	    this.entryPortal = entryPortal;
	    this.exitPortal = exitPortal;
		
	    for (int x = 0; x < this.tileMap.getWidth(); x++) {
	        for (int y = 0; y < this.tileMap.getHeight(); y++) {
	        	int tileId = this.tileMap.getTileId(x, y, 0);
	        	if(this.tileMap.getTileProperty(tileId, "blocked", "false").equals("true"))	{
	        		colideableBlocks.add(new Block(x * 16, y* 16, blockSize, "Block", 1.0));
	        	}
	        	
	        }
	    }
	}

	public void render(GameContainer gc, Graphics g)	{	
		tileMap.render(0, 0);
		if(entryPortal != null)	{
			entryPortal.getPortalImage().draw(entryPortal.getPortalX(), entryPortal.getPortalY());
		} else if(exitPortal != null)	{
			exitPortal.getPortalImage().draw(exitPortal.getPortalX(), exitPortal.getPortalY());
		}
	}
	
	
	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	
	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}
	
	
	public TiledMap getTileMap()	{
		return this.tileMap;
	}
	
	public void setTileMap(TiledMap tileMap)	{
		this.tileMap = tileMap;
	}
	
	
	public List<Block> getColideableBlocks()	{
		return colideableBlocks;
	}

	public Portal getEntryPortal() {
		return entryPortal;
	}

	public void setEntryPortal(Portal entryPortal) {
		this.entryPortal = entryPortal;
	}

	public Portal getExitPortal() {
		return exitPortal;
	}

	public void setExitPortal(Portal exitPortal) {
		this.exitPortal = exitPortal;
	}
	
}
