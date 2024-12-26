package saetkong.chanasit.exercises;

public class TestKKUStudent {

  static class KKUStudent{
    private String name;
    private double GPA;
    private static int StudentCount = 0;
    private static String UniName = "Khon Kaen University";

    KKUStudent() {
      StudentCount++;
    }

    KKUStudent(String passedInName) {
      name = passedInName;
      StudentCount++;
    } 

    public String getName() {
      return name;
    }

    public double getGPA() {
      return GPA;
    } 
    public void setGPA(double passedInGPA) {
      GPA = passedInGPA;
    }

    public void setName(String passedInName) {
      name = passedInName;
    }
    public static String getUniName() {
      return UniName;
    }
    public static int getNumStudents() {
      return StudentCount;
    }
  }




  public static void main(String[] args)
  {
    KKUStudent manee = new KKUStudent();
    manee.setName("Manee");
    manee.setGPA(3.2);
    System.out.println("Name: " + manee.getName() + " GPA is " +
        manee.getGPA());
    KKUStudent mana = new KKUStudent("Mana");
    mana.setGPA(3.4);
    System.out.println("Num students is " + KKUStudent.getNumStudents());
    System.out.println("Name: " + mana.getName() +
        " GPA is " + mana.getGPA());
    System.out.println("Mana's university name is " +
        KKUStudent.getUniName());
  }
}
