package saetkong.chanasit.lab3;
import java.util.Scanner;

//this is a NumberGuessingGame with a Configurable game property
//the program takes input of min, max and maximum number of tries
//and the program will tell you wether it's higher or lower 
//and when you get it right it says:
//"Congratulations!"
//"You have tried (n) time "
//if user tries exeeded the maximum try it says
//You have tried (maximum try) times. You ran out of guesses

public class ConfigurableNumberGuessingGame {

  public static int getInput(Scanner scanner) {
    return scanner.nextInt();
  }

  public static int getMaxInput(int min,Scanner scanner) {
    int value = scanner.nextInt();
    while(value < min) { //this input can't be smaller than min
      System.out.println("The max value must be at least equal to the min value");
      System.out.println("Enter the max value:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  public static int getTriesInput(Scanner scanner) {
    int value = scanner.nextInt();
    while(value < 0) { //number of tries can't be 0 or negative
      System.out.println("The maximum number of tries must be greater than 0");
      System.out.print("Enter the maximum number of tries:");
      scanner = new Scanner(System.in);
      value = scanner.nextInt();
    }
    return value;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tries = 1;//initialize number that user have tried

    System.out.print("Enter the min value:");
    int min = getInput(scanner);

    System.out.print("Enter the max value:");
    int max = getMaxInput(min,scanner);

    System.out.print("Enter the maximum number of tries:");
    int maxTries = getTriesInput(scanner);

    System.out.println("Welcome to a number quessing game!");
    int answer = min + (int)(Math.random() * (max - min) + 1); //randomize answer

    System.out.print("Enter an integer between " + min + " and " + max + ":");
    int guess = getInput(scanner);
    String highLow = "";

    while(guess != answer) {
      if(tries >= maxTries) {//user's tries exceed maximum try
        System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
        System.out.print("The answer is " + answer);
        System.exit(0);
      }
      ++tries; //count user's try

      if(guess > answer) highLow = "lower";//tell the user higher or lower
      if(guess < answer) highLow = "higher";

      System.out.println("Try a " + highLow + " number!!");
      System.out.print("Enter an integer between 1 and 10:");
      guess = getInput(scanner);
      
    }

    String time;

    if(tries == 1) time = " time"; //decide if the word "time" has 's' or not
    else time = " times";

    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);

  }
} 
