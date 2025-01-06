package saetkong.chanasit.lab6;

import java.util.Scanner;

/**
 * This is an extended version of the GuessGame class with additional features and configurations.
 * 
 * @author coded by chanasit saetkong
 * ID: 673040380-3
 * sec: 1
 */
public class GuessGameV2 extends GuessGame { 
    Scanner scanner = new Scanner(System.in);

    /** Default constructor */
    public GuessGameV2() {
        super();
    }

    /** Constructor with parameters
     * @param min the minimum value of the answer
     * @param max the maximum value of the answer
     * @param maxTries the maximum number of tries
     */
    public GuessGameV2(int min, int max, int maxTries) {
        super(min, max, maxTries); 
        configureGame(min,max,maxTries);
    }

    /** Configure min, max, and maxTries with validation */
    @Override
    public void configureGame(int min, int max, int maxTries) {
        int tmpMin = min;
        int tmpMax = max;
        int tmpMaxTries = maxTries;

        while (tmpMin > tmpMax) {
            System.out.println("Invalid input: max must be greater than or equal to min.");
            System.out.print("Enter the min value: ");
            tmpMin = scanner.nextInt();
            System.out.print("Enter the max value: ");
            tmpMax = scanner.nextInt();
        }

        while (tmpMaxTries < 1) {
            System.out.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            tmpMaxTries = scanner.nextInt();
        }

        super.configureGame(tmpMin, tmpMax, tmpMaxTries); 
    }

    /** Play the game with  validation */
    @Override
    public boolean playSingleGame() {
        int tryCNT = 1;
        int guess;
        generateAnswer(); 
        System.out.println("Welcome to the Number Guessing Game V2!");
        do {
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            guess = scanner.nextInt();
            if (guess < getMin() || guess > getMax()) {
                System.out.println("Invalid input: guess must be between " + getMin() + " and " + getMax());
                continue;
            }

            String highLow;
            if (guess > getAnswer()) highLow = "lower";
            else if (guess < getAnswer()) highLow = "higher";
            else break;

            System.out.println("Try a " + highLow + " number!");
            tryCNT++;

        } while (guess != getAnswer() && tryCNT <= getMaxTries());

        if (tryCNT > getMaxTries()) {
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", Max Tries: " + getMaxTries() + "]";
    }
}
