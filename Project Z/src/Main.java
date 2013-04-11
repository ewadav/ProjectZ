//  'Project Z' 2013
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
	private boolean jumping;
	private Monster monster;
	private double verticalSpeed;
	private List<Item> itemsOnMap;
	private final int initialSpawnX;
	private final int initialSpawnY;
	private Block currentBlock;
	
	
	/**********************************************
	 * Main method for slick, doesn't do all that much. Lists project name, initializes fields.
	 */
	public Main()  {
		super("Project Z");
		jumping = false;
		itemsOnMap = new ArrayList<Item>();
		initialSpawnX = 250;
		initialSpawnY = 250;
	}
	
	
	/**********************************************
	 * Initialization method for Slick. Allocates memory, creates objects.
	 * Run at the launch of the game and when manually called in the game.
	 */
	public void init(GameContainer container) throws SlickException  {
		container.setVSync(true);
		map = new BlockMap("Project Z/res/maps/level.tmx", null, new Portal(200, 500, "Project Z/res/maps/level2.tmx"));
		createPlayers();
		createMonsters();
		createItems();
	}
	
	
	/**********************************************
	 * Update method for Slick. Runs every frame.
	 * Listens for keypresses and runs these internal methods.
	 */
	public void update (GameContainer container, int delta) throws SlickException  {
		checkGameState(container);
		if(!container.isPaused())	{
			movementHandler(container, delta);
			monsterChasingAi(delta);	// Monster chasing player
		}
	}
	
	
	/**********************************************
	 * Render method for Slick. Runs every frame.
	 * Displays images, the map, and other information to the game window
	 */
	public void render(GameContainer container, Graphics g) throws SlickException {
			map.render(container, g); // renders map
			
			player.render(container, g); // renders player

			monster.getEntityCurrentImage().draw(monster.getEntityX(), monster.getEntityY()); // renders monster
			
			for(Item item : itemsOnMap)	{ // renders all items on map
				item.getEntityCurrentImage().draw(item.getEntityX(), item.getEntityY());
			}
			
			drawGameStats(container, g); // renders stats of game
	}
	
	
	/**********************************************
	 * Main method for the game. Logistical use, executes main slick method.
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Main(), 1280, 720, false);
		container.start();
	}
	
	
	
	/*************************Helper Methods Below*************************/
	
	
	
	/**********************************************
	 * Creates and populates the player(s) on the map
	 */
	private void createPlayers() throws SlickException	{
		Image playerImage = new Image("Project Z/res/TileSheets/Tangyoon/tangyoon_open.png");
		Polygon poly = new Polygon(new float[] {
				initialSpawnX, initialSpawnY, 
				initialSpawnX + 73, initialSpawnY, 
				initialSpawnX + 73, initialSpawnY + 89,
				initialSpawnX, initialSpawnY + 89});
		
		player = new Player(initialSpawnX, initialSpawnY, 100, "Alive", "Robot", 1, 120, playerImage, poly);
		
		player.setEntityAni("Project Z/res/TileSheets/robotBoy/masterrobo_moving.png");
	}
	
	
	/**********************************************
	 * Creates and populates the monster(s) on the map
	 */
	private void createMonsters() throws SlickException	{
		Image monsterImage = new Image("Project Z/res/TileSheets/jrcactus/jrcactus_still.png");
		
		Random generator = new Random();
		int monsterX = generator.nextInt(map.getMapWidth());
		int monsterY = generator.nextInt(map.getMapHeight());
		
		Polygon poly = new Polygon(new float[] {
				monsterX, monsterY, 
				monsterX + monsterImage.getWidth(),monsterY, 
				monsterImage.getWidth(), monsterImage.getHeight(),
				monsterX, monsterImage.getHeight()});
		
		monster = new Monster(monsterX, monsterY, 250, "Alive", "JrCactus", 3, monsterImage, 30, 7, .11, poly);
	}
	
	
	/**********************************************
	 * Creates and populates the item(s) on the map
	 */
	private void createItems() throws SlickException	{
		Image testItemImage = new Image ("Project Z/res/TileSheets/meso/mesocopper_still.png");
		
		Polygon testItemPoly = new Polygon(new float[] {
				400, 400, 
				400 + testItemImage.getWidth(), 400, 
				400 + testItemImage.getWidth(), 400 + testItemImage.getHeight(),
				400, 400 + testItemImage.getHeight()});
		
		Item testItem = new Item (400, 400, "alive", "Copper Meso", testItemImage, 14, testItemPoly);
		itemsOnMap.add(testItem);
	}
	
	
	/**********************************************
	 * Checks the state of the game. Run at every frame.
	 * Determines if the game is paused and other various states.
	 */
	private void checkGameState(GameContainer container)	{
		if(container.getInput().isKeyPressed(Input.KEY_GRAVE))	{
			if(container.isPaused())	{
				container.resume();
			}else{
				container.pause();
			}
		}
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE))	{
			container.exit();
		}
	}
	
	
	/**********************************************
	 * Handles all the player inputs
	 */
	private void movementHandler(GameContainer container, int delta) throws SlickException {
		int playerX = player.getEntityX();
		int playerY = player.getEntityY();
		
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) { // Move Left
			player.setEntityX(player.getEntityX() - (int) Math.round(.5 + .2 * delta));
			//player.setEntityCurrentImage(player.getEntityImageLeft());
			player.getEntityAniLeft().update(delta);
			player.getEntityAniLeft().draw(player.getEntityX(), player.getEntityY());
			
			player.setLastInput ("left");
		}

		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) { // Move Right
			player.setEntityX(player.getEntityX() + (int) Math.round(.5 + .2 * delta));
			player.setEntityCurrentImage(player.getEntityImageRight());
			player.getEntityAniRight().update(delta);
			player.getEntityAniRight().draw(player.getEntityX(), player.getEntityY());
			
			player.setLastInput ("right");
		}

		if (container.getInput().isKeyPressed(Input.KEY_SPACE) && !jumping) { // JumpUp
			verticalSpeed = -0.75 * delta; // Initial velocity
			jumping = true;
			player.setEntityY((int) (player.getEntityY() + verticalSpeed));
		}

		if (jumping) {
			verticalSpeed += .035 * delta; // Gravity factor

			player.setEntityY((int) (player.getEntityY() + verticalSpeed));
			if (entityCollision()) {
				player.setEntityY(playerY);
				verticalSpeed = .035 * delta;
			}
		}

		if (container.getInput().isKeyDown(Input.KEY_DOWN)) { // Move Down
			player.setEntityY(player.getEntityY() + (int) (Math.round(.5 + .2 * delta)));
		}
		
		// If player hits 'V', looks to see if item is close by, and picks it up
		if (container.getInput().isKeyDown(Input.KEY_V)) {
			playerItemPickUp();
		}
		
		if(container.getInput().isKeyDown(Input.KEY_UP))	{
			reInitializeMap();
		}
		
		if (entityCollision()) {
			if (verticalSpeed >= 0.0 && playerY >= this.currentBlock.getBlockY()) {
				player.setEntityY(this.currentBlock.getBlockY());
				player.setEntityX(playerX);
				verticalSpeed = 0.0;
				jumping = false;
			} else {
				player.setEntityY(playerY);
				player.setEntityX(playerX);
				jumping = false;
			}
		}
	}
	
	
	/**********************************************
	 * Makes monsters chase player according to move speed and delta
	 */
	private void monsterChasingAi(int delta) {
		// Monster chases in the X direction
		if(player.getEntityX() + player.getEntityCurrentImage().getWidth()*4/5 < monster.getEntityX()) {
			monster.setEntityX((int)Math.round( .5 + monster.getEntityX() - (monster.getMoveSpeed() * delta)));	
		}
		else if (player.getEntityX() - player.getEntityCurrentImage().getWidth()*1/5 > monster.getEntityX()) {
			monster.setEntityX((int)Math.round(monster.getEntityX() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
		
		// Monster chases in the Y direction
		if(player.getEntityY() < monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight()))	{
			monster.setEntityY((int)Math.round( .5 + monster.getEntityY() - (monster.getMoveSpeed() * delta)));	
		}
		else if (player.getEntityY() > monster.getEntityY() + (monster.getEntityCurrentImage().getHeight() - player.getEntityCurrentImage().getHeight())) {
			monster.setEntityY((int)Math.round(monster.getEntityY() - .5 + (monster.getMoveSpeed() * delta)));	
		} 
	}
	
	
	/**********************************************
	 * This method will check to see if the player ever intercepts an item. Runs only if 'V' is pressed
	 * 	 * Will eventually check through a list of items.
	 */
	private void playerItemPickUp () throws SlickException {
		if(!itemsOnMap.isEmpty())	{
			Iterator<Item> iter = itemsOnMap.iterator();
			while(iter.hasNext())	{
				Item item = iter.next();
				if (player.getEntityPoly().intersects(item.getEntityPoly())){
					player.setMoney(player.getMoney() + item.getItemWorth());
					iter.remove();
				}
			}
		}
	}
	
	
	/**********************************************
	 * Stub, someone comment what this does
	 */
	private void reInitializeMap() throws SlickException	{
		if(map.getEntryPortal() != null)	{
			if(player.getEntityPoly().intersects(map.getEntryPortal().getPortalPoly()))	{
				map = new BlockMap(map.getEntryPortal().getPortalMap(), new Portal(50, 290, map.getEntryPortal().getPortalMap()), new Portal(200, 500, map.getEntryPortal().getPortalMap()));
			}
		}
		if(map.getExitPortal() != null) 	{
			if(player.getEntityPoly().intersects(map.getExitPortal().getPortalPoly()))	{
			map = new BlockMap(map.getExitPortal().getPortalMap(), new Portal(50, 290, "Project Z/res/maps/level.tmx"), null);

			}
		}
	}
	
	
	/**********************************************
	 * IDK exactly what this is David, main executable collision method?
	 */
	private boolean entityCollision() throws SlickException	{
		List<Block> colideableBlocks = map.getColideableBlocks(); 
		for (int i = 0; i < colideableBlocks.size(); i++) {
	            Block currentBlock = colideableBlocks.get(i);
	            if (player.getEntityPoly().intersects(currentBlock.getBlockPoly())) {
	            	this.currentBlock = currentBlock;
	            	return true;
	            }
		}
		return false;
	}
	
	private void drawGameStats(GameContainer container, Graphics g) throws SlickException	{
		g.drawString ("playerX: " + player.getEntityX(), 30, 125);
		g.drawString ("playerY: " + player.getEntityY(), 30, 145);
		g.drawString ("PlayerPolyX: " + player.getEntityPoly().getX(), 30, 165);
		g.drawString ("PlayerPolyY: " + player.getEntityPoly().getY(), 30, 185);
		g.drawString ("PlayerMoney: " + player.getMoney(), 30, 205);
	}
}
