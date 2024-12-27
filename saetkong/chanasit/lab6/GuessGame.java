package saetkong.chanasit.lab6;
import java.util.Scanner;

public class GuessGame {
  Scanner scanner = new Scanner(System.in);
  private int min, max, maxTries, answer, attempts;
  public GuessGame() {
    this.min = 1;
    this.max = 100;
    this.maxTries = 10;
    this.answer = 0;
    this.attempts = 0;
  }

  public GuessGame(int min, int max, int maxTries) {
    this.min = min;
    this.max = max;
    this.maxTries = maxTries;
    this.answer = 0;
    this.attempts = 0;
  }

  public int getMin() {return min;}
  public void setMin(int min) {this.min = min;}

  public int getMax() {return max;}
  public void setMax(int max) {this.max = max;}

  public int getMaxTries() {return maxTries;}
  public void setMaxTries(int min) {this.maxTries = maxTries;}

  public void configureGame(int min, int max, int maxTries) {
    this.min = min;
    this.max = max;
    this.maxTries = maxTries;
  }

  public void generateAnswer() {
    answer = min + (int)(Math.random() * (max-min) + 1);
  }

  public boolean playSingleGame() {
    int tryCNT = 1;
    int guess;
    generateAnswer();
    System.out.println("Welcome to the Number Guessing Game!");
    do{
      System.out.print("Enter an integer between " +  min + " and " + max +  ": ");
      guess = scanner.nextInt();

      String highLow;
      if(guess > answer) highLow = "lower";
      else if(guess < answer) highLow = "higher";
      else break;

      System.out.println("Try a " + highLow + " number!");
      tryCNT++;

    }while(guess != answer && tryCNT <= maxTries);
 

    if(tryCNT > maxTries) 
    {
      System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
      return false;
    }
    else return true;
  }

}
