package saetkong.chanasit.lab5;

public class RecursiveMethods {
  public static int sumOfDigits(int n) {
    if(n < 10) return n;
    return n%10 + sumOfDigits(n/10);
  }

  public static void reverseArray(int[] arr,int start,int end) {
    System.out.println("Original array:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.print("\n");

    int[] res = new int[arr.length];
    for(int i=0;i<=end;i++)
    {
      res[start+i] = arr[end-i];
    }

    System.out.println("Reversed array:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(res[i] + " ");
    }
    System.out.println("\n");

  }
  public static void isPalindrome(int[] arr, int start, int end) {
    int[] temp = new int[(end-start)+1];
    int len = temp.length;
    boolean isPalindrome_bool = true;
    for(int i=0;i<len;i++)
    {
      temp[i] = arr[start+i];
    }
    
    for(int i=0;i<len;i++)
    {
      if(temp[i] != temp[(len-1)-i])
      {
        isPalindrome_bool = false;
        break;
      }
    }

    System.out.println("Testing palindrome:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\nIs palindrome: " + isPalindrome_bool + "\n");

  }
  public static void main (String[] args) {
    int number1 = 45; 
    System.out.print("Sum of digits in " + number1 + ":" );
    System.out.println(sumOfDigits(number1));

    int number2 = 12345; 
    System.out.print("Sum of digits in " + number2 + ":" );
    System.out.println(sumOfDigits(number2) + "\n");

    int[] arr = {1,2,3,4,5};
    reverseArray(arr,0,arr.length-1);

    int[] P_arr1 = {1,2,3,2,1};
    isPalindrome(P_arr1,0,P_arr1.length-1);

    int[] P_arr2 = {1,2,1,2};
    isPalindrome(P_arr2,0,P_arr2.length-1);
  }
}
