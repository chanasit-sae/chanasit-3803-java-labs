package saetkong.chanasit.lab6;
import java.util.Scanner;


/**
 *this is a number guessing game that calls a class form the GuessGame.java 
 *this program acts as a GuessGameV2 caller but has a few feature included: 
 *1.configure() to configuring the values of min max and maxTries 
 *2.playGames() for calling the playSingleGame from GuessGame and ask player if they wants to play again 
 *@author coded by chanasit saetkong
 *ID: 673040380-3
 *sec: 1
 */
public class NumberGuessingOOPGameV2 {

  public Scanner scanner = new Scanner(System.in);
  private GuessGameV2 game;

  /**get min max and maxTries from scanner*/
  public void configure() {
    System.out.print("Enter the min value: ");
    int min = scanner.nextInt();
    System.out.print("Enter the max value: ");
    int max = scanner.nextInt();
    System.out.print("Enter the maximum number of tries: ");
    int maxTries = scanner.nextInt();

    this.game = new GuessGameV2(min, max, maxTries);
    System.out.println(this.game.toString());
  }

  /**calls playSingleGame and ask if the player wants to play again or not */
  public void playGames() {
    boolean playAgain;
    do {
      boolean result = this.game.playSingleGame();
      System.out.println(result ? "You win" : "Better luck next time.");
      System.out.print("Do you want to play again? (y/n): ");
      playAgain = scanner.next().equalsIgnoreCase("y");
      if(playAgain) configure();
    }while (playAgain);

    System.out.println("Thank you for playing the Number Guessing Game V2!");
  }

  public static void main(String[] args)
  {
    NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
    program.configure();
    program.playGames();
  }
} 

