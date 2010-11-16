package view.EnvironmentDrawPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import vacummAgent.VATile;
import vacummAgent.VATile.VATileStatus;
import vacummAgent.environment.VAEnvironment;


@SuppressWarnings("serial")
public class DrawPanel extends JPanel  {
	private VAEnvironment environment;
	
	private BufferedImage buffer;
	private Graphics2D gbuffer;
	
	
	private EventDrawPanel eventDrawPanel;
	//IMAGE 
	static private BufferedImage tileTexture;
	static private BufferedImage wall;
	static private BufferedImage powder;
	static private BufferedImage robotTexture;
	
	private VATileStatus elementToAdd;
	private Point mousePosition;


	public DrawPanel(VAEnvironment environment) {
		super();
		loadImage();
		this.environment = environment;
		this.eventDrawPanel = new EventDrawPanel(this);
		
		this.addMouseListener(eventDrawPanel);
		this.addMouseMotionListener(eventDrawPanel);
		this.addKeyListener(eventDrawPanel);
		this.addMouseWheelListener(eventDrawPanel);
		this.setFocusable(true);
		
		elementToAdd = null;
	
		
		Thread t = new Thread(new RepainterApp(this));
		t.start();
	}

	private void loadImage() {
		try {
			tileTexture = ImageIO.read(new File("img/tile.jpg"));
			wall = ImageIO.read(new File("img/crate.png"));
			powder = ImageIO.read(new File("img/powder.png"));
			robotTexture = ImageIO.read(new File("img/robot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		gbuffer = buffer.createGraphics();
		this.draw(gbuffer, eventDrawPanel.getCamXpos() / eventDrawPanel.getZoom(), 
				  eventDrawPanel.getCamYpos() / eventDrawPanel.getZoom(), 
				  this.getWidth() / eventDrawPanel.getZoom(), 
				  this.getHeight() / eventDrawPanel.getZoom());
		g.drawImage(buffer, 0, 0, null);
	}

	public void draw(Graphics2D g, int rowinit, int colinit,int w, int h) {
		int size = this.environment.getFloor().getSize();
		int zoom = eventDrawPanel.getZoom();
		int endCol = colinit+w;
		int endRow = rowinit+h;
		if(endCol>=size)
			endCol=size-1;
		if(endRow >= size)
			endRow = size-1;
		
		for (int i = rowinit; i <= endRow; ++i) {
			for (int j = colinit ; j <= endCol; ++j) {
				Point matrixPos = new Point(i,j);
				VATile tile = environment.getFloor().getTile(matrixPos);
				int c=(j-colinit)*eventDrawPanel.getZoom();
				int r=(i-rowinit)*eventDrawPanel.getZoom();
				
				g.drawImage(tileTexture,c,r , zoom, zoom, null);
				if (tile.getStatus() == VATileStatus.BLOCK)
					g.drawImage(wall, c, r, zoom, zoom, null);
				else if (tile.getStatus() == VATileStatus.DIRTY)
					g.drawImage(powder, c, r, zoom, zoom, null);

			}
		}
		Point agentPosition = this.environment.getVacuumAgentPosition();
		
		if(elementToAdd == null || elementToAdd != VATileStatus.UNDEFINED )
				g.drawImage(robotTexture, (agentPosition.y-colinit)*zoom, (agentPosition.x-rowinit)*zoom, zoom, zoom, null);
		
		
		if(elementToAdd!=null){
			
			if (elementToAdd == VATileStatus.BLOCK)
				g.drawImage(wall, mousePosition.x-(50/2), mousePosition.y-(50/2), 50, 50, null);
			else if (elementToAdd == VATileStatus.DIRTY)
				g.drawImage(powder, mousePosition.x-(50/2), mousePosition.y-(50/2), 50, 50, null);
			else if (elementToAdd == VATileStatus.UNDEFINED)
				g.drawImage(robotTexture, mousePosition.x-(50/2), mousePosition.y-(50/2), 50, 50, null);
		}
	}

	public VATileStatus getElementToAdd() {
		return elementToAdd;
	}

	public void setElementToAdd(VATileStatus elementToAdd) {
		this.elementToAdd = elementToAdd;
	}

	public void addToFloor(Point point, int zoom, int camXpos, int camYpos) {
		if(elementToAdd!=null){
			int sizefloor = this.environment.getFloor().getSize();
			int row = (point.y + camXpos) / zoom ;
			int col = (point.x + camYpos) / zoom;
			if(row >= 0 && row < sizefloor && col >= 0 && col < sizefloor){
				if(elementToAdd != VATileStatus.UNDEFINED)
					this.environment.getFloor().getTile(new Point(row, col)).setStatus(elementToAdd);
				else if(elementToAdd == VATileStatus.UNDEFINED){
					this.environment.setVacuumAgentPosition(new Point(row, col));
					elementToAdd = null;
				}
				this.repaint();
			}
			
		}
		
	}

	public void removeElement(Point point, int zoom, int camXpos, int camYpos) {
		int sizefloor = this.environment.getFloor().getSize();
		int row = (point.y + camXpos) / zoom ;
		int col = (point.x + camYpos) / zoom;
		if(row >= 0 && row < sizefloor && col >= 0 && col < sizefloor){
			this.environment.getFloor().getTile(new Point(row, col)).setStatus(VATileStatus.CLEAN);
		}
		
	}

	public Point getMousePosition() {
		return mousePosition;
	}

	public void setMousePosition(Point mousePosition) {
		this.mousePosition = mousePosition;
		if(elementToAdd!=null)
			this.repaint();
	}
	
	
}
