package main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import util.constants.Constants;
import view.principal.GenerateRandomly;
import view.principal.OpenFileChooser;
import view.principal.PrincipalPanel;
import view.principal.SaveFileChooser;

public class Main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuItem load = new JMenuItem( Constants.OPEN );
	JMenuItem save = new JMenuItem( Constants.SAVE );
	JMenuItem generateRandomly = new JMenuItem( Constants.GENERATERANDOMLY );
	JMenuItem generateMap = new JMenuItem( Constants.GENERATEMAP );

	public Main() {
		// TODO Auto-generated constructor stub
		super( Constants.TITLE );

		PrincipalPanel panel = new PrincipalPanel( this );

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu( "File" );
		
		load.addActionListener( new OpenFileChooser( panel ) );
		save.addActionListener( new SaveFileChooser( panel ) );

		file.add( load );
		file.add( save );

		JMenu generate = new JMenu( "Generate" );
				
		generateRandomly.addActionListener( new GenerateRandomly() );

		generate.add( generateRandomly );
		generate.add( generateMap );		

		menuBar.add( file );
		menuBar.add( generate );
		
		this.setContentPane( panel );
		this.setResizable( false );
		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		this.setJMenuBar( menuBar );
		this.setSize(300, 300);		
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
