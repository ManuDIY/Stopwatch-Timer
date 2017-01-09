import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/***********************************************************************
 * Used to create an interface for the StopWatch
 * Timer.
 * 
 * @TJ Zimmerman
 * @1.01
 **********************************************************************/
@SuppressWarnings("serial")
public class MyTimerPanel extends JPanel{

	/** Represents the current StopWatch. */
	private JLabel clockLabel;

	/** Formats things on the panel. */
	private JLabel whiteSpace;

	/** Represents whether or not the StopWatch is being used. */
	private JLabel stopGo;

	/** The current number of StopWatches. */
	private JLabel swNumber;

	/** Starts the StopWatch. */
	private JButton start;

	/** Stops the StopWatch. */
	private JButton stop;

	/** Resets the StopWatch. */
	private JButton reset;

	/** A StopWatch object. */
	private StopWatch sw;

	/** A swing timer used to control the time. */
	private Timer javaTimer;

	/** Used to listen for swing timer updates. */
	private TimerListener timer;

	/** Used to hold the buttons on the panel. **/
	private JPanel buttonPanel;

	/** Used to hold the menu. */
	static JMenuBar menuBar;

	/** Used to hold the menu options. */
	static JMenu menu;

	/** A menu option to close the program. */
	static JMenuItem quitItem;

	/** Used to add StopWatches. */
	static JMenuItem newItem;

	/** Used to control the timer icon. */
	String stopName = "Stop.jpg";

	/** Used to control the timer icon. */
	String goName = "Go.jpg";


	/*******************************************************************
	 * Sets up the layout of the MyTimerPanel.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public MyTimerPanel(){

		//Sets up the Menu.
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menuBar.add(menu);
		GUI.frame.setJMenuBar(menuBar);

		//Instantiates the menu items and sets their font.
		quitItem = new JMenuItem("Quit Program");
		newItem = new JMenuItem("New Timer");
		Font menuFont = new Font("Arial",Font.PLAIN,12);
		newItem.setFont(menuFont);
		quitItem.setFont(menuFont);

		//Adds the menu options to the menu.
		menu.add(newItem);
		menu.add(quitItem);

		//Instantiates the new StopWatches.
		sw = new StopWatch(0,0,0);

		//Instantiates the JLabels.
		clockLabel = new JLabel(sw.toString());
		stopGo = new JLabel("");
		whiteSpace = new JLabel("|   ");
		swNumber = new JLabel("Stopwatch " + 
				GUI.watchNumber + ")   | ");

		//Adds the labels to the panel.
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(stopGo);
		this.add(swNumber,BorderLayout.WEST);
		this.add(whiteSpace);
		this.add(clockLabel,BorderLayout.WEST);

		//Instantiates the listener to read the swing timer updates.
		timer = new TimerListener();

		//Instantiates the swing timer
		javaTimer = new Timer(0,timer);

		//Instantiates the panel for the buttons and sets the layout.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,
				BoxLayout.X_AXIS));

		//Instantiates the buttons.
		start = new JButton ("Start");
		stop = new JButton ("Stop");
		reset = new JButton ("Reset");

		//Adds a box to the panel.
		add(Box.createRigidArea(new Dimension(0,20)));

		//Adds the buttons to the buttonPanel.
		buttonPanel.add(whiteSpace);
		buttonPanel.add(start);
		buttonPanel.add(stop);
		buttonPanel.add(reset);

		//Instantiates the listener for the buttons.
		TimerListener2 listener = new TimerListener2();

		//Add the listener to the buttons and menu options.
		start.addActionListener(listener);
		stop.addActionListener(listener);
		reset.addActionListener(listener);
		quitItem.addActionListener(listener);
		newItem.addActionListener(listener);;

		//Adds the ButtonPanel to the frame and sets a border to it.
		this.add(buttonPanel,BorderLayout.BEFORE_FIRST_LINE);
		this.setBorder(BorderFactory.createLineBorder
				(Color.LIGHT_GRAY,2));

		//Sets button enabled status.
		start.setEnabled(true);
		stop.setEnabled(false);
		reset.setEnabled(false);

		//Used to set the icon color on the StopWatch.
		try {
			stopGo.setIcon(new ImageIcon(ImageIO.read(new File
					(stopName))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	/*******************************************************************
	 * Used to check the swing Timer for updates on the current time.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	private class TimerListener implements ActionListener {

		/**************************************************************
		 * Checks to see what actions are occurring.
		 *************************************************************/
		public void actionPerformed(ActionEvent e) {
			//Increments the timer every time it's called.
			sw.inc();

			clockLabel.setText(sw.toString());
		}

	}


	/*******************************************************************
	 * Used to listen for the click of one of the action buttons or 
	 * menu options on the  GUI.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	private class TimerListener2 implements ActionListener {

		/***************************************************************
		 * Checks to see what actions are occurring.
		 **************************************************************/
		public void actionPerformed(ActionEvent e) {
			JComponent source = (JComponent) e.getSource();

			//Used to check which button logic should be called.
			if (source == start) {
				javaTimer.start();
				start.setEnabled(false);
				stop.setEnabled(true);
				reset.setEnabled(true);

				//Used to set the icon color on the StopWatch.
				try {
					stopGo.setIcon(new ImageIcon(
							ImageIO.read(new File(goName))));
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} 
			else if (source == stop) {
				javaTimer.stop();
				start.setEnabled(true);
				stop.setEnabled(false);

				//Used to set the icon color on the StopWatch.
				try {
					stopGo.setIcon(new ImageIcon(
							ImageIO.read(new File(stopName))));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} 
			else if (source == reset) {
				javaTimer.stop();
				sw = new StopWatch();
				clockLabel.setText(sw.toString());
				start.setEnabled(true);
				stop.setEnabled(false);
				reset.setEnabled(false);

				//Used to set the icon color on the StopWatch.
				try {
					stopGo.setIcon(new ImageIcon(
							ImageIO.read(new File(stopName))));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} 
			else if (source == quitItem){
				System.exit(1);

			} 
			else if (source == newItem){
				new GUI();
			}
		}
	}
}