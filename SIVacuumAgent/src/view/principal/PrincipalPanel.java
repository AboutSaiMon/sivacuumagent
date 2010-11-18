package view.principal;


import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main;
import util.constants.Constants;

public class PrincipalPanel extends JPanel {

  /**
   * 
   */
	private static final long serialVersionUID = 1L;
	
	Main frame;
	
	public PrincipalPanel( Main frame ) {
		super();
		this.frame = frame;
		createPanel();
		
	}

	private void createPanel() {
		
		JButton openFileChooser = new JButton( Constants.OPEN );
		JButton saveFileChooser = new JButton( Constants.SAVE );
		JButton generateMapRandomly = new JButton( Constants.GENERATERANDOMLY );
		JButton generateMap = new JButton( Constants.GENERATEMAP );
		
		openFileChooser.addActionListener( new OpenFileChooser( this ) );
		saveFileChooser.addActionListener( new SaveFileChooser( this ) );
		generateMapRandomly.addActionListener( new GenerateRandomly() );
		generateMap.addActionListener( new GenerateMap( frame ) );			
		
		this.add( openFileChooser );
		this.add( saveFileChooser );
		this.add( generateMapRandomly );
		this.add( generateMap );
	}	
}