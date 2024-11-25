package Saetkong.Chanasit.lab2;
import java.util.Scanner;

public class Dealer {
    public static void main(String[] args) {
      int num_Argument = args.length; //number of argument
      if(num_Argument != 3) { //if the number of argument is not equal to exactly 3 the code won't run
        System.out.println("Error: Invalid number of argument. Please provide exactly three argument.");
        System.exit(0);
      }

      String Name = args[0]; //Dealer's Name
      int num_clients = Integer.parseInt(args[1]); //Number of num_clients
      String Gender = args[2]; //exactly what it   
      System.out.println("Dealer's Name: " + Name);
      System.out.println("Number of clients: " + num_clients);
      System.out.println("Gender: " + Gender);
    }
};
