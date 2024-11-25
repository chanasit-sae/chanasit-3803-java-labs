package saetkong.chanasit.lab2;

//the program takes Studnet ID and first name then convert them into different dataTypes as following:
//byte, short, int, long, float, double, char, boolean
//
//coded by Chanasit Saetkong
//ID: 673040380-3
//Sec1
//last update: 25/11/2024

public class PrimitiveDataType {
    static int getLastSixDigit(String studentNumber) {
      return Integer.parseInt(studentNumber.substring(4,9) + studentNumber.charAt(10));
    };

    static long getID_AsLong(String studentNumber) {
      return Long.parseLong(studentNumber.substring(0,9) + studentNumber.charAt(10));
    };

    static double getLastFourAsDouble(String studentNumber) {
      return Double.parseDouble(studentNumber.substring(6,9) + studentNumber.charAt(10))/10000;
    }

    static boolean islastOdd(String studentNumber) {
      if( (int)studentNumber.charAt(10)%2==1) {
        return true;
      }
      else {
        return false;
      }

    }

    public static void main(String[] args) {
      String studentNumber = args[0]; //take sutdent ID
      String firstName = args[1]; //take name

      byte myByte = (byte) firstName.length(); //convert name length as byte
      short myShort = (short)(myByte*21); //convert myByte to short and times 21
      int myInt = getLastSixDigit(studentNumber); //get last 6 digit of student number
      long myLong = getID_AsLong(studentNumber); //convert student ID into Long
      float myFloat = (float)((float)myByte/100); //mtDouble = 0.xx where xx = myByte
      double myDouble = getLastFourAsDouble(studentNumber); //0.xxxx where xxxx = last 4 digit of student ID
      char myChar = firstName.charAt(0); //the first letter of the given name
      boolean myBoolean = islastOdd(studentNumber); //if last digit of boolean is odd then boolean = true else boolean = false

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
