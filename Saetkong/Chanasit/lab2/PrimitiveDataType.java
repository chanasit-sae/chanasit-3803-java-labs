package Saetkong.Chanasit.lab2;

public class Hello {
    public static void main(String[] args) {
      String studnet_ID = args[0];
      String firstName = args[1];
      byte firstName_byte = (firstName.getBytes()).length();
      
      System.out.println(firstName_byte);     
    }
}
