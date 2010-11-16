package view.EnvironmentDrawPanel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import vacummAgent.environment.VAEnvironment;

public class ElementInterface extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final ToolBar toolbar;
	final DrawPanel drawPanel;
	
	public ElementInterface(final VAEnvironment environment) {
		super(new BorderLayout());
		
		drawPanel = new DrawPanel(environment);
		toolbar = new ToolBar(drawPanel);
		this.addComponent();
		this.setVisible(true);
	}
	
	private void addComponent() {
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(toolbar,BorderLayout.NORTH);
	}

	public DrawPanel getDrawPanel() {
		return drawPanel;
	}	
}
