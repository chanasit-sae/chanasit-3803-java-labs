package saetkong.chanasit.lab4;
import java.util.Scanner;

public class NumberGuessingMethodGamesV2 {

  public static int[] result = new int[3];

  public static int getMaxInput(int min,Scanner scanner) {
    int value = scanner.nextInt();
    while(value < min) {
      System.out.println("The max value must be at least equal to the min value");
      System.out.print("Enter the max value:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  public static int getTriesInput() {
    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();
    while(value < 0)
    {
      System.out.println("The maximum number of tries must be greater than 0");
      System.out.print("Enter the maximum number of tries:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  static int genAnswer(int min,int max) {
    int result = min + (int)(Math.random() * (max - min) + 1);
    return result;
  }

  public static void playGames() {
    int min = result[0];
    int max = result[1];
    int maxTries = result[2];

    int[] userGuess = new int[maxTries];
      
    Scanner scanner = new Scanner(System.in);
    int tries = 1;

    int answer = genAnswer(min,max);
    System.out.println("Welcome to a number guessing game!");
    System.out.print("Enter an integer between " + min + " and " + max +":");
    int guess = scanner.nextInt();
    userGuess[0] = guess;
    String highLow = "";
    
    while(guess != answer) {
      if(tries >= maxTries){
        System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
        System.out.println("The answer is " + answer);
        break;
      }
      ++tries;

      if(guess > answer) highLow = "lower";
      if(guess < answer) highLow = "higher";

      System.out.println("Try a " + highLow + " number!!");
      System.out.print("Enter an integer between 1 and 10:");
      guess = scanner.nextInt();

      userGuess[tries-1] = guess;
    }

    String time;

    if(tries == 1) time = " time";
    else time = " times";

    Scanner postGame = new Scanner(System.in); 
    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);
    System.err.print("Enter \'a\' to list all guesses, \'g\' for a specific guess, or any other key to quit:");
    String seeGuess = postGame.nextLine().toLowerCase();
    if(seeGuess.equals("a"))
    {
      System.out.println(1);
      for(int i=0;i<tries;i++)
      {
        System.out.println("Guess " + tries + ": " + userGuess[i]);
      }
    }
    else if(seeGuess.equals("g"))
    {
      System.out.print("Enter the guess number:");
      int guessNum = postGame.nextInt();
      System.out.println("Guess " + guessNum + ": " + userGuess[guessNum-1]);
    }

    System.out.print("Want to play again? (Y or y):");
    String decision = postGame.next().toLowerCase();

    if(decision.equals("y")) { //ask user if they want to play again or not
      playGames();
      System.out.print("Want to play again? (Y or y):");
      decision = postGame.nextLine().toLowerCase(); //highercase or lowercase is fine for input
    }
    else {
        System.out.println("Thank you for playing our games. Bye!");
        System.exit(0);
      }
  }

  public static void configure() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the min value:");
    result[0] = scanner.nextInt();

    System.out.print("Enter the max value:");
    result[1] = getMaxInput(result[0],scanner);

    System.out.print("Enter the maximum number of tries:");
    result[2] = getTriesInput();
  }

  public static void main(String[] args)
  {
    configure();
    playGames();
  }
} 

