package view.EnvironmentDrawPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EventDrawPanel implements MouseListener, MouseMotionListener,
		KeyListener, MouseWheelListener {

	private int camXpos;
	private int camYpos;
	private int zoom;
	private DrawPanel drawPanel;

	public EventDrawPanel(DrawPanel drawPanel) {
		this.camXpos = 0;
		this.camYpos = 0;
		this.zoom = 100;
		this.drawPanel = drawPanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			if (camXpos - zoom >= 0){
				camXpos -= zoom;
				drawPanel.repaint();}
			break;
		case KeyEvent.VK_DOWN:
			camXpos += zoom;
			drawPanel.repaint();
			break;
		case KeyEvent.VK_RIGHT:
			camYpos += zoom;
			drawPanel.repaint();
			break;
		case KeyEvent.VK_LEFT:

			if (camYpos - zoom >= 0){
				camYpos -= zoom;
				drawPanel.repaint();
			}
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		drawPanel.setMousePosition(e.getPoint());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		drawPanel.requestFocus();
		if (e.getButton() == MouseEvent.BUTTON1) {
			drawPanel.addToFloor(e.getPoint(), zoom, camXpos, camYpos);
			drawPanel.repaint();
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			drawPanel.removeElement(e.getPoint(), zoom, camXpos, camYpos);
			drawPanel.repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		drawPanel.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int getCamXpos() {
		return camXpos;
	}

	public int getCamYpos() {
		return camYpos;
	}

	public int getZoom() {
		return zoom;
	}

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {
			if (zoom < 150) {
				zoom += 10;
				drawPanel.repaint();
			}
		} else {
			if (zoom - 10 > 50) {
				zoom -= 10;
				drawPanel.repaint();
			}
		}

	}
}
