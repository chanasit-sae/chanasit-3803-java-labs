package saetkong.chanasit.lab7;

//this class implements MobileDevice, IPadAir, and AppleWatch public class TestMobileDevices
//with a static method comparePrice for comparing the prices of objects
//@auther chanasit saetkong
//modified date 27/1/2025

public class TestMobileDevices {

  //takes in two MobileDevice objects and compare the price of them
  public static void comparePrice(MobileDevice device1,MobileDevice device2) {
    if(device1.getPrice() < device2.getPrice()) {
      System.out.println(device1 + " is cheaper than " + device2);
    } else if(device1.getPrice() > device2.getPrice()) {
      System.out.println(device2 + " is cheaper than " + device1);
    } else {
      System.out.println("The price are the same");
    }
  }

  public static void main(String[] args) {
    IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
    IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
    AppleWatch appleWatch1 = new AppleWatch("Silver", 9400, "Apple Watch Nike SE GPS");
    System.out.println("IPadAir chip name is " + IPadAir.getChipName());
    if(ipadAir2.isWatch()) {
      System.out.println(ipadAir2 + " is a watch");
    } else {
      System.out.println(ipadAir2 + " is not a watch");
    }
    comparePrice(ipadAir1, ipadAir2);
    comparePrice(ipadAir1, appleWatch1);
  } 
}

