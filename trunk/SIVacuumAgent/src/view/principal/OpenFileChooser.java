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
import view.EnvironmentDrawPanel.FloorPanel;
import file.FileManager;

public class OpenFileChooser implements ActionListener {	
	
	Main frame;
		
	public OpenFileChooser( Main frame ) 
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
				
				VAFloor loadedMap = FileManager.load( path );
				Point p = new Point( 0, 0 );				
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
				frame.getSave().addActionListener( new SaveFileChooser( frame ) );
			}
		}
		catch ( Exception ex ) 
		{
			JOptionPane.showMessageDialog( null, Constants.ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
		}
	}
}
