package saetkong.chanasit.lab6;
import java.util.Scanner;

/**this is a class for game logic with a record tracking the gamelog which has the following method 
 *1.constructor for initializing all the values
 *2.getter setter for all the values
 *3.configureGame() for gives new values to variables
 *4.generateAnswer() for randomizing answer
 *5.playSingleGame() to handle the game logic
 *6.getGameLog() return the game logic
 *7.addGameRecord() for adding the current game to the record
 *8.getRecordCount() return record index
 *9.getGameRecords() return the game records array
 *
 *@author coded by chanasit saetkong
 *ID: 673040380-3
 *sec: 1
 */
public class GuessGameV3 extends GuessGameV2 {
  Scanner scanner = new Scanner(System.in);
  private static final int MAX_GAMES = 100;
  private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];
  private static int recordIndex = 0;
  private int[] guesses;
  private int guessCount;
  private boolean win;


  //constructor
  public GuessGameV3() { 
    super(); 
    guessCount = 0;
    win = false;
    guesses = new int[getMaxTries()];
  }

  //constructor with parameters
  public GuessGameV3(int min, int max, int MaxTries) {
    super(min,max,MaxTries);
    guessCount = 0;
    win = false;
    guesses = new int[getMaxTries()];
  }

  //initializing min max maxTries and guesses array
  public void configureGame(int min, int max, int maxTries) {
    super.configureGame(min,max,maxTries);
    guesses = new int[getMaxTries()];
    guessCount = 0;
    win = false;
  }

  //handles game logic
  public boolean playSingleGame() {
    int tryCNT = 1;
    int guess;
    generateAnswer(); 
    int answer = getAnswer();
    int min = getMin();
    int max = getMax();
    int maxTries = getMaxTries();
    System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
    do {
      System.out.print("Enter an integer between " + min + " and " + max + ": ");
      guess = scanner.nextInt();
      if (guess < getMin() || guess > max) {
        System.out.println("Invalid input: guess must be between " + min + " and " + max);
        continue;
      }

      guesses[guessCount] = guess;
      guessCount++;

      String highLow;
      if (guess > answer) highLow = "lower";
      else if (guess < answer) highLow = "higher";
      else {
        win = true;
        break;
      }

      System.out.println("Try a " + highLow + " number!");
      tryCNT++;

    } while (guess != answer && tryCNT <= maxTries);

    if (tryCNT > getMaxTries()) {
      System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
      return false;
    } else {
      System.out.println("Congratulations! You've guessed the number in " + guessCount + (guessCount > 1 ? " attempts. " : " attempt. "));
      this.win = true; 
      return true;
    }
  }

  //return gamelog as string with range, maxTries, guess count, result and the guesses player made
  public String getGameLog(){
    StringBuilder sb = new StringBuilder();
    sb.append("Range: [" + this.getMin() + "-" + this.getMax() + "], ");
    sb.append("Max Tries: " + this.getMaxTries() + ", ");
    sb.append("Attempts: " + this.guessCount + ", ");
    sb.append("Result: ").append(win ? "Win, " : "Lose, ");
    sb.append("Guesses: ");
    for (int i = 0; i < guessCount; i++) {
      sb.append(guesses[i]).append(", ");
    }
    return sb.toString();
  } 

  //add the played game to the record
  public static void addGameRecord(GuessGameV3 game) {
    if (recordIndex < MAX_GAMES) {
      gameRecords[recordIndex++] = game;
    } else {
      System.out.println("Game records are full!");
    }
  }

  //index getter
  public static int getRecordCount() {
    return recordIndex;
  }
  
  //array getter
  public static GuessGameV3[] getGameRecords() {
    return gameRecords;
  }

}
