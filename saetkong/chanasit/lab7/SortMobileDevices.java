package saetkong.chanasit.lab7;
import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevices implements Comparator<MobileDevice> {

  public int compare(MobileDevice device1,MobileDevice device2) {
    if(device1.getPrice() != device2.getPrice()) {
      return (int)device1.getPrice() - (int)device2.getPrice();
    } 
    else if(device1 instanceof IPadAir && device2 instanceof IPadAir ) {
      return compareByStorage((IPadAir)device1,(IPadAir)device2);
    }
    else if(device1 instanceof AppleWatch && device2 instanceof AppleWatch) {
      return compareByModelName((AppleWatch)device1,(AppleWatch)device2);
    }
    else return device1.getColor().compareTo(device2.getColor());
  }

  public int compareByStorage(IPadAir device1,IPadAir device2) {
    if(device1.getStorage() != device2.getStorage()) return (int)device1.getStorage() - (int)device2.getStorage();
    else return device1.getColor().compareTo(device2.getColor()); 
  }

  public int compareByModelName(AppleWatch device1, AppleWatch device2) {
      if(device1.getModelName().compareTo(device2.getModelName()) == 0) return device1.getModelName().compareTo(device2.getModelName());
      else return device1.getColor().compareTo(device2.getColor());
  }

  public static void main(String[] args) {
    // Create array of mobile devices with test cases
    MobileDevice[] devices = new MobileDevice[7];
    devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
    devices[1] = new IPadAir("Silver", 24900.0, 256);
    // Same price, different storage
    devices[2] = new IPadAir("Space Gray", 19900.0, 128);
    devices[3] = new IPadAir("Silver", 19900.0, 64);
    // AppleWatches with different prices
    devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
    // Same price, different models
    devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
    devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

    Arrays.sort(devices, new SortMobileDevices());

    System.out.println("Mobile devices sorted by multiple criteria:");
    for(MobileDevice device : devices) {
      System.out.println(device);
    }
  }
}

