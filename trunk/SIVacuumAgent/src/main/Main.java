package main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import SolutionThree.VAagentThree;
import SolutionTwo.VAagentTwo;

import solutionOne.robot.VAagetnOneJGraphT;
import util.constants.Constants;
import vacuumAgent.VAAction;
import vacuumAgent.VAAgent;
import vacuumAgent.VAPercept;
import vacuumAgent.VAAction.VAActionType;
import vacuumAgent.VATile.VATileStatus;
import vacuumAgent.environment.VAEnvNonObservable;
import vacuumAgent.environment.VAEnvObservable;
import vacuumAgent.environment.VAEnvSemiObservable;
import vacuumAgent.environment.VAEnvironment;
import view.principal.DefineAgentActionListener;
import view.principal.GenerateMap;
import view.principal.GenerateRandomlyActionListener;
import view.principal.OpenFileChooserActionListener;
import view.principal.PrincipalPanel;
import framework.Action;
import framework.Percept;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuItem load = new JMenuItem(Constants.OPEN);
	JMenuItem save = new JMenuItem(Constants.SAVE);
	JMenuItem generateRandomly = new JMenuItem(Constants.GENERATERANDOMLY);
	JMenuItem generateMap = new JMenuItem(Constants.GENERATEMAP);
	JMenuItem defineAgent = new JMenuItem(Constants.DEFINEAGENT);
	JMenuItem start = new JMenuItem(Constants.START);
	JMenuItem moveOneStep = new JMenuItem(Constants.MOVEONESTEP);
	JMenuItem help = new JMenuItem(Constants.HELP);

	VAEnvironment environment;

	public Main(VAEnvironment environment) {
		// TODO Auto-generated constructor stub
		super(Constants.TITLE);

		this.environment = environment;

		PrincipalPanel panel = new PrincipalPanel(this);

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");

		load.addActionListener(new OpenFileChooserActionListener(this));
		save.setEnabled(false);

		file.add(load);
		file.add(save);

		JMenu generate = new JMenu("Generate");

		generateRandomly.addActionListener(new GenerateRandomlyActionListener(
				this));
		generateMap.addActionListener(new GenerateMap(this));

		generate.add(generateRandomly);
		generate.add(generateMap);

		JMenu agent = new JMenu("Agent");

		defineAgent.addActionListener(new DefineAgentActionListener(this));
		agent.add(defineAgent);

		JMenu action = new JMenu("Action");

		start.setEnabled(false);
		moveOneStep.setEnabled(false);

		action.add(start);
		action.add(moveOneStep);

		JMenu about = new JMenu("About");
		about.add(help);

		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, Constants.INFORMATION,
						Constants.HELP, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuBar.add(file);
		menuBar.add(generate);
		menuBar.add(agent);
		menuBar.add(action);
		menuBar.add(about);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setJMenuBar(menuBar);
		this.setSize(300, 200);
		this.setLocation(300, 300);
	}

	public JMenuItem getLoad() {
		return load;
	}

	public void setLoad(JMenuItem load) {
		this.load = load;
	}

	public JMenuItem getSave() {
		return save;
	}

	public void setSave(JMenuItem save) {
		this.save = save;
	}

	public JMenuItem getGenerateRandomly() {
		return generateRandomly;
	}

	public void setGenerateRandomly(JMenuItem generateRandomly) {
		this.generateRandomly = generateRandomly;
	}

	public JMenuItem getGenerateMap() {
		return generateMap;
	}

	public void setGenerateMap(JMenuItem generateMap) {
		this.generateMap = generateMap;
	}

	public VAEnvironment getEnvironment() {
		return environment;
	}

	public void setEnvironment(VAEnvironment environment) {
		this.environment = environment;
	}

	public JMenuItem getStart() {
		return start;
	}

	public void setStart(JMenuItem start) {
		this.start = start;
	}

	public JMenuItem getMoveOneStep() {
		return moveOneStep;
	}

	public void setMoveOneStep(JMenuItem moveOneStep) {
		this.moveOneStep = moveOneStep;
	}

	public JMenuItem getDefineAgent() {
		return defineAgent;
	}

	public void setDefineAgent(JMenuItem defineAgent) {
		this.defineAgent = defineAgent;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point point = new Point(0, 0);

		int choise = 2;
		VAAgent a = null;
		VAEnvironment state = null;

		switch (choise) {
		case 1:
			VAagetnOneJGraphT a0 = new VAagetnOneJGraphT(100);
			VAEnvObservable state0 = new VAEnvObservable(a, point, null);

			a = a0;
			state = state0;
			break;
		case 2:
			VAagentTwo a1 = new VAagentTwo(100);
			VAEnvSemiObservable state1 = new VAEnvSemiObservable(a1, point, null);

			a = a1;
			state = state1;
			break;
		case 3:
			VAagentThree a2 = new VAagentThree(100);
			VAEnvNonObservable state2 = new VAEnvNonObservable(a2, point, null);

			a = a2;
			state = state2;
			break;
		default:
			break;
		}

		new Main(state);
	}
}
