package saetkong.chanasit.lab7;

//this class extended the AppleWatch class and 
//implements the RunnerStatsCollector and HealthMonitorer interface
//there are two constructor one take color, price and modelName
//another one also takes totalDistance, avgHeartRate and avgSleepHours
//there are method for printing running stats, average heart rate and average sleep hour
//there are also overrided isWatch() method which return true and an overrided toString() method 
//@auther chanasit saetkong
//modified date 27/1/2025

public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector,HealthMonitorer {
  private double pace;
  private double totalDistance;
  private double time;
  private double avgHeartRate;
  private double maxHeartRate;
  private double avgSleepHours;

  //constructor which takes color, price and getModelName
  //and initialize using the superclass constructor
  public AppleWatchNike(String color,double price, String modelName) {
    super(color,price,modelName);
  }
  
  //constructor which takes color, price, getModelName, totalDistance, avgHeartRate and avgSleepHours
  //and initialize using the superclass constructor and local assignment 
  public AppleWatchNike(String color,double price, String modelName,double totalDistance,double avgHeartRate,double avgSleepHours) {
    super(color,price,modelName);
    this.totalDistance = totalDistance;
    this.avgHeartRate = avgHeartRate;
    this.avgSleepHours = avgSleepHours;
  }

  //print the total distance
  public void displayRunningStats() {
    System.out.println("total distance run: " + this.totalDistance + " km");
  }

  //print the average heart rate
  public void displayHeartRates() {
    System.out.println("Average heart rate: " + this.avgHeartRate + " bpm");
  }

  //print the average sleep hours
  public void displaySleepHours() {
    System.out.println("Average sleep duration: " + this.avgSleepHours + " hours");
  }

  //
  public boolean isWatch() {return true;}
  public String toString() {return  "AppleWatchNike(color: " + this.color + " price:" + this.price + " model name:" + getModelName() + " distance:" + this.totalDistance + " km)";}
}
