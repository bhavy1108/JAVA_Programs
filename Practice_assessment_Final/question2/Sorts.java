/** 
** Software Technology 152
** Class to hold various static sort methods.
*/


//reference: Seenrain.B.(2020).DSA1/P01/sorts.java[unpublished manuscript].Curtin Mauritius University


class Sorts
{
    
   
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
   
   // quickSort median 3 
  /* public static void quickSortMedian(int[] A,int leftIdx, int rightIdx)
   {

	
   	if ( leftIdx >= rightIdx )
   
   		return;
   	 int pivotIndex = getMedian( int leftIdx, int rightIdx);
   	 int doPartitioning = doPartitioning(A,leftIdx, rightIdx, pivotIndex);
		
  	 quickSortMedian(0,  doPartitioning - 1);
  	 quickSortMedian( doPartitioning + 1, rightIdx);


   }
   
   public static voi swapping (int A[],int leftIdx, int rightIdx)
   {
   
   	int temp = A[leftIdx];
   	A[leftIdx] = A[rightIdx];
   	 A[rightIdx] = temp;
   }	 
   
   
   
   
   private static int doPartitioning (int[] A,int leftIdx, int rightIdx,int  pivotIndex)
   {
   
   	int l = leftIdx - 1;
   	int r = rightIdx;
   	while (l < r )
   	{
   	
   		while(A[++l] < pivotIndex);
   		while (r > 0 && A[--r] > pivotIndex);
   		if (l <= r)
   		{
   		    swapping(l,r);
   		}
   		swapping(l,r);
   		return l;
         }		
   		  
    }
    
    public static int getMedian(int leftIdx, int rightIdx)
    {
    
    	int  c  = (leftIdx + rightIdx )/2;
    	
    	if (A[leftIdx] > (A[c])
    	swapping(leftIdx , rightIdx);
    	
    	if (A[leftIdx] > (A[rightIdx])
        swapping(leftIdx , rightIdx);
    
        if (A[c]) > A[rightIdx])
        swapping(c, rightIdx );
    
         swapping(c, rightIdx );
    }
   */
   
     
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


    public static int shellSorting(int A[]) 
    { 
        int num = A.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gapping = num/2; gapping > 0; gapping /= 2) 
        { 
            for (int i = gapping; i < num; i += 1) 
            { 
                 
                int temp = A[i];  
                int j; 
                
                for (j = i; j >= gapping && A[j - gapping] > temp; j -= gapping) 
                    A[j] = A[j - gapping]; 
   
                A[j] = temp; 
            } 
        } 
        return 0; 
    } 






}//end Sorts calss
