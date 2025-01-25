package saetkong.chanasit.lab7;

public class TestAppleWatchNike {
  public static void main(String[] args) {
    AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 42.5, 75, 7.5);
    System.out.println(nikeWatch);

    nikeWatch.displayRunningStats();
    nikeWatch.displayHeartRates();
    nikeWatch.displaySleepHours();

    System.out.println("Is this a watch? " + nikeWatch.isWatch());

    AppleWatchNike baseWatch = nikeWatch;
    System.out.println("through base reference: " + baseWatch);

  }
}
