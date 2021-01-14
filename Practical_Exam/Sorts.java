/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
    
       int n = A.length; 
       boolean swaps;
     do
     {
       swaps = false;
     
       for(int i=0; i < n-1; i++)
       { 
             if(A[i] > A[i+1])
             {  
               //swaps A[i+1] and A[i] 
             int temp = A[i];  
               A[i] = A[i+1];  
               A[i+1] = temp;
               
               swaps = true;  
            }  
          }  
          // until no swap
       } while(swaps == true);
         
    }//bubbleSort()

   // selection sort
    public static void selectionSort(int[] A)
    {
        int n = A.length;

       // the unsorted array boundary , move one by one.
       for (int i = 0; i < n- 1; i++)  
       {  
       
            int min_Idx = i;  
            for (int j = i + 1; j < n; j++)
            {  
               if (A[j] < A[min_Idx])
               { 
                 //searching for the lowest minIndex    
                  min_Idx = j;
               }     
            }  

          //swapping the min index found with the 1st elemnt
          int temp = A[min_Idx];   
          A[min_Idx] = A[i];  
          A[i] = temp;  
       }  
    
     }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    { 
       int n = A.length; 
       for (int i = 1; i < n; i++)
       {  
           
           int key_el = A[i];  

           int j = i-1; 
 
         //swap the element of array which is > than key index,to 1st position of their current position
          while ( (j >= 0) && ( A[j] > key_el ) )
          {  
              A[j+1] = A[j];  
              j--;  
          } 
 
           A[j+1] = key_el;  
        }  
  
   }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
