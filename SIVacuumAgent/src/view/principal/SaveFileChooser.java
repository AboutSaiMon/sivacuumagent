package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.constants.Constants;

public class SaveFileChooser implements ActionListener {

	JPanel panel;
	
	public SaveFileChooser( JPanel panel ) 
	{
		super();
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 ) 
	{
		// TODO Auto-generated method stub
		try {
			JFileChooser fileChooser = new JFileChooser();				
			int n = fileChooser.showSaveDialog( panel );
			if ( n == JFileChooser.APPROVE_OPTION ) {
				File f = fileChooser.getSelectedFile();
				String path = f.getCanonicalPath();
				
				
			}
		} catch ( Exception ex ) 
		{
			JOptionPane.showMessageDialog( null, Constants.ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
		}
	}

}
