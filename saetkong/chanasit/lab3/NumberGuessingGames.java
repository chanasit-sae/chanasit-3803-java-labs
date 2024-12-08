package saetkong.chanasit.lab3;
import java.util.Scanner;

public class NumberGuessingGames {

  public static int getInput(Scanner scanner) {
    return scanner.nextInt();
  }

  public static int getMaxInput(int min,Scanner scanner) {
    int value = scanner.nextInt();
    while(value < min) {//value can't be less than min
      System.out.println("The max value must be at least equal to the min value");
      System.out.print("Enter the max value:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  public static int getTriesInput(Scanner scanner) {
    int value = scanner.nextInt();
    while(value < 0)//number of maximum tries can't be 0 or lower
    {
      System.out.println("The maximum number of tries must be greater than 0");
      System.out.print("Enter the mYou have tried 5 times. You ran out of guessesaximum number of tries:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  public static void runGame(int min,int max, int maxTries,Scanner scanner)
  {
    int tries = 1;//initialize user's try as 1

    System.out.println("Welcome to a number quessing game!");
    int answer = min + (int)(Math.random() * (max - min) + 1); //randomize answer

    System.out.print("Enter an integer between " + min + " and " + max + ":");
    int guess = getInput(scanner);
    String highLow = "";

    while(guess != answer) {
      if(tries >= maxTries) //user's tries exceed maximum try
      {
        System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
        System.out.println("The answer is " + answer);
        return;
      }
      ++tries;//count try

      if(guess > answer) highLow = "lower";//tell user higher or lower
      if(guess < answer) highLow = "higher";

      System.out.println("Try a " + highLow + " number!!");
      System.out.print("Enter an integer between 1 and 10:");
      guess = getInput(scanner);
    }

    String time;

    if(tries == 1) time = " time"; //decide if there's an 's' after the word "time"
    else time = " times";

    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);
    return;
  }

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the min value:");
    int min = getInput(scanner);

    System.out.print("Enter the max value:");
    int max = getMaxInput(min,scanner);

    System.out.print("Enter the maximum number of tries:");
    int maxTries = getTriesInput(scanner);

    runGame(min,max,maxTries,scanner);
    System.out.print("Want to play again? (Y or y):");
    Scanner repeat = new Scanner(System.in); 
    String decision = repeat.nextLine().toLowerCase();

    while(decision.equals("y")) { //ask user if they want to play again or not
      runGame(min,max,maxTries,scanner);
      System.out.print("Want to play again? (Y or y):");
      decision = repeat.nextLine().toLowerCase(); //highercase or lowercase is fine for input
    }
    System.out.println("Thank you for playing our games. Bye!");//exit if answer is not 'y'
  }
} 

