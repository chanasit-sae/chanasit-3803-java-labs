package saetkong.chanasit.lab7;

//this class is a subclass of MobileDevice with
//1.private instance attribute storage and a setter/getter of the attribute.
//2.private constant attribut CHIP_NAME = "Apple M2" with getter
//3.a constructor that takescolor, price,  and getStorage
//4.a overrided isWatch() method which return false
//5.a overrided toString() method
//@auther chanasit saetkong
//modified date 27/1/2025

public class IPadAir extends MobileDevice {
  private double storage;
  private static final String CHIP_NAME = "Apple M2";

  //constructor
  public IPadAir(String color,double price, double storage) {
    this.color = color;
    this.price = price;
    this.storage = storage;
  }
  
  //CHIP_NAME getter
  public static String getChipName() {return CHIP_NAME;}
  //storage setter getter
  public void setStorage(double storage) {this.storage = storage;}
  public double getStorage() {return this.storage;}

  public boolean isWatch() {return false;}
  public String toString() {return "IPadAir [color=" + this.color + ", price=" + this.price + ", storage=" + this.storage + ", chip=" + this.CHIP_NAME + "]";}
}
