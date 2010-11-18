package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import file.FileManager;

import util.constants.Constants;
import vacuumAgent.VAFloor;

public class OpenFileChooser implements ActionListener {	
	
	JPanel panel;
		
	public OpenFileChooser( JPanel panel ) 
	{
		super();
		this.panel = panel;
	}


	@Override
	public void actionPerformed( ActionEvent arg0 ) 
	{
		// TODO Auto-generated method stub
		try 
		{				
			JFileChooser fileChooser = new JFileChooser();
			int n = fileChooser.showOpenDialog( panel );
			if (n == JFileChooser.APPROVE_OPTION){
				File f = fileChooser.getSelectedFile();
				String path = f.getCanonicalPath();
				
				VAFloor loadedMap = FileManager.load( path );
				
			}
		}
		catch ( Exception ex ) 
		{
			JOptionPane.showMessageDialog( null, Constants.ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
		}
	}
}
