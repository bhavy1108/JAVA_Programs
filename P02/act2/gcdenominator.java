import java.util.*;

class gcdenominator{
 
  public static void main(String[] args)
  {
     int x, y; 
        
      Scanner sc = new Scanner (System.in);
      
      System.out.println(" Insert a value for x to perform greatest common denominator:");
      x = sc.nextInt();
      
      System.out.println(" insert a value for y to perform greatest common denominator:");
      y = sc.nextInt();
      
      
        //validation check
         if((x < 0) || ( y < 0))
         {
         
           do
           { 
              System.out.println(" Invalid input, please re-enter x: ");
              System.out.println(" Invalid input, please re-enter a y:");
              
              
           }while((x < 0) || ( y < 0));
           
         }
        else
        {
          gcdenominator(x ,y);// calling method greatest commmon denominator
          
        }
        
       
        System.out.println("Greatest Common Denominator of " + x +" and " + y + " is " + gcdenominator(x, y)); 
   }
       
       // method recursive greatest common denominator to return x and y
        public static int gcdenominator(int x ,  int y)
        {  
            
             // division by zero
             
             if (x == 0) 
             {
               return y; // if x is zero , y is the return value
             } 
             if (y == 0) // if x is zero , y is the return value
             {
               return  x; 
             }
             
             // base case 
      
             if (x == y) // if x equals n , y is the return value
             {
              return  x; 
             }
            //  if x is bigger than y
             if (x > y) 
             {
               return  gcdenominator(x-y, y); 
             }
             
          return gcdenominator(x, y-x);            
            
         }
    } 
        
        
        
        
