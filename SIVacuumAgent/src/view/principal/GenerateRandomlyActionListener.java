package view.principal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.constants.Constants;

public class GenerateRandomlyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame( Constants.TITLE );
		frame.setResizable( false);
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.setSize( 230, 150 );
		frame.setLocation( 300, 300 );
		
		JPanel panel = new JPanel();
		
		panel.setLayout( new GridLayout( 4, 2 ) );			
		
		JLabel tailsNumberLabel = new JLabel( Constants.TAILSNUMBER );
		panel.add( tailsNumberLabel );
	
		final JTextField tailsNumber = new JTextField();
		panel.add( tailsNumber );
		
		JLabel dustPercentLabel = new JLabel( Constants.DUSTPERCENT );
		panel.add( dustPercentLabel );
		
		final JTextField dustPercent = new JTextField();
		dustPercent.setPreferredSize( new Dimension( 30, 20 ) );
		panel.add( dustPercent );
		
		JLabel wallPercentLabel = new JLabel( Constants.WALLPERCENT );
		panel.add( wallPercentLabel );				
		
		final JTextField wallPercent = new JTextField();
		panel.add( wallPercent );
		
		JButton generate = new JButton( Constants.GENERATE );
		generate.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {						
				// TODO Auto-generated method stub
				String tailsNumberText = tailsNumber.getText();
				String dustPercentText = dustPercent.getText();
				String wallPercentText = wallPercent.getText();
				
				try
				{
					int tails = Integer.parseInt( tailsNumberText );
					int dust = Integer.parseInt( dustPercentText );
					int wall = Integer.parseInt( wallPercentText );
					
					if( dust > 60 || wall > 40 || tails > 1000 || dust+wall > 100 )
					{
						JOptionPane.showMessageDialog( null, Constants.ERRORPARAMETERS, Constants.ERROR, JOptionPane.ERROR_MESSAGE );					
					}
					
				}
				catch( NumberFormatException ex )
				{							
					JOptionPane.showMessageDialog( null, Constants.ERRORONNUMBER, Constants.ERROR, JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
		panel.add( generate );	
		
		frame.setContentPane( panel );
	}
}