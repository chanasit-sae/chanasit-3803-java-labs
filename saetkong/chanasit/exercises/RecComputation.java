package saetkong.chanasit.exercises;

public class RecComputation {
    public static void main(String[] args) {
      float width = Float.parseFloat(args[0]);
      float height = Float.parseFloat(args[1]);
      float area = width * height;
      float circumference = 2 * (width + height);

      System.out.println("For width = " + width + " and height = " + height);
      System.out.println("Area = " + area);
      System.out.println("circumference = " + circumference);

    }
}
