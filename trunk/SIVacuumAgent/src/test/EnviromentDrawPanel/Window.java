package test.EnviromentDrawPanel;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.UIManager;

import vacummAgent.VAFloor;
import vacummAgent.environment.VAEnvObservable;
import view.EnvironmentDrawPanel.ElementInterface;



public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final ElementInterface elementInterface;

	public Window() {
		super("Hoover");
		setOptionWindow();
		VAEnvObservable state = new VAEnvObservable(null, new Point(0,2), new VAFloor(100));
		elementInterface = new ElementInterface(state);
		
		this.add(elementInterface, BorderLayout.CENTER);
		
		this.setPreferredSize(new Dimension(300,300));
		this.pack();
		this.setVisible(true);
		
	}

	private void setOptionWindow() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
