import java.util.*;
public abstract class DsaQ
{
    //class fields

       public int counter;
	private String[] q;
	private int maxCap;


      //constant
       public static final int defaultCap = 100; 
       
         // DEFAULT Constructor
       public DsaQ()
       {
      
         q = new String [defaultCap];
         counter = 0;
   
       }
   
      
       public DsaQ(int maxCap) 
       {
          q = new String[maxCap];
     
          counter = 0;
       }
  

       //Accessor - getCounter
       	public int getCounter()
	{
         
	  return counter;
	}
	//mutator - enqueue()
	//enQueuE()
        //add element to the queue
  
         public abstract void enqueue(String val);
	
	
	
	/*public void enqueue(object value)
	{
           q[counter] = value;
  	   counter++
	} */
        // mutator - dequeue()
        
     //dequeue(), remove element from the queue
     public abstract String dequeue();
	/*public object dequeue()
	{
	   object firstVal;
           firstVal = peek();
	   int shufVal = 0;
              counter--;
              while(shufVal < counter)
	      {
		q[shufVal ] = q[shufVal + 1 ];
              }
  	      return firstVal;
         }*/
	 
	  //peek()
         // check the  front item but do not take it off
          public abstract String peek();
 
	  
         /* public object peek()
	  {
	     return q[0];
          }*/
          //mutator isEmpty()
          public boolean isEmpty()
	  {
                boolean empty = true; 
        	if (counter != 0)
		{
                   empty = false;
               	}
		else
		{
		   empty = true;
		}
		return empty;
         }
         //mutator isFull()
         public boolean isFull()
         {
             boolean full = false;
             if(counter != q.length)
             {
                full = false;
             }		
	     else
	     {
	        full = true;
	     }
	     return full;
	  }
}	     
