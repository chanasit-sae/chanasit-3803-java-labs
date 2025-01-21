package saetkong.chanasit.exercises.oop2;
import java.util.*;
import java.util.ArrayList;



public class TestStudents {

  public static class FavoriteCourseComparater implements Comparator<Student> {
    public int compare(Student a,Student b) {
      return a.getFavoriteCourse().compareTo(b.getFavoriteCourse());
    }
  }
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<Student>();
    students.add(new DmeEnStudent("Manee","Interaction Design"));
    students.add(new ComEnStudent("Mana","Advanced Computer Programming"));
    students.add(new ComEnStudent("Piti","Linear Curcuit Analysis"));
    System.out.println(students);
    Collections.sort(students, new FavoriteCourseComparater());
    System.out.println(students);
  }
}
