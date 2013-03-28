import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public abstract class Component {
	protected int x, y, width, height;
	protected final int id;
	
	protected List<Listener> listeners = new ArrayList<Listener>();
	
	public Component(int id) {
		this.id = id;
	}
	
	public void addListener(Listener l) {
		listeners.add(l);
	}

	public int getX() {
		return x;
	}
	
	public abstract void render(GameContainer gc, Graphics g);
	public abstract void update(GameContainer gc);
	
	public boolean isIntersecting(int mx, int my) {
		return (mx > x && my > y && mx < x + width && my < y + height);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
