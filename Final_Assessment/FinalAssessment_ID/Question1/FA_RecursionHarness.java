/**
 * DSA Final Assessment Question 1 - FA_RecursionHarness.java
 *
 * Name : seenarain bhavyattaa
 * ID   :19871253
 *
 *
 *  self cited from practical 2 facfibo.jav in act4
 *  it has been modified according to the exam question
 *  Date : 17/11/2020
 **/


import java.util.*;

class FA_RecursionHarness{
 
  public static void main(String[] args)
  {
     int numb ; 
        
      Scanner c = new Scanner (System.in);

        System.out.println("Insert a num to both perform factorial and fibonacci :");
        numb = c.nextInt();
      
           //wrap around integer object
           Integer intobj = new Integer(numb);
     
     
        // factoRecursive(numb);// calling method factorial_recursive
         // facto_iterative(numb); // calling method factorial_iterative
        // fiboRecursive(numb); // calling method fibonacci_recursive
        // fibo_iterative(numb); // calling metho fibo_iterative
           
       
       		System.out.println("The factorial("+numb+") = " +  factoRecursive(numb)); 
       		System.out.println("The fibonacci("+numb+") = " +  fiboRecursive(numb)); 
  
      		System.out.println("The factorial iterative ("+numb+") = " +   facto_iterative(numb));
        
  		System.out.println("The  fibonacci iterative ("+numb+") = " +   fibo_iterative(numb));
        
   }
   
   
   
       //method  iterative factorial
        public static int facto_iterative(int n)
        {
        
        	int num  = 1;
        	for (int i = 1; i< n; i++)
        	{
        	
        		num *= i;
        	
        	} 
               
               return num ; 
                 
        }        		
        		
   
       
       // method recursive factorial
       // Adding Exception in the factorialRecurse
        public static int factoRecursive(int numb)
        {  
           int facto = 1;// declare and initialise a local var
           
          if(numb < 0) //error condition, to avoid stackoverflow error
           {
             throw new IllegalArgumentException("Negative input is not accepted"); 
           }

           else if(numb == 0)
           {
             facto = 1; // base case
           }
           else
           {
             facto = numb * factoRecursive(numb - 1); // recursive call factorial
           }
             return facto;
          }  
          
          
          // method iterative fibo
          public static int fibo_iterative(int numb)
          {
          
          	int fibo = 0;
          	int x = 1;
                int y;
                	
          	for ( int i= 1; i < numb; i++ )
          	{
          	        y = fibo;
			fibo = x;
			x = y + fibo;
          	
          		
          	}
          	
          	return x;
          	
           }
          
          
          
                   
        // method recursive fibo
        // Exception in fiboRecursive
           public  static int fiboRecursive(int numb)
           {
             int fibo_value = 0;
             
             if (numb < 0) //error condition
             { 
                 throw new IllegalArgumentException("Negative input is not accepted"); 
             }

             else if(numb ==0) 
             { 
                 fibo_value = 0; // base case 1
             }

             else if (numb == 1) 
             {
                 fibo_value = 1; // base case 2
             } 
    
             else
             {
                 fibo_value =  fiboRecursive(numb-1) +  fiboRecursive(numb-2);// 2 recursive calls fibo
             }    
              
              return fibo_value; 
        }
        
        
         
    }
