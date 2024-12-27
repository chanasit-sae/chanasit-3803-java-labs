package saetkong.chanasit.lab6;
import java.util.Scanner;

/**this is a class for game logic which has the following method 
*1.constructor for initializing all the values
*2.getter setter for all the values
*3.configureGame() for gives new values to variables
*4.generateAnswer() for randomizing answer
*5.playSingleGame() to handle the game logic
*
*@author coded by chanasit saetkong
*ID: 673040380-3
*sec: 1
*/
public class GuessGame {
  Scanner scanner = new Scanner(System.in);
  private int min, max, maxTries, answer, attempts;

  /**Default constructor
   */
  public GuessGame() {
    this.min = 1;
    this.max = 100;
    this.maxTries = 10;
    this.answer = 0;
    this.attempts = 0;
  }

  /**constructor with parameters
   * @param min the minimum value of the answer
   * @param max the maximum value of the answer
   * @param maxTries the maximum number of tries
   * */
  public GuessGame(int min, int max, int maxTries) {
    this.min = min;
    this.max = max;
    this.maxTries = maxTries;
    this.answer = 0;
    this.attempts = 0;
  }


  /** min getter 
   * @return min
   * */
  public int getMin() {return min;}
  /** min setter
   * @param min 
   */
  public void setMin(int min) {this.min = min;}

  /**max getter
   * @return max
   * */
  public int getMax() {return max;}
  /**max setter
   * @param setMaxTries
   */
  public void setMax(int max) {this.max = max;}

  /**get maximum number of try*/
  public int getMaxTries() {return maxTries;}
  /**max setter
  * @param setMaxTries
  */
  public void setMaxTries(int min) {this.maxTries = maxTries;}

  /**cofigure min max and maxTries
   *@param min
   *@param max
   *@param maxTries
   */
  public void configureGame(int min, int max, int maxTries) {
    this.min = min;
    this.max = max;
    this.maxTries = maxTries;
  }

  /**randomize answer between min and max
   * @return answer
   */
  public void generateAnswer() {
    answer = min + (int)(Math.random() * (max-min) + 1);
  }


  /** handles game logics
   *get input scanner and tell player whether the guess was too high or too low.
   *
   *@return true if the player guesses the number correctly; false otherwise
   */
  public boolean playSingleGame() {
    int tryCNT = 1;
    int guess;
    generateAnswer();
    System.out.println("Welcome to the Number Guessing Game!");
    do{
      System.out.print("Enter an integer between " +  min + " and " + max +  ": ");
      guess = scanner.nextInt();

      String highLow;
      if(guess > answer) highLow = "lower";
      else if(guess < answer) highLow = "higher";
      else break;

      System.out.println("Try a " + highLow + " number!");
      tryCNT++;

    }while(guess != answer && tryCNT <= maxTries);
 

    if(tryCNT > maxTries) 
    {
      System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
      return false;
    }
    else return true;
  }

}
