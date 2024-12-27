package saetkong.chanasit.lab6;
import java.util.Scanner;

public class NumberGuessingOOPGame {

  public Scanner scanner = new Scanner(System.in);
  private GuessGame game;

  public void configure() {
    System.out.print("Enter the min value: ");
    int min = scanner.nextInt();
    System.out.print("Enter the max value: ");
    int max = scanner.nextInt();
    System.out.print("Enter the maximum number of tries: ");
    int maxTries = scanner.nextInt();

    this.game = new GuessGame(min, max, maxTries);
  }



  public void playGames() {
    boolean playAgain;
    do {
      boolean result = this.game.playSingleGame();
      System.out.println(result ? "You win" : "Better luck next time.");
      System.out.print("Do you want to play again? (Y/N): ");
      playAgain = scanner.next().equalsIgnoreCase("y");
      if(playAgain) configure();
    }while (playAgain);

    System.out.println("Thank you for playing the Number Guessing Game!");
  }



  public static void main(String[] args)
  {
    NumberGuessingOOPGame program = new NumberGuessingOOPGame();
    program.configure();
    program.playGames();
  }
} 

