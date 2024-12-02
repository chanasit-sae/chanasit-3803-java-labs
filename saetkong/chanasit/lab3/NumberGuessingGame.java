package saetkong.chanasit.lab3;
import java.util.Scanner;

public class NumberGuessingGame {

  public static int getInput()
  {
    System.out.print("Enter an integer between 1 and 10:");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
  public static void main(String[] args)
  {
    int min = 1, max = 10, tries = 1;
    int answer = min + (int)(Math.random() * (max - min) + 1);

    System.out.println("Welcome to a number quessing game!");
    int guess = getInput();
    String highLow = "";

    while(guess != answer) {
      ++tries;

      if(guess > answer) highLow = "lower";
      if(guess < answer) highLow = "higher";

      System.out.println("Try a "+ highLow + " number!!");
      System.out.println("Enter an integer between 1 and 10:");

      guess = getInput();

      if(tries >= 5)
      {
        System.out.println("You have tried 5 times. You ran out of guesses");
        System.exit(0);
      }
    }

    String time;

    if(tries == 1) time = " time";
    else time = " times";

    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);



  }
} 
