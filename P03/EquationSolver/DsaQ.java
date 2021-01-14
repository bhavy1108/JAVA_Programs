
public  class DsaQ
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
  
         public void enqueue(String val)
         {
         
             if (isFull())
             {
                System.out.println("the queue is full.");
                         
             }
             else 
             {
             
                q[counter] = val;
                counter++;
             }	
	
	}
	
     //dequeue(), remove element from the queue
     public String dequeue()
     {
	   String firstVal;
           firstVal = peek();
	   int shufVal = 0;
            counter--;
            
              while(shufVal < counter)
	      {
		q[shufVal ] = q[shufVal + 1 ];
		shufVal++;
              }
  	      return firstVal;
     }
	 
	  //peek()
         // check the  front item but do not take it off
          public  String peek()
          {
          
              String firstVal = "";
              if(isEmpty())
              {
                System.out.println("peek is empty.");
              }
              else
              {
              
                firstVal = q[0];
 
	      }
	      return firstVal;
        
	     
          }
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
