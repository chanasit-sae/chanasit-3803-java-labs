package saetkong.chanasit.lab4;
import java.util.Scanner;

public class NumberGuessingMethodGames {

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
    Scanner scanner = new Scanner(System.in);
    int tries = 1;

    int answer = genAnswer(min,max);
    System.out.println("Welcome to a number guessing game!");
    System.out.print("Enter an integer between " + min + " and " + max +":");
    int guess = scanner.nextInt();
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
    }

    String time;

    if(tries == 1) time = " time";
    else time = " times";

    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);
    
    System.out.print("Want to play again? (Y or y):");
    Scanner repeat = new Scanner(System.in); 
    String decision = repeat.nextLine().toLowerCase();

    if(decision.equals("y")) { //ask user if they want to play again or not
      playGames();
      System.out.print("Want to play again? (Y or y):");
      decision = repeat.nextLine().toLowerCase(); //highercase or lowercase is fine for input
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

