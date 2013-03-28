// David Ewald & Brandon Roth 'Project Z' 2013
// This class holds the TiledMap as well as the Width and Height
// Also Holds the size of the blocks, as well as the blocks which are colideable

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class BlockMap {
	
	private TiledMap tileMap;
	private int mapWidth;
	private int mapHeight;
	private ArrayList<Block> colideableBlocks;
	private int[] blockSize = {1,1,15,1,15,15,1,15};
	
	
	public BlockMap(String tileMap) throws SlickException	{
		colideableBlocks = new ArrayList<Block>();
		this.tileMap = new TiledMap(tileMap);
		setMapWidth(this.tileMap.getWidth() * this.tileMap.getTileWidth());
	    setMapHeight(this.tileMap.getHeight() * this.tileMap.getTileHeight());
		
	    for (int x = 0; x < this.tileMap.getWidth(); x++) {
	        for (int y = 0; y < this.tileMap.getHeight(); y++) {
	        	int tileId = this.tileMap.getTileId(x, y, 0);
	        	if(this.tileMap.getTileProperty(tileId, "blocked", "false").equals("true"))	{
	        		colideableBlocks.add(new Block(x * 16, y* 16, blockSize, "Block", 1.0));
	        	}
	        	
	        }
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
	
}
