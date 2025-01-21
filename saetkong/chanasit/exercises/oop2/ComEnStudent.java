package saetkong.chanasit.exercises.oop2;

public class ComEnStudent extends Student{
  public ComEnStudent(String name,String favoriteCourse) { 
    this.name = name;
    this.favoriteCourse = favoriteCourse;
  }

  public String getFavoriteCourse() {
    return favoriteCourse;
  }

  public String toString() {
    return name + " => favorite course = " + favoriteCourse + ", ";
  }

}
