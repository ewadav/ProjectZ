// David Ewald & Brandon Roth 'Project Z' 2013
// Main file in charge of game management
//

import java.util.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;


public class Main extends BasicGame {
	private BlockMap map;
	private Player player;
	private int playerX;
	private int playerY;
	private int mapWidth;
	private int mapHeight;
	private boolean jumping;
	private Monster monster;
	private double verticalSpeed;
	
	

	
	public Main()  {
		super("Project Z");
	}

	
	
	public void init(GameContainer container) throws SlickException  {
		container.setVSync(true);
		map = new BlockMap("res/maps/level.tmx");
		playerX = 150;
		playerY = 150;
		mapWidth = map.getMapWidth();
		mapHeight = map.getMapHeight();
		jumping = false;
		createPlayers();
		createMonsters();
	}

	
	
	public void update (GameContainer container, int delta) throws SlickException  {
		checkGameState(container);
		if(!container.isPaused())	{
			movementHandler(container, delta);
			monsterChasingAi(delta);	// Monster chasing player
		}
	}

	
	public void render(GameContainer container, Graphics g) throws SlickException {
			map.getTileMap().render(0, 0);
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
		System.out.println("Player X = " + player.getEntityX() + " Player Y = " + player.getEntityY());
		System.out.println("Player Poly X = " + player.getEntityPoly().getX() + " Player Poly Y = " + player.getEntityPoly().getY());
	}
	
	
	// Creates the players on the map
	private void createPlayers() throws SlickException	{
		Image playerImage = new Image("res/TileSheets/Tangyoon/tangyoon_open.png");
		Polygon poly = new Polygon(new float[] {
				playerX, playerY, 
				playerX + playerImage.getWidth(), playerY, 
				playerImage.getWidth(), playerImage.getHeight(),
				playerX, playerImage.getHeight()});
		player = new Player(playerX, playerY, 100, "Alive", "Tangyoon", 1, playerImage,120, poly);
	}
	
	// Creates monsters on the map
	private void createMonsters() throws SlickException	{
		Image monsterImage = new Image("res/TileSheets/jrcactus/jrcactus_still.png");
		Random generator = new Random();
		int monsterX = generator.nextInt(mapWidth);
		int monsterY = generator.nextInt(mapHeight);
		Polygon poly = new Polygon(new float[] {
				monsterX, monsterY, 
				monsterX + monsterImage.getWidth(),monsterY, 
				monsterImage.getWidth(), monsterImage.getHeight(),
				monsterX, monsterImage.getHeight()});
		monster = new Monster(monsterX, monsterY, 250, "Alive", "JrCactus", 3, monsterImage, 30, 7, .11, poly);
	}
	
	
	// Makes monsters chase player according to move speed and delta
	private void monsterChasingAi(int delta)	{
		// Monster chases in the X direction
		if(playerX + player.getEntityCurrentImage().getWidth()*4/5 < monster.getEntityX())	{
			monster.setEntityX((int)Math.round( .5 + monster.getEntityX() - (monster.getMoveSpeed() * delta)));	
		}else if (playerX - player.getEntityCurrentImage().getWidth()*1/5 > monster.getEntityX())	{
			monster.setEntityX((int)Math.round(monster.getEntityX() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
		
		// Monster chases in the Y direction
		if(playerY < monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight()))	{
			monster.setEntityY((int)Math.round( .5 + monster.getEntityY() - (monster.getMoveSpeed() * delta)));	
		}else if (playerY > monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight()))	{
			monster.setEntityY((int)Math.round(monster.getEntityY() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
	
	}
	
	// Handles all the player movement inputs
	private void movementHandler(GameContainer container, int delta) throws SlickException	{
		
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) { // Move Left
			playerX -= Math.round(.5 + .2 * delta);
			
			if(playerX < 0)	{ 							// Off screen - will not update
				playerX += Math.round(.5 + .2 * delta);
				
			}
			
			player.setEntityCurrentImage(player.getEntityImageLeft());
			System.out.println("Flipped Left");
		}
		
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) { // Move Right
			playerX += Math.round(.5 + .2 * delta);
			
			if(playerX + player.getEntityCurrentImage().getWidth() > mapWidth)	{ 			// Off screen - will not update
				playerX -= Math.round(.5 + .2 * delta);
				
			}
			
			player.setEntityCurrentImage(player.getEntityImageRight());
			System.out.println("Flipped Right");
		}
		
		
		if (container.getInput().isKeyPressed(Input.KEY_SPACE) && !jumping) { // Move Up
			verticalSpeed = -0.75 * delta; // Initial velocity
			jumping = true;
			playerY += verticalSpeed;
			
			
		}
		
		if(jumping)	{
			verticalSpeed +=.035 * delta;  // Gravity factor
			playerY += verticalSpeed;
			
			
			//if(entityCollision())	{
				//playerY -= verticalSpeed;
				//verticalSpeed = 0;
				//jumping = false;
				//player.getEntityPoly().setY(playerY);
			//}
			
		}
		
		if(playerY < 0 || playerY > mapHeight - player.getEntityCurrentImage().getHeight())	{ 							// Off screen - will not update
			jumping = false;
			verticalSpeed = 0.0;
			playerY -= verticalSpeed;
			
			
		}
		
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) { // Move Down
			playerY += Math.round(.5 + .2 * delta);
			
			if(playerY + player.getEntityCurrentImage().getHeight() > mapHeight)	{			 // Off screen - will not update
				playerY -= Math.round(.5 + .2 * delta);
				
			}
			
		}
		updatePlayerPosition();
	}
	
	private void checkGameState(GameContainer container)	{
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE))	{
			if(container.isPaused())	{
				container.resume();
			}else{
				container.pause();
			}
		}
		if(container.getInput().isKeyPressed(Input.KEY_GRAVE))	{
			container.exit();
		}
	}
	
	@SuppressWarnings("unused")
	private boolean entityCollision() throws SlickException	{
		List<Block> colideableBlocks = map.getColideableBlocks(); 
		for (int i = 0; i < colideableBlocks.size(); i++) {
	            Block currentBlock = colideableBlocks.get(i);
	            if (player.getEntityPoly().intersects(currentBlock.getBlockPoly())) {
	            	return true;
	            }
		}
		return false;
	}
	
}