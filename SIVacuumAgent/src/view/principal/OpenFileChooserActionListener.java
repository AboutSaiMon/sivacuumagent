package view.principal;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import main.Main;
import util.constants.Constants;
import vacuumAgent.VAFloor;
import vacuumAgent.environment.VAEnvObservable;
import vacuumAgent.environment.VAEnvironment;
import view.EnvironmentDrawPanel.FloorPanel;
import file.FileManager;

public class OpenFileChooserActionListener implements ActionListener {	
	
	Main frame;
		
	public OpenFileChooserActionListener( Main frame ) 
	{
		super();
		this.frame = frame;
	}


	@Override
	public void actionPerformed( ActionEvent arg0 ) 
	{
		// TODO Auto-generated method stub
		try 
		{				
			JFileChooser fileChooser = new JFileChooser();
			int n = fileChooser.showOpenDialog( frame );

			if ( n == JFileChooser.APPROVE_OPTION ){
				File f = fileChooser.getSelectedFile();
				String path = f.getCanonicalPath();
				
				VAEnvironment env = FileManager.load( path );
				VAFloor loadedMap = env.getFloor();
				Point p = env.getVacuumAgentPosition();			
				
				FloorPanel floorPanel;
				VAEnvObservable state = new VAEnvObservable( null, p, loadedMap );				
				floorPanel = new FloorPanel( state );
				floorPanel.setEditable( false );
				frame.setSize( 800, 600 );
				frame.setContentPane( floorPanel );
				frame.getGenerateMap().setEnabled( false );
				frame.getGenerateRandomly().setEnabled( false );
				frame.getLoad().setEnabled( false );
				frame.getSave().setEnabled( true );
				frame.getSave().addActionListener( new SaveFileChooserActionListener( frame ) );
				frame.getStart().setEnabled( true );
				frame.getMoveOneStep().setEnabled( true );
			}
		}
		catch ( Exception ex ) 
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog( null, Constants.ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
		}
	}
}
