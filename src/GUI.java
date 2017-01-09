import java.awt.*;
import javax.swing.*;

/***********************************************************************
 * Sets up the frame for the entire GUI.
 * 
 * @author TJ Zimmerman 
 * @version 1.01
 **********************************************************************/
public class GUI {

	/** An array used to hold the amount of timers created. */
	public static MyTimerPanel[] timers;

	/** JFrame that everything is placed on. */
	public static JFrame frame;

	/** Thing that everything is attached to. */
	public static JPanel panel;

	/** Current amount of timers the user wants. */
	public static String amountOfTimers = "0";

	/** Holds the title of the program. */
	public JLabel titleLabel;

	/** Used to spread out the labels on teh program. */
	public JLabel emptySpace;

	/** Holds the current StopWatch in the list for naming labels */
	public static int watchNumber = 1;


	/*******************************************************************
	 * Constructor is used to instantiate and add format all of the
	 * things used for the visual representation of the timer.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public GUI(){

		//Instantiates the frame for the GUI.
		frame = new JFrame("StopWatch Timer Program");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		//Prompts the user for the amount of StopWatches they want.
		amountOfTimers = JOptionPane.showInputDialog(null, 
				"How many timers would you like?");

		//Instantiates the frame and sets it to BoxLayout.
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		//If statement used to make sure inputed number is applicable.
		if (amountOfTimers.matches("[a-zA-Z]")){
			JOptionPane.showMessageDialog(null,
					"Numbers only, please!");
			amountOfTimers = "0";
		}
		else if (!amountOfTimers.matches("[a-zA-Z]")){
			timers = new MyTimerPanel
					[Integer.parseInt(amountOfTimers)];
		}

		//Instantiates the JLabels and gives then names.
		emptySpace = new JLabel(" ");
		titleLabel = new JLabel(
				"StopWatch Timer(s)                            ");

		//Creates and sets a font for the title to increase size. 
		Font labelFont = new Font("Arial", Font.BOLD,20);
		titleLabel.setFont(labelFont);

		//Adds the label to the center of the screen and adjusts it. 
		//Had to add empty space because BorderLayout.center didn't 
		//work.
		panel.add(emptySpace);
		panel.add(titleLabel);
		panel.add(emptySpace);

		//Makes sure that there are timers being created.
		if (Integer.parseInt(amountOfTimers) > 0){

			//Creates the timers in ascending order.
			for (MyTimerPanel k: timers){

				//Sets the title background color.
				panel.setBackground(new Color(219,219,219));

				//Adds the timers to the panel.
				k = new MyTimerPanel();
				panel.add(k);
				watchNumber ++;		

				//Customize the frame.
				frame.setSize(400,400);

				//Adds a layout to each watch respectively.
				frame.add(panel,BorderLayout.WEST);
				frame.pack();
				frame.setVisible(true);
			}
		}
	}


	/*******************************************************************
	 * Used to add additional timers to the GUI.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public static void addMore(){
		for (MyTimerPanel k: timers){
			panel.add(k);
		}
	}


	/*******************************************************************
	 * Used to create a new GUI.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public static void main(String[] args){
		new GUI();
	}
}