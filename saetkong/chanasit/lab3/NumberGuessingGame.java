package saetkong.chanasit.lab3;
import java.util.Scanner;

//this is a NumberGuessingGame
//takes the user's input number between 1 to 10
//and the program will tell you wether
//it's higher or lower than the answer
//and when you get it right it says:
//"Congratulations!"
//"You have tried (n) time "
//if sure tries exceeded it says
//You have tried 5 times. You ran out of guesses

public class NumberGuessingGame {

  public static int getInput(Scanner scanner)
  {
    System.out.print("Enter an integer between 1 and 10:");
    return scanner.nextInt();
  }
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int min = 1, max = 10, tries = 1;
    int answer = min + (int)(Math.random() * (max - min) + 1); //randomize the answer

    System.out.println("Welcome to a number quessing game!");
    int guess = getInput(scanner);
    String highLow = ""; 

    while(guess != answer) { //if the first input is right this block won't run
      ++tries;//count how many times user have tried

      if(guess > answer) highLow = "lower"; //process the given number to tell higher or lower to the user 
      if(guess < answer) highLow = "higher";

      System.out.println("Try a "+ highLow + " number!!");
      System.out.println("Enter an integer between 1 and 10:");

      guess = getInput(scanner);

      if(tries >= 5) //exit program if the number of tries have exceeded
      {
        System.out.println("You have tried 5 times. You ran out of guesses");
        System.exit(0);
      }
    }

    String time; //these lines use to decide if there's a letter 's' after the word time
    if(tries == 1) time = " time";
    else time = " times";

    System.out.println("Congratulations!");
    System.out.println("You have tried " + tries + time);



  }
} 
