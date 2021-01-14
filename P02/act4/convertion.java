import java.util.*;
import java.util.Scanner;

class convertion{
 
  public static void main(String[] args)
  {
     
      int deci_num;
      Scanner c = new Scanner (System.in);
   
       System.out.println("Insert a num to convert  Decimal to either Binary , octal or Hexadecimal :");
      
           deci_num = c.nextInt();
      
          //wrap around Integer object
          Integer intobj = new Integer(deci_num);
     
         //Make a choice to select which conversion you want to perform
                 
        System.out.println(" Select type of conversion Decimal to : B or b : Binary, O or o : Octal, H or h : Hexadecimal:");
        System.out.println("\nInsert your input: ");

         // Scanner c =  new Scanner(System.in);       
         char choice = c.next().charAt(0);
            
   switch(choice)
   {
     case'B': case 'b':

      System.out.println("Conversion Decimal to Binary of ("+deci_num+") = " + convert_binary(deci_num));

     break;
    
     case'O': case 'o':

     System.out.println("Conversion Decimal to octal ("+deci_num+") = " +  convert_Oct(deci_num)); 

     break;
     
     
     case'H': case 'h':

      System.out.println("Conversion Decimal to hexadecimal ("+deci_num+") = " +  convert_hex(deci_num)); 

     break;
   
   
     default:
     System.out.println("Incorrect Input");
     System.exit(0);
     break;
   }  

  }
           
    // method recursive to convert Decimal to Binary
     // Adding Exception
     public static int convert_binary(int  deci_num)
     {     
           // error condition , exception
           if(deci_num < 0) 
           {
             throw new IllegalArgumentException("Negative input is not accepted"); 
           }

           //base case
           else if(deci_num == 0)
           {
             return 0;
           }
           else
           {
             return ((deci_num % 2) + (10* convert_binary(deci_num / 2)));
           }
            
       }  
                             
       
           
      //method recursive to convert Decimal to hexadecimal
      // exception handling implemented
           
       public  static int convert_hex(int deci_num)
       { 
              // error condition , exception handling
              if(deci_num < 0) 
              {
                 throw new IllegalArgumentException("Negative import is not accepted"); 
              }

             //base case
             else if(deci_num == 0)
             {
                 return 0;
             }

             else
             { 
               return ((deci_num % 16) + (10* convert_Oct(deci_num / 16)));
             }
            
         } 

          // method recursive to convert Decimal to Octal
        // Exception handling
        public  static int convert_Oct(int deci_num)
        { 
             // error condition , exception
              if(deci_num < 0) 
              {
                 throw new IllegalArgumentException("Negative input is not accepted"); 
              }

             //base case
             else if(deci_num == 0)
             {
                 return 0;
             }

             else
             { 
               return ((deci_num % 8) + (10* convert_Oct(deci_num / 8)));
             }
            
         }  
          
         
    }          
           
