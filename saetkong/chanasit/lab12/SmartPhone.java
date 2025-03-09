package saetkong.chanasit.lab12;

import saetkong.chanasit.lab7.MobileDevice;

public class SmartPhone extends MobileDevice {
  protected static String type = "Smart Phone";
  protected String name, brand;
    
  public SmartPhone(String name, String brand, double price, String color) {
    this.name = name;
    this.brand = brand;
    setColor(color);
    setPrice(price);
  }

  public SmartPhone(String name, String brand, double price) {
    this.name = name;
    this.brand = brand;
    setPrice(price);
  }

  public boolean isWatch() {return false;}

  public String toString() {
    return type + ": " + name + " (" + brand + ") " + price + " Baht"; 
  }
}
