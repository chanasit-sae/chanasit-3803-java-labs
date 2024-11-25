package saetkong.chanasit.lab2;

//the program takes Studnet ID and first name then return the following:
//studnet ID : 
//First Name : 
//Byte Value : 
//Short Value : 
//Int Value : 
//Long Value : 
//Float Value : 
//Double Value : 
//Char Value : 
//boolean Value : 
//
//coded by Chanasit Saetkong
//ID: 673040380-3
//Sec1
//
public class PrimitiveDataType {
    public static void main(String[] args) {
      String studentNumber = args[0]; //take first argument as sutdent ID
      String firstName = args[1]; //take second argument as name
      byte myByte = (byte) firstName.length(); //convert name length as byte
      short myShort = (short)(myByte*21); //convert myByte in a form of short and times 21
      int myInt = Integer.parseInt(studentNumber.substring(4,9) + studentNumber.charAt(10)); //get the last 6 digit of student number
      long myLong = Long.parseLong(studentNumber.substring(0,9) + studentNumber.charAt(10)); //convert student ID into Long
      float myFloat = (float)((float)myByte/100); //mtDouble = 0.xx where xx = myByte
      double myDouble = Double.parseDouble(studentNumber.substring(6,9) + studentNumber.charAt(10))/10000; //myDouble = 0.xxxx where xxxx = last 4 digit of student ID
      char myChar = firstName.charAt(0); //the first letter of the given name
      boolean myBoolean; // if the last digit of the Studnet ID is odd then myBoolean = true or else the boolean = false
      if((int)studentNumber.charAt(10)%2==1) myBoolean  = true;
      else myBoolean = false;

      System.out.println("Studnet ID : " + studentNumber);
      System.out.println("First Name : " + firstName);
      System.out.println("Byte Value : " + myByte);
      System.out.println("Short Value : " + myShort);
      System.out.println("Int Value : " + myInt);
      System.out.println("Long Value : " + myLong);
      System.out.println("Float Value : " + myFloat);
      System.out.println("Double Value : " + myDouble);
      System.out.println("Char Value : " + myChar);
      System.out.println("boolean Value : " + myBoolean);
    }
}
