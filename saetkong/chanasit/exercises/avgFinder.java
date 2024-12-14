package saetkong.chanasit.exercises;

public class avgFinder {

  
  static double avg(int a,int b)
  {
    return ((double)a+b)/2;
  }
  static double avg(int a,int b,int c)
  {
    return ((double)a+b+c)/3;
  }
  static double avg(double a,double b)
  {
    return ((double)a+b)/2;
  }
  public static void main(String[] args)
  {
    int a = 2,b = 3, c = 4;
    double i = 2.2, j = 3.3;
    System.out.println("The average of " + a + " " + b + " = " + avg(a,b));
    System.out.println("The average of " + a + " " + b + " " + c + " = " + avg(a,b,c));
    System.out.println("The average of " + i + " " + j + " = " + avg(i,j));
  }
}
