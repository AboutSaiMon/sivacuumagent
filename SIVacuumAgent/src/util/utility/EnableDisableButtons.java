package util.utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import view.principal.SaveFileChooserActionListener;
import view.principal.StartActionListener;

public class EnableDisableButtons {

	public static void enableDisableButtons( final Main principalFrame ) {
		principalFrame.getGenerateMap().setEnabled( false );
		
		principalFrame.getGenerateRandomly().setEnabled( false );
		
		principalFrame.getLoad().setEnabled( false );
		
		principalFrame.getSave().setEnabled( true );
		principalFrame.getSave().addActionListener( new SaveFileChooserActionListener( principalFrame ) );
		
		principalFrame.getStart().setEnabled( true );
		principalFrame.getStart().addActionListener( new StartActionListener( principalFrame, 0 ) );
		
		principalFrame.getMoveOneStep().setEnabled( true );
		principalFrame.getMoveOneStep().addActionListener( new StartActionListener( principalFrame, 1 ) );
		
		principalFrame.getBack().setEnabled( true );
		principalFrame.getBack().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Main( principalFrame.getEnvironment() );
				principalFrame.dispose();
			}
		});
		
		principalFrame.getDefineAgent().setEnabled( false );
		principalFrame.setResizable( true );
	}	
}
