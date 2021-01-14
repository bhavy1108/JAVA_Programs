import java.util.*;
import java.util.Scanner;

class convertion{
 
  public static void main(String[] args)
  {
     
      int decimal_num;
      String h = "";
      Scanner sc = new Scanner (System.in);
   
      System.out.println("Please enter a num to convert either Decimal to Binary , octal or Hexadecimal :");
      decimal_num = sc.nextInt();
      
        //check if num is -ve
         if(decimal_num < 0)
         {
           do
            { 
              System.out.println("Negative input, please re-enter a number");
              
            }while(decimal_num < 0);
           
          }
         
         //make a choice to be able to choice which conversion you want to perform
                 
        System.out.println("Choose the type of conversion Decimal to : B = Binary, O = Octal, H = Hexadecimal:");
        // Scanner sc =  new Scanner(System.in);       
         char choice = sc.next().charAt(0);
            
   switch(choice)
   {
     case'B': case 'b':
      System.out.println("Conversion Decimal to Binary of ("+decimal_num+") = " + convert_to_binary(decimal_num));
     break;
    
     case'O': case 'o':
     System.out.println("Conversion Decimal to octal ("+decimal_num+") = " +  convert_to_Oct(decimal_num)); 
     break;
     
     
     case'H': case 'h':
     System.out.println("Conversion Decimal to hexadecimal ("+decimal_num+") = " +  convert_to_hex(decimal_num)); 
     break;
   
   
     default:
     System.out.println("Invalid Input");
     System.exit(0);
     break;
   }  

  }
           
       // method recursive to convert Decimal to Binary
        public static int convert_to_binary(int  decimal_num)
        {  
           
           //base case
           if(decimal_num == 0)
           {
             return 0;
           }
          else
           {
              
           return ((decimal_num % 2) + (10* convert_to_binary(decimal_num / 2)));
           }
            
         }  
         
         
                     
        // method recursive to convert Decimal to Octal
           public  static int convert_to_Oct(int decimal_num)
           {
            //base case
             if(decimal_num == 0)
             {
                 return 0;
             }
             else
             {
              
               return ((decimal_num % 8) + (10* convert_to_Oct(decimal_num / 8)));
             }
            
           }  
           
                      
        // method recursive to convert Decimal to hex
           public  static int convert_to_hex(int decimal_num)
           {
            //base case
             if(decimal_num == 0)
             {
                 return 0;
             }
             else
             {
              
               return ((decimal_num % 16) + (10* convert_to_Oct(decimal_num / 16)));
             }
            
           }   
           
  }         
           
           
           
           
           
           
           
         
       
