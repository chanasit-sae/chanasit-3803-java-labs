package saetkong.chanasit.lab4;
import java.util.Scanner;

//this is a NumberGuessingGames
//takes min, max, maximum amount of tries and user's answer
//and the program will tell you wether
//it's higher or lower than the answer
//and when you get it right it says:
//"Congratulations!"
//"You have tried (n) time "
//if user's tries exceeded it says
//You have tried (n) times. You ran out of guesses
//user can try again by enter 'Y'

public class NumberGuessingMethodGames {
  public static int[] result = new int[3];


  //takes max input
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

  //takes maximum amount of tries
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

  //randomize answer
  static int genAnswer(int min,int max) {
    int result = min + (int)(Math.random() * (max - min) + 1);
    return result;
  }

  //main game logic
  public static void playGames() {
    int min = result[0];//get value by functions called in configure()
    int max = result[1];
    int maxTries = result[2];
    Scanner scanner = new Scanner(System.in);
    int tries = 1;

    int answer = genAnswer(min,max);//get input min max 
    System.out.println("Welcome to a number guessing game!");
    System.out.print("Enter an integer between " + min + " and " + max +":");
    int guess = scanner.nextInt();
    String highLow = "";
    
    while(guess != answer) {
      if(tries >= maxTries){ //Tries exceed maximum tries
        System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
        System.out.println("The answer is " + answer);
        break;
      }
      ++tries;//count try

      if(guess > answer) highLow = "lower";
      if(guess < answer) highLow = "higher";

      System.out.println("Try a " + highLow + " number!!");
      System.out.print("Enter an integer between 1 and 10:");
      guess = scanner.nextInt();
    }

    String time;//'s' after "time" or not
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

  //get min, max, maximum tries
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

