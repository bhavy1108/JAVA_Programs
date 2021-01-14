// Reference : Greeksforgreeks


import java.io.*; 
import java.util.*; 
  
class radixSort { 
  
    
    static int getMaxArray(int arr[], int num) 
    { 
        int mxArr = arr[0]; 
        for (int i = 1; i < num; i++) 
            if (arr[i] > mxArr) 
                mxArr = arr[i]; 
        return mxArr; 
    } 
 
  
    static void countSorting(int arr[], int num, int exp) 
    { 
        int out[] = new int[num]; 
        int i; 
        int counter[] = new int[10]; 
        Arrays.fill(counter, 0); 
  
         
        for (i = 0; i < num; i++) 
            counter[(arr[i] / exp) % 10]++; 
  
        for (i = 1; i < 10; i++) 
            counter[i] += counter[i - 1]; 
  
        
        for (i = num - 1; i >= 0; i--) { 
            out[counter[(arr[i] / exp) % 10] - 1] = arr[i]; 
            counter[(arr[i] / exp) % 10]--; 
        } 
  
        for (i = 0; i < num; i++) 
            arr[i] = out[i]; 
    } 
  
     
    static void radixsort(int arr[], int num) 
    { 
        
        int m =getMaxArray(arr, num); 
 
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSorting(arr, num, exp); 
    } 
  
    // A utility function to print an array 
    static void printing(int arr[], int num) 
    { 
        for (int i = 0; i < num; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
  
    public static void main(String[] args) 
    { 
        int arr[] = { 120, 15, 7, 201, 30, 90, 1, 23 }; 
        int num = arr.length; 
            
          // Function Call 
        radixsort(arr, num); 
        printing(arr, num); 
        System.out.println("\n");
    } 
} 
