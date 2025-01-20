package saetkong.chanasit.lab7;

public abstract class MobileDevice {
  protected String color;
  protected double price;
  
  public void setColor(String color) {this.color = color;}
  public void setPrice(double price) {this.price = price;}
  public String getColor() {return color;}
  public double getPrice() {return price;}
 
  public abstract boolean isWatch();
  public abstract String toString();
}
