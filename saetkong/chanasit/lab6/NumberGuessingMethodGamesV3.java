package saetkong.chanasit.lab6;
import java.util.Scanner;


/**
 *this is a number guessing game that calls a class form the GuessGame.java 
 *this program acts as a GuessGame caller but has a few feature included: 
 *1.configure() to configuring the values of min max and maxTries 
 *2.playGames() for calling the playSingleGame from GuessGame and ask player if they wants to play again 
 *@author coded by chanasit saetkong
 *ID: 673040380-3
 *sec: 1
 */
public class NumberGuessingMethodGamesV3 {
  public static Scanner scanner = new Scanner(System.in);
  private GuessGameV3 game;
  boolean continuePlaying = true;

  public void configure() {
    int maxTries;
      this.game = new GuessGameV3();

    System.out.print("Enter the min value: ");
    int min = scanner.nextInt();  
    System.out.print("Enter the max value: ");
    int max = scanner.nextInt(); 

    while (max < min) {
      System.err.println("Invalid input: max must be greater than or equal to min.");

      System.out.print("Enter the min value: ");
      min = scanner.nextInt(); //ask for minimum number 

      System.out.print("Enter the max value: ");
      max = scanner.nextInt(); //ask for maximum number

    }

    System.out.print("Enter the maximum number of tries: ");
    maxTries = scanner.nextInt();

    while(maxTries < 1 ){

      System.err.println("Invalid input: maxTries must be greater than 0.");

      System.out.print("Enter the maximum number of tries: ");
      maxTries = scanner.nextInt();  
    }

    this.game.configureGame(min,max,maxTries);
    GuessGameV3.addGameRecord(this.game);

  }

  public void playGames() {
    int playAgain;
    boolean result = this.game.playSingleGame();
    //System.out.println(result ? "You win!" : "Better luck  next time.")
    do {
      System.out.println("Do you want to: \n1. Play again\n2. View game records\n3. Quit");
      playAgain = scanner.nextInt();
      switch (playAgain) {
        case 1 : 
          configure();
          this.game.playSingleGame();
          break;

        case 2 :
          viewRecords();
          break;

        case 3 :
          break;

        default :
          break;
      }
    } while (playAgain != 3 );
    System.out.println("Thank you for playing the Number Guessing Game V3!");
  }

  public void viewRecords() {
    int choose;
    System.out.println("View:\n1. Complete Records\n2. Specific Game Record");
    choose = scanner.nextInt();

    while (choose != 1 && choose != 2 ) {
      System.err.println("Invalid input: viewOptions should be 1 or 2.");
      System.out.println("View:\n 1. Complete Records\n2. Specific Game Record");
      choose = scanner.nextInt();
    }

    if(choose == 1) {
      displayCompleteRecords();
    } 
    else if(choose == 2) {
      displaySpecificRecords();
    }
  }

  public void displayCompleteRecords() {
    GuessGameV3[] gameRecords = GuessGameV3.getGameRecords();
    for (int i = 0 ; i  < GuessGameV3.getRecordCount() ; i ++ ) {
      System.out.println("Game " + (i + 1) + ": " + gameRecords[i].getGameLog());
    }
  }

  public void displaySpecificRecords() {
    int GameNumber;
    System.out.print("Enter the game number to view: "); 
    GameNumber = scanner.nextInt();
    System.out.println();

    while (GameNumber < 1 || GameNumber > GuessGameV3.getRecordCount() ) {
      System.err.println("Invalid game number.");
      System.out.print("Enter the game number to view: ");
      GameNumber = scanner.nextInt();
      System.out.println();

    }
    System.out.println("Game " + GameNumber + ": " + GuessGameV3.getGameRecords()[GameNumber - 1].getGameLog());
  }

  public static void main(String[] args){
    NumberGuessingMethodGamesV3 program = new NumberGuessingMethodGamesV3();
    program.configure();
    program.playGames();
    scanner.close();
  }

} 

