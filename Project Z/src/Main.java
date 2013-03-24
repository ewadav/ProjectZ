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
	

	
	public Main()  {
		super("Project Z");
	}

	
	
	public void init(GameContainer container) throws SlickException  {
		container.setVSync(true);
		playerX = 150;
		playerY = 150;
		player = new Player(playerX, playerY, 100, "Alive", "Timmy", 1, new Image("res/TileSheets/Tangyoon/tangyoon.png"),120);
		map = new TiledMap("res/maps/level.tmx");
	}

	
	
	public void update (GameContainer container, int delta) throws SlickException  {
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) { // Move Left
			playerX--;
			updatePlayerPosition();
		}
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) { // Move Right
			playerX++;
			updatePlayerPosition();
		}
		if (container.getInput().isKeyDown(Input.KEY_UP)) { // Move Up
			playerY--;
			updatePlayerPosition();
		}
		if (container.getInput().isKeyDown(Input.KEY_DOWN)) { // Move Down
			playerY++;
			updatePlayerPosition();
		}
	}

	
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.render(0, 0);
		Image playerImage = player.getEntityImage();
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