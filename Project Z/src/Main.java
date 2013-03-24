// David Ewald & Brandon Roth 'Project Z' 2013
//
//

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
	private Image playerImage;
	

	
	public Main()  {
		super("Project Z");
	}

	
	
	public void init(GameContainer container) throws SlickException  {
		container.setVSync(true);
		playerX = 150;
		playerY = 150;
		player = new Player(playerX, playerY, 100, "Alive", "Timmy", 1, new Image("res/TileSheets/Tangyoon/tangyoon_open.png"),120);
		map = new TiledMap("res/maps/level.tmx");
		playerImage = player.getEntityImageLeft();
	}

	
	
	public void update (GameContainer container, int delta) throws SlickException  {
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) { // Move Left
			playerX-= (.2 * delta);
			updatePlayerPosition();
			playerImage = player.getEntityImageLeft();
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) { // Move Right
			playerX+= (.2 * delta);
			updatePlayerPosition();
			playerImage = player.getEntityImageRight();
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) { // Move Up
			playerY-= (.2 * delta);
			updatePlayerPosition();
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) { // Move Down
			playerY+= (.2 * delta);
			updatePlayerPosition();
		}
	}

	
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.render(0, 0);
		playerImage.draw(playerX, playerY);
	}

	
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Main(), 1280, 720, false);
			container.start();

	}
	
	private void updatePlayerPosition()	{
		player.setEntityX(playerX);
		player.setEntityY(playerY);
	}

}