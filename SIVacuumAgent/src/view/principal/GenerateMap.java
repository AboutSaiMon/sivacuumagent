package view.principal;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import vacuumAgent.VAFloor;
import vacuumAgent.environment.VAEnvObservable;
import view.EnvironmentDrawPanel.FloorPanel;

public class GenerateMap implements ActionListener {

	Main frame;
		
	public GenerateMap( Main frame ) 
	{
		super();
		this.frame = frame;		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FloorPanel floorPanel;
		VAEnvObservable state = new VAEnvObservable( null, new Point(0,2), new VAFloor(100) );				
		floorPanel = new FloorPanel( state );
		floorPanel.setEditable(true);
		frame.setSize( 800, 600 );
		frame.setContentPane( floorPanel );
		frame.getGenerateMap().setEnabled( false );
		frame.getGenerateRandomly().setEnabled( false );
		frame.getLoad().setEnabled( false );
		frame.getSave().setEnabled( false );
	}
}
