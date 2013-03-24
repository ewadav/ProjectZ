// David Ewald & Brandon Roth 'Project Z' 2013
//
//

import org.newdawn.slick.Animation;
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
	private Animation player;
	private int playerX;
	private int playerY;
	

	
	public Main()  {
		super("Project Z");
	}

	
	@Override
	public void init(GameContainer container) throws SlickException  {
		playerX = 150;
		playerY = 150;
		
		
	}

	
	@Override
	public void update (GameContainer gc, int delta) throws SlickException  {
		
	}

	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
	}

	
	public static void main(String[] args) throws SlickException {
		

	}

}