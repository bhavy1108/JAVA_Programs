import java.util.*;

// reference  Seenarain.B(2020).facfibo[unpublished manuscript].Curtin Mauriius University

class facfibo{
 
  public static void main(String[] args)
  {
     int num ; 
        int cache;
      Scanner sc = new Scanner (System.in);
      System.out.println("Please enter a num to both calculate factorial and fibonacci :");
      num = sc.nextInt();
     
        //check if num is -ve
         if(num < 0)
         {
         
           do
           { 
              System.out.println("Negative input, please re-enter a number");
              
           }while(num < 0);
           
         }
        else
        {
          factorialIterative(num); //calling method factorial iterative
          factorialRecurse(num);// calling method factorial recursion
          fibonacciIterative(num);// calling method fibonacci iterative
          fibonnaciRecurse(num); // calling method fibonacci recursion
          fibonacciRecursive( num );
         // fibonaciRecursiveCache(cache, num); //calling method fibonacci recursive cache 
        }
        
        
       System.out.println("The factorial iterative ("+num+") = " +  factorialIterative(num));
       
       System.out.println("The factorial recursive("+num+") = " +  factorialRecurse(num)); 
       
        System.out.println("The fibonacci iterative ("+num+") = " +  fibonnaciRecurse(num)); 
        
       System.out.println("The fibonacci recursive("+num+") = " +  fibonnaciRecurse(num)); 
       
     //  System.out.println("The fibonacci recursive cache("+num+") = " +  fibonaciRecursiveCache(num)); 
   }
       
       // method recursive factorial
        public static int factorialRecurse(int num)
        {  
           int fac = 1;// declare and initialise a local var
           //base case
           if(num == 0)
           {
             fac = 1;
           }
          else
           {
              
             fac = num * factorialRecurse(num - 1); // recusre call fac
           }
            return fac;
           }  
                   
                   
       //method iterative factorial 
       public static int factorialIterative(int num)
       {
         
         int ans = 1;
         for (int i = 1; i<= num ;i++)
         {
            ans *= i;
                

         }
           return ans;       
        }            
                   
           //method iterative fibonacci        
            public  static int fibonacciIterative(int num) {
		if(num <= 1) {
			return num;
		}
		int fibo = 1;
		int previousFibo = 1;
		
		for(int i=2; i<num; i++) {
			int temp = fibo;
			fibo += previousFibo;
			previousFibo = temp;
		}
		return fibo;
	}
	       
                   
                   
                   
                   
        // method recursive fibonacci
           public  static int fibonnaciRecurse(int num)
           {
             int fiboVal = 0;
             
             if(num ==0) 
             { 
                 fiboVal = 0; // base case 1
             }
             else if (num == 1) 
             {
                fiboVal = 1; // base case 2
             }     
            else
            {
                fiboVal =  fibonnaciRecurse(num-1) +  fibonnaciRecurse(num-2);// 2 recursive calls fibo
            }    
              
              return fiboVal; 
        }
         
         
      //method using recursive fibonnaciCache
    public  static int fibonacciRecursive(int num )
    {
      return fibonacciRecursiveCache(new int[num +1], num);	
    }

   public static int  fibonacciRecursiveCache(int[] cache, int num) {

   if (num <= 1) {
	    return num;
    }
    if (cache[num] == 0) {
        cache[num] = fibonacciRecursiveCache(cache, num-1) + fibonacciRecursiveCache(cache, num - 2);
    } 
    return cache[num];
}
         
         
         
         
         
    }
