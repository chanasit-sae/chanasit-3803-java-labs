package saetkong.chanasit.lab5;

//this program has 3 method
//1.findMinMax -> get the min and max element of the given array
//2.isSorted -> check if the given array is sorted
//3.calculateRunningAverages -> get the average of each position

public class NumberAnalyzer {


  /*find the min and max element of the given array
  * @param numbers the array to analyze
 	* @return an array of two elements where index 0 is minimum and index 1 is maximum
 	*/
  public static int[] findMinMax(int[] nums) {
    int len = nums.length;
    int min = nums[0];
    int max = nums[0];
    for(int i=0;i<len;i++)
    {
      if(nums[i] > max) max = nums[i];
      if(nums[i] < min) min = nums[i];
    }
    int[] res = {min,max};
    return res;
	}

  /*check if the given array is sorted
 	* @param numbers the input array
 	* @return array of running averages
 	*/
  public static boolean isSorted(int[] numbers) {  
    int len = numbers.length;
    int temp = numbers[0];
    for(int i=0;i<len;i++)
    {
      if(temp > numbers[i]) return false;
    }
    return true;
	}

  /*get the average of each of position 
  * @param numbers the input array
 	* @return array of running averages
 	*/
  public static double[] calculateRunningAverages(int[] nums) {    double sum = 0;
    double[] res = new double[nums.length];
    for(int i=0;i<nums.length;i++)
    {
      sum += nums[i];
      res[i] = sum/(i+1);
    }
    return res;
	}

  public static void main (String[] args) {
    int[] arr = {4,2,7,1,9};
    int[] minMax = findMinMax(arr);
    System.out.print("Testing with array: {");
    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i]);
      if(i!=arr.length-1) System.out.print(", ");
    }
    System.out.print("}\n");

    double[] avg = calculateRunningAverages(arr);

    System.out.println("Running averages:");
    for(int i=0;i<arr.length;i++)
    {
      System.out.println("Position " + i + ": " + avg[i]);
    }
    System.out.print("\n");


    int[] number1 = {4,2,7,1,9};
    int[] number2 = {1,2,3,4,5};
    System.out.println("Testing if array are sorted:");
    for(int i=0;i<number1.length;i++)
    {
      System.out.print(number1[i] + " ");
    }
    System.out.println("\nnumber1 is sorted: " + isSorted(number1));

    for(int i=0;i<number2.length;i++)
    {
      System.out.print(number2[i] + " ");
    }
    System.out.println("\nnumber2 is sorted: " + isSorted(number2));



  }
}

