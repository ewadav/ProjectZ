import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class MiniMap {
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;
	private Image miniMap;
	private Graphics mapGraphics;
	private TiledMap tileMap;
	
	
	
	public MiniMap(int mapHeight, int mapWidth, TiledMap tileMap) throws SlickException	{
		xPosition = 10;
		yPosition = 10;
		height = mapWidth;
		width = mapWidth;
		miniMap = new Image(width, height);
		mapGraphics = miniMap.getGraphics();
		mapGraphics.setBackground(Color.black);
		this.tileMap = tileMap;
		mapGraphics.flush();
		
		
		
	}
	
	
	
	
	public void render(GameContainer container, Graphics g, Player player) {
	
		
	}
}
