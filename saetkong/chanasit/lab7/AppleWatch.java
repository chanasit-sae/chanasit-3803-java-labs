package saetkong.chanasit.lab7;

//this class is a subclass of MobileDevice class with
//1.a private attribute modelName with setter/getter
//2.a constructor which takes color, price, and ModelName
//3.a overrided isWatch() method which return false
//4.a overrided toString() method
//@auther chanasit saetkong
//modified date 27/1/2025

public class AppleWatch extends MobileDevice {
  private String modelName;

  //modelName setter/getter
  public void setModelName(String modelName) {this.modelName = modelName;}
  public String getModelName() {return modelName;}

  //constructor
  public AppleWatch(String color,double price, String modelName) {
    this.color = color;
    this.price = price;
    this.modelName = modelName;
  }

  public boolean isWatch() {return true;}
  public String toString() {return "AppleWatch [color=" + this.color + ", price=" + this.price + ", modelName=" + this.modelName + "]";}
}
