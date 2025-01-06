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
public class GuessGameV2 {
  Scanner scanner = new Scanner(System.in);
  private int min, max, maxTries, answer, attempts;

  /**Default constructor
   */
  public GuessGameV2() {
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
  public GuessGameV2(int min, int max, int maxTries) {
    configureGame(min,max,maxTries);
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
    int tmpMin = min;
    int tmpMax = max;
    int tmpMaxTries = maxTries;

    while(tmpMin > tmpMax) {
      System.out.println("Invalid input: max must be greater than or equal to min.");
      System.out.print("Enter the min value: ");
      tmpMin = scanner.nextInt();
      System.out.print("Enter the max value: ");
      tmpMax = scanner.nextInt();
    }

    while(tmpMaxTries < 1) {
      System.out.println("Invalid input: maxTries must be greater than 0.");
      System.out.print("Enter the maximum number of tries: ");
      tmpMaxTries = scanner.nextInt(); 
    } 

    this.min = tmpMin;
    this.max = tmpMax;
    this.maxTries = tmpMaxTries;
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
    System.out.println("Welcome to the Number Guessing Game V2!");
    do{
      System.out.print("Enter an integer between " +  min + " and " + max +  ": ");
      guess = scanner.nextInt();
      if(guess < min || guess > max) {
        System.out.println("Invalid input: guess must be between " + min + " and " + max);
        continue;
      }

      String highLow;
      if(guess > answer) highLow = "lower";
      else if(guess < answer) highLow = "higher";
      else break;

      System.out.println("Try a " + highLow + " number!");
      tryCNT++;

    }while(guess != answer && tryCNT <= maxTries);

    attempts = tryCNT;

    if(tryCNT > maxTries) 
    {
      System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
      return false;
    }
    else return true;
  }

  public String toString() {
    return "Game Configuration: [Min: " + min + ", Max: " + max + ", Max Tries: " + maxTries + ", Attemps: " + attempts + "]";
  }
  

  

}
