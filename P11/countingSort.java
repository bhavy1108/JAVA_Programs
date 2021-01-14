//reference : greeksforgreeks

class countingSort { 

      public static void main(String args[]) 
      { 
        countingSort ob = new countingSort(); 
        char array[] = { 'i', 's', 'h', 'a', 'n', 'i', 's', 
                       'e', 'e', 'n', 'a', 'r', 'a','i','n' }; 
  
        ob.sorting(array); 
  
        System.out.print("Sorted character array are:  "); 
        for (int i = 0; i < array.length; ++i) 
            System.out.print(array[i]);
             System.out.print("\n");  
     } 

    void sorting(char array[]) 
    { 
        int num = array.length; 
  
        // The out array - contain sorted arr 
        char out[] = new char[num]; 
  
        
        
        int counter[] = new int[256];
         
        for (int j = 0; j < 256; ++j) 
            counter[j] = 0; 
  
        // counter of each char 
        for (int i = 0; i < num; ++i) 
            ++counter[array[i]]; 
  
         
        for (int i = 1; i <= 255; ++i) 
            counter[i] += counter[i - 1]; 
  
        
        for (int i = num - 1; i >= 0; i--) { 
            out[counter[array[i]] - 1] = array[i]; 
            --counter[array[i]]; 
        } 
  
       
        for (int i = 0; i < num; ++i) 
            array[i] = out[i]; 
    } 
  
   
   
} 
