import java.util.*;

class facfib{
 
  public static void main(String[] args)
  {
     int number; 
        
      Scanner sc = new Scanner (System.in);
      System.out.println("Insert a value to perform factorial and fibonacci :");
      number = sc.nextInt();
     
        //validation check
         if(number < 0)
         {
         
           do
           { 
              System.out.println("Invalid input , please re-enter:");
              
           }while(number < 0);
           
         }
        else
        {
          factoRecursive(number);// calling method factorial
          fiboRecursive(number); // calling method fibonacci
        }
        
       
       System.out.println("The factorial("+number+") = " +  factoRecursive(number)); 
       System.out.println("The fibonacci("+number+") = " +  fiboRecursive(number)); 
   }
       
                  
        //recursive fibonacci method
           public  static int fiboRecursive(int number)
           {
             int fiboResult = 0;
             
             if(number ==0) 
             { 
                 fiboResult = 0; // base case 1
             }
             else if (number == 1) 
             {
                fiboResult = 1; // base case 2
             }     
            else
            {
                fiboResult =  fiboRecursive(number-1) +  fiboRecursive(number-2);// 2 recursive calls fibo
            }    
              
              return fiboResult; 
        }
         

       //recursive factorial method
        public static int factoRecursive(int number)
        {  
           int facto = 1;// declare and initialise a local var
           //base case
           if(number == 0)
           {
             facto = 1;
           }
          else
           {
              
             facto = number * factoRecursive(number - 1); // recusre call factorial
           }
            return facto;
          }  
        
    }

