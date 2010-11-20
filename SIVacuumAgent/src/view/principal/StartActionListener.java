package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exception.VAIllegalMove;

import main.Main;
import vacuumAgent.environment.VAEnvironment;
import view.EnvironmentDrawPanel.FloorPanel;

public class StartActionListener implements ActionListener {

	Main frame;
	int step;
	
	public StartActionListener( Main frame, int step ) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.step = step;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FloorPanel floor = ( FloorPanel ) frame.getContentPane();
		floor.setEditable( false );
		frame.getSave().setEnabled( false );
		
		VAEnvironment environment = frame.getEnvironment();
		
		try 
		{
			if( step == 0 )
			{
				environment.stepUntilDone();
				frame.getMoveOneStep().setEnabled( false );
			}
			else
				environment.step( step );
		} catch ( VAIllegalMove e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
