package saetkong.chanasit.lab7;

public class AppleWatch extends MobileDevice {
  private String modelName;

  public void setmodelName(String modelName) {this.modelName = modelName;}
  public String getmodelName() {return modelName;}

  public AppleWatch(String color,double price, String modelName ) {
    this.color = color;
    this.price = price;
    this.modelName = modelName;
  }
  public boolean isWatch() {return true;}
  public String toString() {return "AppleWatch [color=" + this.color + ", price=" + this.price + ", modelName=" + this.modelName + "]";}
}
