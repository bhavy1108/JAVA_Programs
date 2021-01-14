import java.util.*;

class gcdenominator{
 
  public static void main(String[] args)
  {
     int x, y ; 
        
      Scanner sc = new Scanner (System.in);
      
      System.out.println(" Insert a number for m to perform greatest common denominator:");
      x = sc.nextInt();
      
      System.out.println("Insert a number for n to perform greatest common denominator:");
      y = sc.nextInt();
          
            //wrapping around integers object
         Integer intobj1 = new Integer(x);
         Integer intobj2 = new Integer(y);
     
      
          gcdeno(x ,y);// calling method greatest commmon denominator
           
        System.out.println("Greatest Common Denominator of " + x +" and " + y + " is " + gcdeno(x, y)); 
   }
       
       // method recursive greatest common denominator to return m and n
        public static int gcdeno(int x ,  int y)
        {  
            
              // ERROR CONDITION or exception
             if (( x < 0 ) && ( y < 0))  
             {
                  throw new IllegalArgumentException("Negative input is not accepted"); 
             }
             
             if (( x < 0 ) && ( y > 0))  
             {
                throw new IllegalArgumentException("Negative input is not accepted"); 
             }
            
             if (( x > 0 ) && ( y < 0)) 
             {
                throw new IllegalArgumentException("Negative input is not accepted"); 
             } // end of error exception handling
              
             if (x == 0) //divide by zero
             {
               return x; // if x is zero , x is the return value
             } 
             
             if (y == 0) // if y is zero ,  y is the return value
             {
               return  y; 
             }
             
             // base case 
      
             if (x == y) // if m  equals n , m is the return value
             {
              return  x; 
             }
            
           return gcdeno(x, y-x);            
            
         }
     
 }       
        
        
        
