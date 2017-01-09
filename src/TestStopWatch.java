import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/***********************************************************************
 * Used to test the functionality of StopWatch with JUnit test cases for
 * error testing.
 * 
 * @author TJ Zimmerman
 * @version 1.01
 **********************************************************************/
public class TestStopWatch {


	/*******************************************************************
	 * Sets up the tests for the rest of the main class.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public class MyTest{
		@Test public void testConstructor(){}
		@Test public void test2(){}
	}


	@Test
	/*******************************************************************
	 * Tests the StopWatch constructor with arguments and strings.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testStringConstructor() {

		//Example tests that were provided to us.

		StopWatch s = new StopWatch(5, 10, 300);
		assertEquals(s.toString(), "5:10:300");

		s = new StopWatch("20:10:8");
		assertEquals(s.toString(), "20:10:008");

		s = new StopWatch("20:8");
		assertEquals(s.toString(), "0:20:008");

		s = new StopWatch("8");
		assertEquals(s.toString(), "0:00:008");

		//Begin my tests using the argument way.

		s = new StopWatch(10, 2, 3);
		assertEquals(s.toString(), "10:02:003");

		s = new StopWatch(17, 25);
		System.out.println(s);
		assertEquals(s.toString(), "0:17:025");

		s = new StopWatch(1000);
		System.out.println(s);
		assertEquals(s.toString(), "0:01:000");

		s = new StopWatch(10, 27, 3000);
		System.out.println(s);
		assertEquals(s.toString(), "10:30:000");

		s = new StopWatch(600, 100);
		System.out.println(s);
		assertEquals(s.toString(), "10:00:100");

		s = new StopWatch(0, 0, 1);
		System.out.println(s);
		assertEquals(s.toString(), "0:00:001");

		s = new StopWatch(0, 1, 0);
		System.out.println(s);
		assertEquals(s.toString(), "0:01:000");

		s = new StopWatch(1, 0, 0);
		System.out.println(s);
		assertEquals(s.toString(), "1:00:000");

		s = new StopWatch(10, 10);
		System.out.println(s);
		assertEquals(s.toString(), "0:10:010");

		s = new StopWatch(68954, 45, 382);
		System.out.println(s);
		assertEquals(s.toString(), "68954:45:382");

		s = new StopWatch(700);
		System.out.println(s);
		assertEquals(s.toString(), "0:00:700");

		s = new StopWatch(23, 0, 0);
		System.out.println(s);
		assertEquals(s.toString(), "23:00:000");

		s = new StopWatch(1, 0, 0);
		System.out.println(s);
		assertEquals(s.toString(), "1:00:000");

		s = new StopWatch(0, 14, 0);
		System.out.println(s);
		assertEquals(s.toString(), "0:14:000");

		//Begin my tests with a string instead of an argument.

		s = new StopWatch("11:111");
		assertEquals(s.toString(), "0:11:111");

		s = new StopWatch("03:008");
		assertEquals(s.toString(), "0:03:008");

		s = new StopWatch("0");
		assertEquals(s.toString(), "0:00:000");

		s = new StopWatch("56849:45:468");
		assertEquals(s.toString(), "56849:45:468");

		s = new StopWatch("21:17:3");
		assertEquals(s.toString(), "21:17:003");

		s = new StopWatch("10:9:8");
		assertEquals(s.toString(), "10:09:008");

		s = new StopWatch("2200");
		assertEquals(s.toString(), "0:02:200");

		s = new StopWatch("999");
		assertEquals(s.toString(), "0:00:999");

		s = new StopWatch("12:0:30");
		assertEquals(s.toString(), "12:00:030");

		s = new StopWatch("90");
		assertEquals(s.toString(), "0:00:090");

		s = new StopWatch("50:00:000");
		assertEquals(s.toString(), "50:00:000");

		s = new StopWatch("10:128:3");
		assertEquals(s.toString(), "12:08:003");

	}


	// Testing for exceptions must be done separately.
	// One at a time.
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	/*******************************************************************
	 * Passes the constructor negative minutes to see if it errors.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testConstructorWithNegMins() {
		StopWatch s = new StopWatch(-100,300);
	}


	// Testing for exceptions must be done separately.
	// One at a time.
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	/*******************************************************************
	 * Passes the constructor negative milliseconds to see if it errors.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testConstructorWithNegMilli() {
		StopWatch s = new StopWatch(-300);
	}


	@Test
	/*******************************************************************
	 * Tests the functionality of the add method in the StopWatch class 
	 * to see if it functions properly.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testAddMethod () {

		//Pass the add method a specific number to add.

		StopWatch s1 = new StopWatch(5,59,300);
		s1.add(2000);
		assertEquals (s1.toString(),"6:01:300");

		s1 = new StopWatch(5,59,300);
		StopWatch s5 = new StopWatch(2,2,300);
		s1.add(s5);
		System.out.println (s1);
		assertEquals (s1.toString(),"8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println (s1);
		assertEquals (s1.toString(),"8:16:600");

		s1 = new StopWatch(70, 30, 2);
		s1.add(8350);
		System.out.println(s1);
		assertEquals(s1.toString(), "70:38:352");

		s1 = new StopWatch(1, 1, 1);
		s1.add(10000);
		System.out.println(s1);
		assertEquals(s1.toString(), "1:11:001");

		s1 = new StopWatch(0);
		s1.add(1);
		System.out.println(s1);
		assertEquals(s1.toString(), "0:00:001");

		StopWatch s3 = new StopWatch(5, 00, 000);
		s3.add(2000);
		System.out.println(s3);
		assertEquals(s3.toString(), "5:02:000");

		s3 = new StopWatch(00, 01, 000);
		s3.add(6870);
		System.out.println(s3);
		assertEquals(s3.toString(), "0:07:870");

		s3 = new StopWatch(00, 00, 1);
		s3.add(8350);
		System.out.println(s3);
		assertEquals(s3.toString(), "0:08:351");

		s3 = new StopWatch(10, 0);
		s3.add(252);
		System.out.println(s3);
		assertEquals(s3.toString(), "0:10:252");

		//From here on we pass a string to the add method instead of a
		//number.

		s1 = new StopWatch(0, 00, 000);
		StopWatch s2 = new StopWatch(1, 1, 001);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "1:01:001");

		s1 = new StopWatch(1, 00, 000);
		s2 = new StopWatch(1, 1, 001);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "2:01:001");

		s1 = new StopWatch(0, 01, 000);
		s2 = new StopWatch(1, 1, 001);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "1:02:001");

		s1 = new StopWatch(0, 00, 001);
		s2 = new StopWatch(1, 1, 001);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "1:01:002");

		s1 = new StopWatch(0, 59, 100);
		s2 = new StopWatch(1, 2, 100);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "2:01:200");

		s1 = new StopWatch(15, 467);
		s2 = new StopWatch(100);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "0:15:567");

		s1 = new StopWatch(10);
		s2 = new StopWatch(1, 1, 000);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "1:01:010");

		//From here on we use the add method with a loop instead of a
		//string or a number.

		s1 = new StopWatch(1, 01, 100);
		for (int i = 0; i < 10000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "1:11:100");

		s1 = new StopWatch(0, 0, 0);
		for (int i = 0; i < 10100; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "0:10:100");

		s1 = new StopWatch(4, 04, 000);
		for (int i = 0; i < 250; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "4:04:250");

		s1 = new StopWatch(0, 00, 000);
		for (int i = 0; i < 1; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "0:00:001");

		s1 = new StopWatch(10, 000);
		for (int i = 0; i < 1000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "0:11:000");

		s1 = new StopWatch(0, 0, 0);
		for (int i = 0; i < 11111; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "0:11:111");

		s1 = new StopWatch(100);
		for (int i = 0; i < 10000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "0:10:100");

		s1 = new StopWatch(123, 45, 678);
		for (int i = 0; i < 22; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "123:45:700");
	}


	@Test 
	/*******************************************************************
	 * Tests the equals methods in the StopWatch class.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testEqual () {

		//Creates StopWatches for the use of the test class.
		StopWatch s1 = new StopWatch(0, 00, 000);
		StopWatch s2 = new StopWatch(1, 01, 001);
		StopWatch s3 = new StopWatch(0, 00, 000);
		StopWatch s4 = new StopWatch(1, 01, 001);
		StopWatch s5 = new StopWatch(2, 02, 002);
		StopWatch s6 = new StopWatch(3, 03, 003);
		StopWatch s7 = new StopWatch(2, 02, 002);
		StopWatch s8 = new StopWatch(3, 03, 003);
		StopWatch s9 = new StopWatch(4, 04, 004);
		StopWatch s10 = new StopWatch(4, 04, 004);
		StopWatch s11 = new StopWatch(0, 00, 000);
		StopWatch s12 = new StopWatch(5, 59, 300);
		StopWatch s13 = new StopWatch(6, 01, 200);
		StopWatch s14 = new StopWatch(5, 50, 200);
		StopWatch s15 = new StopWatch(5, 59, 300);

		//Creates objects for the use of the test class.
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		Object o5 = new Object();

		//Tests to see if the StopWatches are not equal.
		assertFalse(s12.equals(s13));
		assertFalse(s1.equals(s2));
		assertFalse(s5.equals(s11));
		assertFalse(s7.equals(s3));
		assertFalse(s7.equals(s1));
		assertFalse(s14.equals(s9));
		assertFalse(s3.equals(s4));

		//Tests to see if the StopWatches and objects are not equal.
		assertFalse(o1.equals(s1));
		assertFalse(o2.equals(s2));
		assertFalse(o3.equals(s3));
		assertFalse(o4.equals(s4));
		assertFalse(o5.equals(s5));

		//Tests to see if the StopWatches are equal.
		assertTrue(s12.equals(s15));
		assertTrue(s1.equals(s3));
		assertTrue(s2.equals(s4));
		assertTrue(s5.equals(s7));
		assertTrue(s8.equals(s6));
		assertTrue(s9.equals(s10));
		assertTrue(s11.equals(s1));	
	}


	@Test 
	/*******************************************************************
	 * Tests to see if StopWatches are equal, greater than, or less than
	 * each other.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testCompareTo () {

		//Creates the new StopWatches for use in the test method.
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);
		StopWatch s5 = new StopWatch(2, 02, 258);
		StopWatch s6 = new StopWatch(3, 3, 300);
		StopWatch s7 = new StopWatch(2, 02, 258);
		StopWatch s8 = new StopWatch(3, 3, 300);
		StopWatch s9 = new StopWatch(4, 40, 24);
		StopWatch s10 = new StopWatch(4, 40, 24);
		StopWatch s11 = new StopWatch(5, 05, 005);
		StopWatch s12 = new StopWatch(1, 01, 001);
		StopWatch s13 = new StopWatch(1, 01, 002);
		StopWatch s14 = new StopWatch(5, 50, 200);
		StopWatch s15 = new StopWatch(1, 01, 001);

		//Checks to see if the first given StopWatch is greater than
		//the second given StopWatch.
		assertTrue (s2.compareTo(s1) > 0);
		assertTrue(s9.compareTo(s7) > 0);
		assertTrue(s14.compareTo(s12) > 0);

		//Checks to see if the first given StopWatch is not greater
		//than the second given StopWatch.
		assertFalse(s5.compareTo(s8) > 0);
		assertFalse(s12.compareTo(s11) > 0);
		assertFalse(s13.compareTo(s5) > 0);

		//Checks to see if the first given StopWatch is less than the 
		//second given StopWatch.
		assertTrue(s13.compareTo(s5) < 0);
		assertTrue(s8.compareTo(s10) < 0);
		assertTrue (s3.compareTo(s1) < 0);

		//Checks to see if the first given StopWatch is not less than
		//the second given StopWatch.
		assertFalse(s2.compareTo(s1) < 0);
		assertFalse(s13.compareTo(s12) < 0);
		assertFalse(s11.compareTo(s12) < 0);

		//Checks to see if the first given StopWatch is equal to the 
		//second given StopWatch.
		assertTrue (s1.compareTo(s4) == 0);
		assertTrue(s12.compareTo(s15) == 0);
		assertTrue(s6.compareTo(s8) == 0);

		//Checks to see if the first given StopWatch is not equal to 
		//the second given StopWatch.
		assertFalse(s8.compareTo(s10) == 0);
		assertFalse(s13.compareTo(s5) == 0);
		assertFalse(s13.compareTo(s12) == 0);
	}


	@Test
	/*******************************************************************
	 * Tests the functionality of the constructor by setting it to zero
	 * and then making sure that the total milliseconds of the timer is
	 * zero.
	 * @param none
	 * @return none
	 * @throws Throwable is used for a checked exception.
	 ******************************************************************/
	public void defaultConstructorSetsTimeToZero() throws Throwable {
		StopWatch timer = new StopWatch();
		assertEquals(0, timer.totalMilliseconds());
	}


	@Test
	/*******************************************************************
	 * Checks the constructor to make sure the total milliseconds are 
	 * correct when given minutes, seconds, and milliseconds.
	 * @param none
	 * @return none
	 * @throws Throwable is used for a checked exception.
	 ******************************************************************/
	public void threeParameterConstructorCorrectlySetsTime()
			throws Throwable {
		StopWatch timer = new StopWatch(1, 2, 3);
		assertEquals(62003, timer.totalMilliseconds());
	}


	@Test
	/*******************************************************************
	 * Checks the constructor to make sure the total milliseconds are 
	 * correct when given seconds and milliseconds.
	 * @param none
	 * @return none
	 * @throws Throwable is used for a checked exception.
	 ******************************************************************/
	public void twoParameterConstructorCorrectlySetsTime()
			throws Throwable {
		StopWatch timer = new StopWatch(1,2);
		assertEquals(1002, timer.totalMilliseconds());
	}


	@Test
	/*******************************************************************
	 * Checks the constructor to make sure the total milliseconds are 
	 * correct when given milliseconds.
	 * @param none
	 * @return none
	 * @throws Throwable is used for a checked exception.
	 ******************************************************************/
	public void oneParameterConstructorCorrectlySetsTime()
			throws Throwable {
		StopWatch timer = new StopWatch(1);
		assertEquals(1, timer.totalMilliseconds());
	}


	@Test
	/*******************************************************************
	 * Checks to see that the increment method works correctly by 
	 * incrementing a given number of milliseconds by one.
	 * @param none
	 * @return none
	 * @throws Throwable is used for a checked exception.
	 ******************************************************************/
	public void incrementTest() throws Throwable{
		StopWatch s1 = new StopWatch(50);
		s1.inc();
		assertEquals(51, s1.totalMilliseconds());
	}


	@Test 
	/*******************************************************************
	 * Checks the save and load methods.
	 * @param none
	 * @return none
	 * @throws none
	 ******************************************************************/
	public void testLoa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     