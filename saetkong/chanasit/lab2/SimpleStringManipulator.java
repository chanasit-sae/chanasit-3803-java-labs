package saetkong.chanasit.lab2;

//this progam takes two string and merge them with the following condition
//if the first letter of the first string is a vowel then the first letter of the result should be Uppercase
//otherwise it'll be Lowercase
//
//if the last letter of the second string isn't a vowel then the last letter of the result should be Uppercase
//otherwise it'll be Lowercase
//
//coded by Chanasit Saetkong
//ID: 673040380-3
//Sec1
//last update: 25/11/2024

public class SimpleStringManipulator {

  static void hasTwoArgument(int num) { //check if there's exactly 2 argument
    if(num != 2) { 
      System.err.println("Error: Invalid number of argument. Please provide exactly two argument.");
      System.exit(0);
    }
  };

  static String checkFirstChar(String s) { //if first letter is a vowel -> make the it Uppercase else make it Lowercase
    char[] vowel = {'a','e','i','o','u','A','E','I','O','U'};
    char first = s.charAt(0);
    for(int i = 0;i < 10;i++) {
      if(first == vowel[i]) {
        System.out.println("boom");
        return s.substring(0, 1).toUpperCase() + s.substring(1);
      } 
    }
    return s.substring(0, 1).toLowerCase() + s.substring(1);
  };

  static String checkLastChar(String s) { //if the last letter isn't a vowel -> make it Uppercase else make it Lowercase
    int len = s.length();
    char last = s.charAt(len-1);
    char[] vowel = {'a','e','i','o','u','A','E','I','O','U'};
    for(int i = 0;i < 10;i++) {
      if(last == vowel[i])
      {
        return s.substring(0, len-1) + s.substring(len-1).toLowerCase();
      }
    }
    return s.substring(0, len-1) + s.substring(len-1).toUpperCase();
  };



  public static void main(String[] args) {
    int num_Argument = args.length; //number of argument
    hasTwoArgument(num_Argument);

    String first = args[0]; //take first and second string
    String second = args[1]; 

    System.out.println("First String: " + first); //print input
    System.out.println("Second String: " + second);

    first = checkFirstChar(first); //make the first letter be in the case it should
    second = checkLastChar(second); // make the last letter be in the case it should
  
    String merged = first + second; //merge both string together

    System.out.println("Resulting string: " + merged); //print the merged two string
  }
};

