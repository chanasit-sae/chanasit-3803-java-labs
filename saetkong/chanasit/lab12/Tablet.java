package saetkong.chanasit.lab12;

import saetkong.chanasit.lab7.MobileDevice;
import java.io.*;

//a class for MobileDevice object with the type Tablet

public class Tablet extends MobileDevice implements Serializable {
  protected static String type = "Tablet";
  protected String name, brand;
  protected double price;
    
  //constructor to create the object 
  public Tablet(String name, String brand, double price, String color) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    setColor(color);
    setPrice(price);
  }

  public Tablet(String name, String brand, double price) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    setPrice(price);
  }

  public boolean isWatch() {return false;}

  //return to make the display message
  public String toString() {
    return type + ": " + name + " (" + brand + ") " + this.price + " Baht"; 
  }
}

