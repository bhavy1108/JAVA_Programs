class shellSort 
{ 
      public static void main(String args[]) 
      { 
          int array[] = {11, 21, 26, 2, 8}; 
          System.out.println("Array before sorting"); 
          printArraySort(array); 
  
           shellSort ob = new shellSort(); 
           ob.sorting(array); 
  
           System.out.println("Array after sorting"); 
           printArraySort(array); 
      } 
    
   //to print array of size num
    static void printArraySort(int array[]) 
    { 
        int num = array.length; 
        for (int i=0; i<num; ++i) 
            System.out.print(array[i] + " "); 
            System.out.println(); 
    } 
  
    // sorting array using shellSort 
    int sorting(int array[]) 
    { 
        int num = array.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gapping = num/2; gapping > 0; gapping /= 2) 
        { 
            for (int i = gapping; i < num; i += 1) 
            { 
                 
                int temp = array[i];  
                int j; 
                
                for (j = i; j >= gapping && array[j - gapping] > temp; j -= gapping) 
                    array[j] = array[j - gapping]; 
   
                array[j] = temp; 
            } 
        } 
        return 0; 
    } 
  
   
   
}  
