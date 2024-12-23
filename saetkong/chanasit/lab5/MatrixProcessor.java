package saetkong.chanasit.lab5;
import java.util.Scanner;

//the program display a menu for the user to choose
//choose 1 to input matrix manually
//       2 to randomize the Matrix
//       3 to fill matrix with 1
//       4 to fill matrix with 0
//       5 fill the diagonal element with 1 fill other with 0
//then ask to input rows and columns and the result matrix will be displayed
//
//next the OperationsMenu will shows for the user to choose
//choose 1 to display the transpose Matrix
//       2 to display the sum of each rows/columns
//       3 to find the min and max element
//       4 to display the diagonal element
//       5 to exit the program



public class MatrixProcessor {

  private static int[][] matrix;
  private static int rows;
  private static int columns;
  private static final Scanner scanner = new Scanner(System.in);

  public static void displayCreationMenu() { //menu the menu
    System.out.println("Matrix Creation Menu:");
    System.out.println("1. User Input Matrix");
    System.out.println("2. Random Matrix (0-9)");
    System.out.println("3. All Zero Matrix");
    System.out.println("4. All Ones Matrix");
    System.out.println("5. Diagonal Matrix");
    System.out.print("Enter your choice: ");
  }

  /*create matrix based on choice
  *@param choice the choice that user choose
  */
  public static void createMatrix(int choice) {
    if(choice == 1)//input manually
    {
      System.out.println("Enter matrix element:");
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          matrix[i][j] = scanner.nextInt();
        }
      }
      return;
    }
    if(choice == 2)//random
    {
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          matrix[i][j] = (int)(Math.random() * 10);
        }
      }
      return;
    }
    if(choice == 3)//fill with 0
    {
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          matrix[i][j] = 0;
        }
      }
      return;
    }
    if(choice == 4)//fill with 1
    {
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          matrix[i][j] = 1;
        }
      }
      return;
    }
  }

  //fill a matrix with '1' diagonally, fill the rest with 0 
  public static void createDiagonalMatrix() {   
    for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          if(i==j) matrix[i][j] = 1; 
          else matrix[i][j] = 0;
        }
      }
      return;
  }

  /*display all elements in matrix
   *@param matrix the matrix from creation menu
   */
  public static void displayMatrix(int[][] matrix) {
    System.out.println("\nCreated Matrix:");
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++)
      {
        System.out.print(" " + matrix[i][j]);
      }
      System.out.print("\n");
    }
  }

  //show operation menu//display all elements in matrix
  public static void displayOperationsMenu() { 
    System.out.println("Matrix Operations Menu:");
    System.out.println("1. Find Transpose of the Matrix");
    System.out.println("2. Calculate Sum of Rows and Columns");
    System.out.println("3. Find Minimum and Maximum Elements");
    System.out.println("4. Display Diagonal Elements");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
  }

  //swop rows with colums
  public static void transposeMatrix() {    
    System.out.println("Transposed Matrix:");
    for(int i = 0;i<columns;i++)
    {
      for(int j=0;j<rows;j++)
      {
        System.out.print(" " + matrix[j][i]);
      }
      System.out.print("\n");
    }
    System.out.print("\n");
    return;
  }

  //get the sum of all element in matrix
  public static void calculateSums() {  
    System.out.println("Row sums:\n");
    for(int i=0;i<rows;i++)
    {
      int sum = 0;
      for(int j=0;j<columns;j++)
      {
        sum += matrix[i][j];
      }
      System.out.println("Rows " + i + " sums: " + sum);
    }
    System.out.print("\n");
    for(int i=0;i<columns;i++)
    {
      int sum = 0;
      for(int j=0;j<rows;j++)
      {
        sum += matrix[j][i];
      }
      System.out.println("Column " + i+1 + " sum: " + sum);
    }
    System.out.print("\n");
  }

  //get min max of all element in matrix
  public static void findMinMax() {
    int min = matrix[0][0], max = matrix[0][0];
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++)
      {
        if(matrix[i][j] > max) max = matrix[i][j];
        if(matrix[i][j] < min) min = matrix[i][j];
      }
    }
    System.out.println("Minimum element: " + min);
    System.out.println("Maximum element: " + max + "\n");
  }

  //display the diagonal element in the matrix
  public static void displayDiagonal() {
    if(rows != columns) System.out.println("Matrix is  not square. Cannot display diagonal elements");
    else {
      for(int i=0;i<rows;i++)
      {
        for(int j=0;j<columns;j++)
        {
          if(i==j)System.out.print(" " + matrix[i][i]);
          else System.out.print(" 0");
        }
      }

      displayMatrix(matrix);
    }
  }
    
  public static void main(String[] args) {
    boolean continueProgram = true;
    while (continueProgram) {
      displayCreationMenu();
      int choice = scanner.nextInt();

      if (choice >= 1 && choice <= 4) {
        // For options 1-4, get matrix dimensions
        System.out.print("Enter number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        columns = scanner.nextInt();


        if (rows <= 0 || columns <= 0) {
          System.out.println("Error: Dimensions must be greater than 0");
          continue;
        }


        matrix = new int[rows][columns];
        createMatrix(choice);
      } else if (choice == 5) {
        // Diagonal matrix must be square
        System.out.print("Enter size of square matrix: ");
        rows = columns = scanner.nextInt();


        if (rows <= 0) {
          System.out.println("Error: Size must be greater than 0");
          continue;
        }


        matrix = new int[rows][rows];
        createDiagonalMatrix();
      } else {
        System.out.println("Invalid choice. Please try again.");
        continue;
      }


      displayMatrix(matrix);


      //Operations menu loop
      boolean continueOperations = true;

      while (continueOperations) {
        displayOperationsMenu();
        int operation = scanner.nextInt();


        switch (operation) {
          case 1:
            transposeMatrix();
            break;
          case 2:
            calculateSums();
            break;
          case 3:
            findMinMax();
            break;
          case 4:
            displayDiagonal();
            break;
          case 5:
            continueOperations = false;
            continueProgram = false;
            break;
          default:
            System.out.println("Invalid operation choice.");
        }
      }
    }
    scanner.close();
  }


}
