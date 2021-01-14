import java.util.*;

public class StackTestHarness
{
 
    public static void main(String [] args)
    {
	  
         Scanner c = new Scanner(System.in);
  
          int stackCapacity;
          int select;
  
        System.out.println("Enter 1 : DSAstack Testing.\nEnter 2 : To End the program.\nEnter Your Choice:");
        select = c.nextInt();
	  do
          {    
		  
	      if (select == 1)
	      {
	       
	        do
	        {      
		   System.out.println("\n\nInsert stackCapacity of the stack : ");
		   stackCapacity = c.nextInt();
		   System.out.println();
	       }  
	       while(stackCapacity <= 0);
	      
	       
	       //make use of an array s                           
	   DsaStack s = new DsaStack(stackCapacity);                           
		
	    // loop to insert top values of the stack until the required stackCapacity
	     for(int i = 0; i < stackCapacity; i++)
	     {
	       double value; 
	       System.out.println("\nAdd values on the top stack using the push method: "); 
	       value = c.nextDouble();                                    
	       s.push(value);
	     } 
	    
	   // loop until values in the stack have been displayed using the LIFO strategy
	    for(int j = 0; j < stackCapacity; j++)
	    {   
					       
	      int Counter;      
	      String a = s.pop();
	      Counter = s.getCounter() + 1; 
	       
	    //A stack uses LAST IN FIRST OUT (LIFO) strategy to output its values.     
                     
	    System.out.println(" Value that is on the position "  +  Counter  + " on the Stack is: " + a + " pop method. ");
	   
	    }
	    
            System.out.println(s.top() + "- top method.");
            System.out.println("\n"); 
	   System.out.println("\nA stack uses LIFO strategy to display its values.");
	   
	   }
	   else
	   {
	       System.out.println("End of program.\n Bye!\n GoodDay.");
	   } //end of if statement
	   
        }while(select <= 0); //end of while loop

	       
  }
		   
}        
		   
