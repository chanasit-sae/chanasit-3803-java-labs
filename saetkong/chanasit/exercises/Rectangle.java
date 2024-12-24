package saetkong.chanasit.exercises;

class Rectangle {
  double width, height;
  Rectangle(double width,double height)
  {
    this.width = width;
    this.height = height;
  }
}

public class Rectangle {
  static void doubleWidthHeight(Rectangle rec)
  {
    rec.width *= 2;
    rec.height *= 2;
  }
  public static void main(String[] args)
  {
    double width = 5, height = 8;
    System.out.println("Rectangle width = " + width + " Rectangle height = " + height);
    Rectangle rec = new Rectangle(width,height);
    doubleWidthHeight(rec);
    System.out.println("Rectangle width = " + rec.width + " Rectangle height = " + rec.height);
  }

}

