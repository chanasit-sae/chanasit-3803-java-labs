package saetkong.chanasit.lab5;
import java.util.Scanner;

public class RecursiveMethods {
  public static int sumOfDigits(int n) {
    if(n < 10) return n;
    return n%10 + sumOfDigits(n/10);
  }

  public static void reverseArray(int[] arr,int start,int end) {
    if(start >= end) return; 
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArray(arr,start+1,end-1);
  }
  public static boolean isPalindrome(int[] arr, int start, int end) {
    boolean palindrome = true;
    if(start >= end) return true;
    if(arr[start] == arr[end]) {
      isPalindrome(arr,start+1,end-1);
    }   
    else palindrome = false;
    return palindrome;
  }
  public static void main (String[] args) {
    int number1 = 45; 
    System.out.print("Sum of digits in " + number1 + ": " );
    System.out.println(sumOfDigits(number1));

    int number2 = 12345; 
    System.out.print("Sum of digits in " + number2 + ": " );
    System.out.println(sumOfDigits(number2));
    
    int[] arr = {1,2,3,4,5};
    System.out.println("\nOriginal array:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.print("\n");

    reverseArray(arr,0,arr.length-1);
    System.out.println("Reversed array:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");

    int[] P_arr1 = {1,2,3,2,1};
    boolean isP1_Palindrome = isPalindrome(P_arr1,0,P_arr1.length-1);

    System.out.println("Testing palindrome:");
    for(int i=0;i<P_arr1.length;i++)
    {
      System.out.print(P_arr1[i] + " ");
    }
    System.out.println("\nIs palindrome: " + isP1_Palindrome);


    int[] P_arr2 = {1,2,1,2};
    System.out.println("\nTesting palindrome:");
    for(int i=0;i<P_arr2.length;i++)
    {
      System.out.print(P_arr2[i] + " ");
    }
    System.out.print("\n");

    boolean isP2_Palindrome = isPalindrome(P_arr2,0,P_arr2.length-1);
    for(int i=0;i<P_arr2.length;i++)
    {
      System.out.print(P_arr2[i] + " ");
    }
    System.out.println("\nIs palindrome: " + isP2_Palindrome);
  }
}
