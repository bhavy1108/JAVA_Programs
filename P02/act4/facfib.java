import java.util.*;

class facfib{
 
  public static void main(String[] args)
  {
     int numb ; 
        
      Scanner c = new Scanner (System.in);

        System.out.println("Insert a num to both perform factorial and fibonacci :");
        numb =c.nextInt();
      
           //wrap around integer object
           Integer intobj = new Integer(numb);
     
     
          factoRecursive(numb);// calling method factorial
          fiboRecursive(numb); // calling method fibonacci
       
        
       
       System.out.println("The factorial("+numb+") = " +  factoRecursive(numb)); 
       System.out.println("The fibonacci("+numb+") = " +  fiboRecursive(numb)); 
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
