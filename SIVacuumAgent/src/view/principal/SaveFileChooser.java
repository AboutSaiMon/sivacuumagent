package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import file.FileManager;

import main.Main;
import util.constants.Constants;

public class SaveFileChooser implements ActionListener {

	Main frame;
	
	public SaveFileChooser( Main frame ) 
	{
		super();
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 ) 
	{
		// TODO Auto-generated method stub
		try {
			JFileChooser fileChooser = new JFileChooser();				
			int n = fileChooser.showSaveDialog( frame );
			if ( n == JFileChooser.APPROVE_OPTION ) {
				File f = fileChooser.getSelectedFile();
				String path = f.getCanonicalPath();
				FileManager.save( frame.getFloor(), path );
			}
		} catch ( Exception ex ) 
		{
			JOptionPane.showMessageDialog( null, Constants.ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
		}
	}

}
