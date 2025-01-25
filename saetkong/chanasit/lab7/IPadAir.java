package saetkong.chanasit.lab7;

public class IPadAir extends MobileDevice {
  private double storage;
  private static final String CHIP_NAME = "Apple M2";

  public IPadAir(String color,double price, double storage) {
    this.color = color;
    this.price = price;
    this.storage = storage;
  }
  
  public static String getChipName() {return CHIP_NAME;}
  public void setStorage(double storage) {this.storage = storage;}
  public double getStorage() {return this.storage;}
  public boolean isWatch() {return false;}
  public String toString() {return "IPadAir [color=" + this.color + ", price=" + this.price + ", storage=" + this.storage + ", chip=" + this.CHIP_NAME + "]";}
}
