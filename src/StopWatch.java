import java.io.*;
import java.util.Scanner;

/***********************************************************************
 * The class responsible for all of the logic behind the functionality 
 * of the program. 
 * 
 * @author TJ Zimmerman
 * @version 1.01
 **********************************************************************/
class StopWatch {

	/** Current value of the minutes on the StopWatch. */
	private int minutes;

	/** Current value of the seconds on the StopWatch. */
	private int seconds;

	/** Current value of the milliseconds on the StopWatch. */
	private int milliseconds;

	/** Current value of StopWatch-altering methods instantiated. */
	private int instCount = 0;

	/** Total count of instantiated StopWatches per use. */
	public static int tCount = 0;


	/*******************************************************************
	 * Default constructor sets the StopWatch to zero.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public StopWatch(){

		//Empty constructor has no provided parameters. Sets them to 0.
		this.minutes = 0;
		this.seconds = 0;
		this.milliseconds = 0;

		//Increment the instantiation count and pass value to total.
		instCount++;
		tCount = instCount;
	}


	/*******************************************************************
	 * A constructor that initializes the instance variables with the 
	 * provided parameters.
	 * @param minutes the current minutes on the StopWatch.
	 * @param seconds the current seconds on the StopWatch.
	 * @param milliseconds the current milliseconds on the StopWatch.
	 * @return none
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as one of the parameters.
	 ******************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {

		super();

		//Checks to see if the provided parameters are positive.
		if (minutes < 0 || seconds < 0 || milliseconds < 0){
			throw new IllegalArgumentException(
					"Negative numbers aren't allowed!");
		}

		//Passes all three parameters given.
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;

		//Increment the instantiation count and pass value to total.
		instCount++;
		tCount = instCount;

		convert();
	}


	/*******************************************************************
	 * A constructor that initializes the instance variables with the 
	 * provided parameters.
	 * @param seconds the current seconds on the StopWatch.
	 * @param milliseconds the current milliseconds on the StopWatch.
	 * @return none
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as one of the parameters.
	 ******************************************************************/
	public StopWatch(int seconds, int milliseconds) {

		//Checks to see if the provided parameters are positive.
		if (seconds < 0 || milliseconds < 0) {
			throw new IllegalArgumentException(
					"Negative numbers aren't allowed!");
		}

		//Sets the provided parameters to the StopWatch.
		this.minutes = 0;
		this.seconds = seconds;
		this.milliseconds = milliseconds;

		//Increment the instantiation count and pass value to total.
		instCount++;
		tCount = instCount;

		convert();
	}


	/*******************************************************************
	 * A constructor that initializes the instance variable with the 
	 * provided parameter.
	 * @param milliseconds the current milliseconds on the StopWatch.
	 * @return none
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as the parameter.
	 *******************************************************************/
	public StopWatch(int milliseconds) {

		//Checks to see if the provided parameter is positive.
		if (milliseconds < 0) {
			throw new IllegalArgumentException(
					"Negative numbers aren't allowed!");
		}

		//Sets the provided parameter to the StopWatch.
		this.minutes = 0;
		this.seconds = 0;
		this.milliseconds = milliseconds;

		//Increment the instantiation count and pass value to total.
		instCount++;
		tCount = instCount;

		convert();
	}


	/*******************************************************************
	 * A constructor that accepts a string as a parameter and sets the 
	 * StopWatch to the values inside the string.
	 * @param startTime the time that you want the timer to start.
	 * @return none
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as one of the parameters.
	 ******************************************************************/
	public StopWatch(String startTime){

		//Splits the String time where the colons are present.
		String[] tokens = startTime.split(":");

		//Parses according to string length and sets the timer values.
		if (tokens.length == 4){
			throw new IllegalArgumentException(
					"Only strings with 3, 2, or 1 paramaters are" +
							" allowed. Timer does not handle hours " +
					"or microseconds!");
		}
		if (tokens.length == 3){
			minutes = Integer.parseInt(tokens[0]);
			seconds = Integer.parseInt(tokens[1]);
			milliseconds = Integer.parseInt(tokens[2]);

		} 
		else if (tokens.length == 2){
			seconds = Integer.parseInt(tokens[0]);
			milliseconds = Integer.parseInt(tokens[1]);

		} 
		else{
			milliseconds = Integer.parseInt(tokens[0]);
		}

		convert();

		//Checks to make sure the provided values are positive.
		if (minutes < 0 || seconds < 0 || milliseconds < 0) {
			throw new IllegalArgumentException(
					"Negative numbers aren't allowed");
		}

		//Increment the instantiation count and pass value to total.
		instCount++;
		tCount = instCount;

		convert();
	}


	/*******************************************************************
	 * Getter to retrieve the current minutes of the StopWatch.
	 * @param none
	 * @return minutes current minutes held by the current StopWatch.
	 * @throws none
	 ******************************************************************/
	public int getMinutes() {
		return minutes;
	}


	/*******************************************************************
	 * Setter that sets the current minutes to the provided value.
	 * @param minutes sets the current minutes to the provided value.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	/*******************************************************************
	 * Getter that gets the current seconds of the StopWatch.
	 * @param none
	 * @return seconds returns the seconds held by the current 
	 * StopWatch.
	 * @throws none
	 ******************************************************************/
	public int getSeconds() {
		return seconds;
	}


	/*******************************************************************
	 * Setter that sets the current seconds to the provided value.
	 * @param seconds sets the current seconds to the provided value.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}


	/*******************************************************************
	 * Getter that retrieves the current milliseconds of the StopWatch.
	 * @param none
	 * @return milliseconds returns the milliseconds held by the 
	 * current StopWatch.
	 * @throws none
	 ******************************************************************/
	public int getMilliseconds() {
		return milliseconds;
	}


	/*******************************************************************
	 * Setter that sets the current milliseconds to the provided
	 * parameter.
	 * @param milliseconds sets the current milliseconds to the 
	 * provided value.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}


	/*******************************************************************
	 * Returns true of this object is the same as the StopWatch.
	 * @param other the object that you want to compare the current 
	 * StopWatch to.
	 * @return isTrue boolean that shows whether or not the two 
	 * StopWatches are equal.
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as one of the parameters.
	 ******************************************************************/
	public boolean equals(Object other){
		StopWatch sw = (StopWatch) other;

		if ( sw.minutes < 0 || sw.seconds < 0 || sw.milliseconds <0){
			throw new IllegalArgumentException(
					"Negative arguments are not allowed");
		}

		this.totalMilliseconds();
		sw.totalMilliseconds();
		return (this.milliseconds == sw.milliseconds);
	}


	/*******************************************************************
	 * Returns true if this StopWatch is the same as the current 
	 * StopWatch.
	 * @param other the StopWatch to compare against.
	 * @return isTrue boolean that shows whether the two StopWatches
	 * are equal.
	 * @throws IllegalArgumentException if someone attempts to input a
	 * negative number as one of the parameters.
	 ******************************************************************/
	public boolean equals(StopWatch other){
		boolean isTrue = false;

		//Makes sure the provided values are positive.
		if (other.minutes < 0 || other.seconds < 0 || 
				other.milliseconds < 0){
			throw new IllegalArgumentException(
					"Negative numbers aren't allowed!");
		}

		//Checks to see if the two StopWatches are equal.
		if (minutes == other.getMinutes()){
			if (seconds == other.getSeconds()){
				if (milliseconds == other.getMilliseconds()){
					isTrue = true;
				}
			}
		}

		return isTrue;
	}


	/*******************************************************************
	 * Returns true if s1 is exactly the same as s2.
	 * @param s1 the first StopWatch to be used in the  comparison.
	 * @param s2 the seconds StopWatch to be used in the comparison.
	 * @return isTrue boolean that shows whether the two are equal.
	 * @throws none
	 ******************************************************************/
	public static boolean equals(StopWatch s1, StopWatch s2){
		boolean isTrue = false;

		//Checks to see if the provided StopWatches are equal.
		if (s1.getMinutes() == s2.getMinutes()){
			if (s1.getSeconds() == s2.getSeconds()){
				if (s1.getMilliseconds() == s2.getMilliseconds()){
					isTrue = true;
				}
			}
		}

		return isTrue;
	}


	/*******************************************************************
	 * Takes the current time stamp and converts it into milliseconds.
	 * @param none
	 * @return totalMilliseconds the total milliseconds on the timer.
	 ******************************************************************/
	public int totalMilliseconds(){
		int totalMilliseconds;

		//Converts the minutes and seconds into milliseconds.
		totalMilliseconds = (minutes * 60000) + (seconds * 1000)
				+ (milliseconds);

		return totalMilliseconds;
	}


	/*******************************************************************
	 * Compares the current StopWatch with the provided StopWatch.
	 * @param other holds the StopWatch object to be compared to.
	 * @return returnNum which StopWatch is larger.
	 * @throws none
	 ******************************************************************/
	public int compareTo(StopWatch other){
		int returnNum = 3;

		//Checks to see which of the two StopWatches has a larger time.
		if (this.totalMilliseconds() > 
		other.totalMilliseconds()){
			returnNum = 1;
		}
		else if (this.totalMilliseconds() < 
				other.totalMilliseconds()){
			returnNum = -1;
		}
		else if (this.totalMilliseconds() == 
				other.totalMilliseconds()){
			returnNum =  0;
		}

		return returnNum;
	}


	/*******************************************************************
	 * Used to change the provided values into an  applicable time 
	 * format by incrementing seconds up with the provided milliseconds
	 * are greater than 1000, among other similar features.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void convert(){ 
		if (this.milliseconds >= 1000) {
			this.seconds += this.milliseconds / 1000;
			this.milliseconds = this.milliseconds % 1000;

		}
		if (this.seconds >= 60) {
			this.minutes += this.seconds / 60;
			this.seconds = this.seconds % 60;

		}
	}


	/*******************************************************************
	 * Adds the number of milliseconds to this StopWatch object.
	 * @param milliseconds holds the milliseconds to be added to the 
	 * timer.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void add(int milliseconds){
		this.milliseconds += milliseconds;

		convert();
	}


	/*******************************************************************
	 * Adds a StopWatch to the current StopWatch. Combining their time 
	 * stamps.
	 * @param other represents the StopWatch time stamp to be added to
	 * the current StopWatch timer.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void add(StopWatch other){
		this.minutes += other.getMinutes();
		this.seconds += other.getSeconds();
		this.milliseconds += other.getMilliseconds();

		convert();
	}


	/*******************************************************************
	 * Increments the current StopWatch by 1 second.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void inc(){

		this.milliseconds ++;

		convert();
	}


	/*******************************************************************
	 * Returns the total amount of instantiations per timer.
	 * @param none
	 * @return tCount total amount of time stamp edits occurred.
	 * @throws none
	 ******************************************************************/
	public static int getNumberCreated(){
		return tCount;
	}


	/*******************************************************************
	 * Saves the "this" CountDownTimer to a file. 
	 * @param fileName Name of the file to store the objects in.
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void save(String fileName) {

		PrintWriter myout;

		//Used to try and write the parameters to a save file.
		try {
			myout = new PrintWriter(fileName);

			myout.println(minutes);
			myout.println(seconds);
			myout.println(milliseconds);

			myout.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	/*******************************************************************
	 * Loads a saved StopWatch time stamp.
	 * @param fileName name of the file that contains object.
	 * @return none
	 * @throws none
	 *******************************************************************/
	public void load(String fileName) {
		Scanner sc;

		//Try and load the parameters from a save file.
		try {
			sc = new Scanner(new File(fileName));
			minutes = sc.nextInt();
			seconds = sc.nextInt();
			milliseconds = sc.nextInt();

		} catch (FileNotFoundException e) {
			System.out.println("The file" + fileName + 
					" can't be found.");
		}
	}	

	/*******************************************************************
	 * Used to set the current StopWatch back to 0.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void reset(){
		minutes = 0;
		seconds = 0;
		milliseconds=0;
		tCount = 0;
		instCount = 0;

	}


	/*******************************************************************
	 * Returns a string that represents a StopWatch with the following 
	 * format "1:23:456".
	 * @param none
	 * @return time formatted time in string form.
	 * @throws none
	 ******************************************************************/
	public String toString(){
		/** Used to represent the total time.  */
		String time;

		/** Used to represent the minutes in the String.  */
		String tempMin;

		/**  Used to represent the seconds in the String. */
		String tempSec;

		/**  Used to represent the milliseconds. */
		String tempMill;

		//Check the numbers in the parameters and forms a string 
		//accordingly.
		if (minutes == 0){
			tempMin = "0";
		}
		else{
			tempMin = "" + minutes;
		}

		if (seconds < 10){
			tempSec = "0" + seconds;
		}
		else{
			tempSec = "" + seconds;
		}

		if (milliseconds < 10){
			tempMill = "00" + milliseconds;
		}
		else if (milliseconds < 100){
			tempMill = "0" + milliseconds;
		}		
		else{
			tempMill = "" + milliseconds;
		}

		time = (tempMin + ":" + tempSec + ":" + tempMill);

		return time;
	}

	/*******************************************************************
	 * Used to test the functionality of this program.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public static void main(String[] args){
		StopWatch s = new StopWatch("20:10:8");
		System.out.println("Time: " + s);

		s = new StopWatch("20:8");
		System.out.println("Time: " + s);

		s = new StopWatch("8");
		System.out.println("Time: " + s);

		StopWatch s1 = new StopWatch(20, 2, 200);
		System.out.println("Time: " + s1);

		if (!StopWatch.equals (s, s1))
			System.out.println("s is Not equal to s1");

		s1.add(1000);
		System.out.println("Time: " + s1);

		StopWatch s2 = new StopWatch(40, 10, 20);
		s2.add(100);
		for (int i = 0; i < 4000; i++)
			s2.inc();
		System.out.println("Time: " + s2);

		s = new StopWatch("50:40:42");
		System.out.println("Time: " + s);

		s = new StopWatch("2:8:346");
		System.out.println("Time: " + s);

		s = new StopWatch("456:2:0");
		System.out.println("Time: " + s);

		s = new StopWatch("20:8");
		System.out.println("Time: " + s);

		s = new StopWatch("4:43");
		System.out.println("Time: " + s);

		s = new StopWatch("40:362");
		System.out.println("Time: " + s);

		s = new StopWatch("8");
		System.out.println("Time: " + s);

		s = new StopWatch("42");
		System.out.println("Time: " + s);

		s = new StopWatch("953");
		System.out.println("Time: " + s);

		StopWatch s3 = new StopWatch(20, 2, 200);
		System.out.println("Time: " + s3);

		s1.add(1000);
		System.out.println("Time: " + s1);

		StopWatch s4 = new StopWatch(40, 10, 20);
		s4.add(100);
		for (int i = 0; i < 4000; i++) {
			s4.inc();
		}
		System.out.println("Time: " + s4);
	}
}