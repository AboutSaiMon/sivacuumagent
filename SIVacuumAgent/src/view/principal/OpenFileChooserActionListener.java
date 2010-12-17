package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import main.Main;
import util.constants.Constants;
import util.utility.EnableDisableButtons;
import vacuumAgent.environment.VAEnvironment;
import view.EnvironmentDrawPanel.FloorPanel;
import file.FileManager;

public class OpenFileChooserActionListener implements ActionListener {

	Main frame;

	public OpenFileChooserActionListener(Main frame) {
		super();
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			int n = fileChooser.showOpenDialog(frame);

			if (n == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				String path = f.getCanonicalPath();

				VAEnvironment env = FileManager.load(path);
				
				frame.getEnvironment().setFloor( env.getFloor() );
				frame.getEnvironment().setVacuumAgentPosition( env.getVacuumAgentPosition() );
				
				FloorPanel floorPanel;
				
				floorPanel = new FloorPanel( frame.getEnvironment() );
				
				floorPanel.setEditable(false);
				frame.setSize(800, 600);
				frame.setContentPane(floorPanel);
				
				EnableDisableButtons.enableDisableButtons( frame );
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, Constants.ERROR,
					Constants.ERROR, JOptionPane.ERROR_MESSAGE);
		}
	}
}
