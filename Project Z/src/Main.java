// David Ewald & Brandon Roth 'Project Z' 2013
//
//
import java.util.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Main extends BasicGame {
	private TiledMap map;
	private Player player;
	private int playerX;
	private int playerY;
	private int mapWidth;
	private int mapHeight;
	private boolean jumping;
	private Monster monster;
	
	

	
	public Main()  {
		super("Project Z");
	}

	
	
	public void init(GameContainer container) throws SlickException  {
		container.setVSync(true);
		playerX = 150;
		playerY = 150;
		mapWidth = 1280;
		mapHeight = 720;
		jumping = false;
		map = new TiledMap("res/maps/level.tmx");
		createPlayers();
		createMonsters();
		
	}

	
	
	public void update (GameContainer container, int delta) throws SlickException  {
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) { // Move Left
			playerX -= Math.round(.5 + .2 * delta);
			if(playerX < 0)	{ 					// Off screen - will not update
				playerX += Math.round(.5 + .2 * delta);
			}
			updatePlayerPosition();
			player.setEntityCurrentImage(player.getEntityImageLeft());
			
			System.out.println("Flipped Left");
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) { // Move Right
			playerX += Math.round(.5 + .2 * delta);
			if(playerX + 135 > mapWidth)	{ 			// Off screen - will not update
				playerX -= Math.round(.5 + .2 * delta);
			}
			updatePlayerPosition();
			player.setEntityCurrentImage(player.getEntityImageRight());
			
			System.out.println("Flipped Right");
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) { // Move Up
			playerY -= Math.round(.5 + .2 * delta);
			if(playerY < 0)	{ 					// Off screen - will not update
				playerY += Math.round(.5 + .2 * delta);
			}
			updatePlayerPosition();
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) { // Move Down
			playerY += Math.round(.5 + .2 * delta);
			if(playerY + 110 > mapHeight)	{			 // Off screen - will not update
				playerY -= Math.round(.5 + .2 * delta);
			}
			updatePlayerPosition();
		}
		
		//playerY + player.currentimage.getHeight - 
		//player.getEntityCurrentImage().getCenterOfRotationX()
		if(playerX + player.getEntityCurrentImage().getWidth()*4/5 < monster.getEntityX())	{
			monster.setEntityX((int)Math.round( .5 + monster.getEntityX() - (monster.getMoveSpeed() * delta)));	
		}else if (playerX - player.getEntityCurrentImage().getWidth()*1/5 > monster.getEntityX())	{
			monster.setEntityX((int)Math.round(monster.getEntityX() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
		//+ player.getEntityCurrentImage().getHeight()*4/5
		if(playerY < monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight()))	{
			monster.setEntityY((int)Math.round( .5 + monster.getEntityY() - (monster.getMoveSpeed() * delta)));	
		}else if (playerY > monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight()))	{
			monster.setEntityY((int)Math.round(monster.getEntityY() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
		
	}

	
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.render(0, 0);
		player.getEntityCurrentImage().draw(playerX, playerY);
		monster.getEntityCurrentImage().draw(monster.getEntityX(), monster.getEntityY());
		g.drawString(player.getEntityName() , playerX + 30, playerY + 105);
	}

	
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Main(), 1280, 720, false);
			container.start();

	}
	
	
	
	////  Helper Methods Below    ////
	
	
	// Updates the player position after a movement
	private void updatePlayerPosition()	{
		player.setEntityX(playerX);
		player.setEntityY(playerY);
		System.out.println(player.getEntityX() + " " + player.getEntityY());
	}
	
	
	// Creates the players on the map
	private void createPlayers() throws SlickException	{
		player = new Player(playerX, playerY, 100, "Alive", "Tangyoon", 1, new Image("res/TileSheets/Tangyoon/tangyoon_open.png"),120);
	}
	
	private void createMonsters() throws SlickException	{
		Random generator = new Random();
		monster = new Monster(generator.nextInt(mapWidth),generator.nextInt(mapHeight), 250, "Alive", "JrCactus", 3, new Image("res/TileSheets/jrcactus/jrcactus_still.png"), 30, 7, .11);
	}

}