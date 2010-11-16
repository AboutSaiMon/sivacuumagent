package view.EnvironmentDrawPanel;

import java.awt.Component;


public class RepainterApp implements Runnable {
	
	final Component toRepaint;
	
	public RepainterApp(final DrawPanel  drawPanel) {
		toRepaint = drawPanel;
	}
	
	@Override
	public void run() {
		while(true)
		{
			toRepaint.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
