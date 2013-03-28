import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;

//


public class Portal {
	
	private int portalX;
	private int portalY;
	private Polygon portalPoly;
	private Image portalImage;
	private String portalMap;
	
	
	public Portal(int portalX, int portalY, String map) throws SlickException	{
		this.portalX = portalX;
		this.portalY = portalY;
		portalMap = map;
		portalImage = new Image("res/TileSheets/portal/portal.png");
		portalPoly = new Polygon(new float[] {
				portalX, portalY, 
				portalX + portalImage.getWidth(), portalY, 
				portalX + portalImage.getWidth(), portalY + portalImage.getHeight(),
				portalX, portalY + portalImage.getHeight()});
	}


	public int getPortalX() {
		return portalX;
	}


	public void setPortalX(int portalX) {
		this.portalX = portalX;
	}


	public int getPortalY() {
		return portalY;
	}


	public void setPortalY(int portalY) {
		this.portalY = portalY;
	}


	public Polygon getPortalPoly() {
		return portalPoly;
	}


	public void setPortalPoly(Polygon portalPoly) {
		this.portalPoly = portalPoly;
	}


	public Image getPortalImage() {
		return portalImage;
	}


	public void setPortalImage(Image portalImage) {
		this.portalImage = portalImage;
	}


	public String getPortalMap() {
		return portalMap;
	}


	public void setPortalMap(String portalMap) {
		this.portalMap = portalMap;
	}
	
	
	
	
	
}
