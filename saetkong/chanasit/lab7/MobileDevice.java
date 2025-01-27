package saetkong.chanasit.lab7;

//this is a abstract class with protected variable color and Price
//with setter and getter function for both variable
//this class also include abstract public method isWatch()
//@auther chanasit saetkong
//modified date 27/1/2025


public abstract class MobileDevice {
  protected String color;
  protected double price;
  
  public void setColor(String color) {this.color = color;}
  public void setPrice(double price) {this.price = price;}
  public String getColor() {return color;}
  public double getPrice() {return price;}
 
  //use to identify wether the type of product is a watch or not
  public abstract boolean isWatch();

  public abstract String toString();
}
