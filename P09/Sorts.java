/** 
** Software Technology 152
** Class to hold various static sort methods.
*/


//reference: Seenrain.B.(2020).DSA1/P01/sorts.java[unpublished manuscript].Curtin Mauritius University


class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
    
       int n = A.length; 
       boolean swapped;
     do
     {
       swapped = false;
     
       for(int i=0; i < n-1; i++)
       { 
             if(A[i] > A[i+1])
             {  
               //swap A[j+1] and A[i] 
             int temp = A[i];  
               A[i] = A[i+1];  
               A[i+1] = temp;
               
               swapped = true;  
            }  
          }  
       } while(swapped == true); // until no swap
         
    }//bubbleSort()

   // selection sort
    public static void selectionSort(int[] A)
    {
        int n = A.length;
       for (int i = 0; i < n- 1; i++) // the unsorted array boundary , move one by one. 
       {  
       
          int min_Index = i;  
          for (int j = i + 1; j < n; j++)
          {  
            if (A[j] < A[min_Index])
            { 
              //this will search for the lowest minIndex    
              min_Index = j;
            }     
          }  
          // swapping the min elemnt found with the 1st elemnt
         int temp = A[min_Index];   
         A[min_Index] = A[i];  
         A[i] = temp;  
       }  
    
     }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    { 
       int n = A.length; 
       for (int i = 1; i < n; i++)
       {  
           
         int key_elemnt = A[i];  
         int j = i-1;  
         //swap the element of array which is > than key element , to 1st position of their initial position
       while ( (j >= 0) && ( A[j] > key_elemnt ) )
       {  
         A[j+1] = A[j];  
         j--;  
       }  
         A[j+1] = key_elemnt;  
       }  
  
   }// insertionSort()
   
   
   

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    
          mergeSortRecurse(A,0,(A.length-1));
    
    }//mergeSort()




    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    
     int midIdx;
            if (leftIdx < rightIdx)
            {
                    midIdx = (leftIdx + rightIdx)/2;

                    mergeSortRecurse(A,leftIdx,midIdx);
                    mergeSortRecurse(A, midIdx+1,rightIdx);

                    merge(A,leftIdx,midIdx,rightIdx);
    
              }
    
    
    
    
    }//mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
      
            int[] temp;
            temp = new int[rightIdx-leftIdx +1];
            int i = leftIdx;
            int j = midIdx +1;
            int k = 0;

            while ((i <= midIdx) && (j <= rightIdx))
            {
                    if (A[i] <= A[j])
                    {
                            temp[k] = A[i];
                            i++;
                        }
                    else
                    {
                            temp[k] = A[j];
                            j++;
                }
                k++;
        }
        
        for (i = i; i <=midIdx; i++)
        {
                temp[k] = A[i];
                k++;
        }
        for (j = j; j <= rightIdx; j++)
        {
                temp[k] = A[j];
                k++;
        }

        for (k = leftIdx; k <= rightIdx; k++)
        {
                A[k] = temp[k-leftIdx];
        }

    
   
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
       quickSortRecurse(A, 2 ,(A.length - 1));
    
    
    
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
       int pivotIndex ;
       int newPivot;
       
       if(rightIdx > leftIdx)
       {
          pivotIndex = ((leftIdx + rightIdx)/2);
       
    
      
      newPivot = doPartitioning(A, leftIdx, rightIdx, pivotIndex);
       
       quickSortRecurse(A, leftIdx ,newPivot - 1);
       quickSortRecurse(A , newPivot + 1 , rightIdx);
       }
    
    
    }//quickSortRecurse()
    
    
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIndex)
    {
         int pivotValue = A[pivotIndex];
         A[pivotIndex] = A[rightIdx];
         A[rightIdx] = pivotValue;
         
         int currentIdx = rightIdx ; // using rightmost pivot strategy
         
         for(int i = rightIdx ; i < leftIdx; i++)
         {
         
           if(A[i] < pivotValue)
           {
              int temp = A[i];
              A[i] = A[currentIdx];
              A[currentIdx] = temp;
              currentIdx++;
           
           }
         }
    
         int newPivot = currentIdx;
         A[rightIdx] = A[newPivot];
         
          A[newPivot] = pivotValue;
    
  
      
		return newPivot;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
