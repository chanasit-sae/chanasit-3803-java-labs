package saetkong.chanasit.lab12;

import saetkong.chanasit.lab7.MobileDevice;

public class Tablet extends MobileDevice {
  protected static String type = "Tablet";
  protected String name, brand;
    
  public Tablet(String name, String brand, double price, String color) {
    this.name = name;
    this.brand = brand;
    setColor(color);
    setPrice(price);
  }

  public Tablet(String name, String brand, double price) {
    this.name = name;
    this.brand = brand;
    setPrice(price);
  }

  public boolean isWatch() {return false;}

  public String toString() {
    return type + ": " + name + " (" + brand + ") " + price + " Baht"; 
  }
}

