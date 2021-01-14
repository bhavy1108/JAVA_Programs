

import java.util.Stack;
import java.io.*;

public class FA_StackTryTest
{
	public static void main(String args[])
	{
	
            // using built in datatype for hash tables
	    Stack<Integer> stack = new  Stack<Integer>();
	    push(stack);
	    pop(stack);
	    push(stack);
	    peek(stack);
	    search(stack,2);
	    search(stack,9);
	  }
	  
	  static void push(Stack<Integer> stack)
	  {
	  	for (int j = 0; j < 4; j++)
	  	{
	  	
	  		stack.push(j);
	  	}
	  	
	  }
	  
	  static void pop (Stack<Integer> stack)
	  {
	  
	  	System.out.println("pop implementation");
	  	for ( int i =0; i < 4; i++)
	  	{
	  	
	  		Integer x = (Integer) stack.pop();
	  		System.out.println(x);
	  	}
	 } 		
	  
	  
	  static void peek(Stack<Integer> stack)
	  {
	  
	  	Integer value = (Integer) stack.peek();
	  	System.out.println(" top value : " + value);
	  }
	  
	  static void search(Stack<Integer> stack, int value)
	  {
	  
	  	Integer position = (Integer) stack.search(value);
	  	
	  	if ( position == -1)
	  	System.out.println("value 9 not found at any position");
	  	else 
	  	System.out.println("Value found at position : " + position);
	  }
	  	
}

	 
	 
	  
	  
	  
