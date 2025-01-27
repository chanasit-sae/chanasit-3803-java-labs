package saetkong.chanasit.lab7;

public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector,HealthMonitorer {
  private double pace;
  private double totalDistance;
  private double time;
  private double avgHeartRate;
  private double maxHeartRate;
  private double avgSleepHours;

  public AppleWatchNike(String color,double price, String modelName) {
    super(color,price,modelName);
  }
  
  public AppleWatchNike(String color,double price, String modelName,double totalDistance,double avgHeartRate,double avgSleepHours) {
    super(color,price,modelName);
    this.totalDistance = totalDistance;
    this.avgHeartRate = avgHeartRate;
    this.avgSleepHours = avgSleepHours;
  }

  public void displayRunningStats() {
    System.out.println("total distance run: " + this.totalDistance + " km");
  }


  public void displayHeartRates() {
    System.out.println("Average heart rate: " + this.avgHeartRate + " bpm");
  }


  public void displaySleepHours() {
    System.out.println("Average sleep duration: " + this.avgSleepHours + " hours");
  }


  public boolean isWatch() {return true;}
  public String toString() {return  "AppleWatchNike(color: " + this.color + " price:" + this.price + " model name:" + getModelName() + " distance:" + this.totalDistance + " km)";}
}
