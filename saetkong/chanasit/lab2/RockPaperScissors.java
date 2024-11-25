package saetkong.chanasit.lab2;

//this code is an implementation of rock paper scissors game
//which it takes 2 input what player 1 and player 2 picks
//and calculate the winner based on the tranditional Rock Paper Scissors game logic
//
//coded by Chanasit Saetkong
//ID: 673040380-3
//Sec1
//last update: 25/11/2024

public class RockPaperScissors { //checks if the number of argument is equals to 2
  static void isTwoArgument(int num) {
    if(num != 2) {
        System.err.println("Error: Invalid number of argument. Please provide exactly two argument.");
        System.exit(0);
    }
  };

  static void isValid(String input) { //checks if the given input is either rock paper or scissors
    if(input.equals("rock") || input.equals("paper") || input.equals("scissors")) {
      return;
    }
    else {
        System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
        System.exit(0);
    }
  };

  static String getWinner(String Player1_pick, String Player2_pick) { //RockPaperScissors game logic
    String winner = "";
    if(Player1_pick.equals("rock")) { 
      if(Player2_pick.equals("rock")) winner = "It's a tie!";
      else if(Player2_pick.equals("paper")) winner = "Player 2 wins!"; 
      else if(Player2_pick.equals("scissors")) winner = "Player 1 wins!";
    }
    else if(Player1_pick.equals("paper")) {
      if(Player2_pick.equals("paper")) winner = "It's a tie!";
      else if(Player2_pick.equals("rock")) winner = "Player 1 wins!"; 
      else if(Player2_pick.equals("scissors")) winner = "Player 2 wins!";
    }
    else if(Player1_pick.equals("scissors")) {
      if(Player2_pick.equals("scissors")) winner = "It's a tie!";
      else if(Player2_pick.equals("paper")) winner = "Player 1 wins!"; 
      else if(Player2_pick.equals("rock")) winner = "Player 2 wins!";
    }

    return winner;
  };

  public static void main(String[] args) {
    int num_Argument = args.length; //number of argument
    isTwoArgument(num_Argument); //check number of argument

    String Player1_pick = args[0]; //initialize what player 1 and player 2 picks
    String Player2_pick = args[1];

    Player1_pick = Player1_pick.toLowerCase(); //make them Lower case so that it's easier to do condition
    Player2_pick = Player2_pick.toLowerCase();

    isValid((String)Player1_pick); //check if the string is either rock, paper, scissors or not
    isValid((String)Player2_pick);

    String winner = getWinner(Player1_pick,Player2_pick); //get the winner based on game logic

    System.out.println("Player 1 chooses: " + Player1_pick);
    System.out.println("Player 2 chooses: " + Player2_pick);
    System.out.println(winner);
  }
}

