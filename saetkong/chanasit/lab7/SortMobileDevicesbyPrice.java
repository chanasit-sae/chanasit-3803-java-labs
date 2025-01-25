package saetkong.chanasit.lab7;
import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {
  public int compare(MobileDevice device1,MobileDevice device2) {
    return (int)device1.getPrice() - (int)device2.getPrice();
  }

  public static void main(String[] args) {
    MobileDevice[] devices = new MobileDevice[4];
    devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
    devices[1] = new IPadAir("Silver", 24900.0, 256);
    devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
    devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

    Arrays.sort(devices, new SortMobileDevicesbyPrice());

    System.out.println("Mobile devices sorted by price:");
    for(MobileDevice device : devices) {
      System.out.println(device);
    }

  }
}
