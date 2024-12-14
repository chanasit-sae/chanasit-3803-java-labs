package coe.java.demos.c4;
/**
 * This program is to illustrate the use of Java doc author Chanasit Saetkong 
 * @version 1.0, 06/25/09
 *
 */
public class JavadocDemo {

	/**
	 * This method adds two integers
	 * @param m is the first integer  
	 * @param n is the second integer
	 * @return the addition of two given integers
	 */
	public static int add(int m, int n) {
		int result = m +n;
		return result;
	}
	/**
	 * The main method of the program
	 * @param args Program arguments
	 */
	public static void main(String[] args) {
		System.out.println("A very simple program with Javadoc");

	}
}
