import java.util.*;
import java.io.*;

public class DSAlinkedL implements Iterable
{
	private DSAlistNode head;
	private DSAlistNode tail;
	private int counter;

        // Default constructor
	public DSAlinkedL ()
	{
	
	    head = null;
	    tail =  null;
	    counter = 0;
	}
	private class linkedListIterator implements Iterator
	{
		private DSAlistNode iterableNext;
		
		public linkedListIterator(DSAlinkedL listing)
		{

                     iterableNext = listing.head;
		}
		public Object next()
		{

            	    Object val;
		    if(iterableNext != null)
		    {
			val = iterableNext.getValue();
 			iterableNext = iterableNext.getNext();
		    }
                    else
		    {
                         val = null;
		    }
 		   return val;
		}
		/* Iterator interface implementation*/
	        public boolean hasNext()
		{
			return (iterableNext != null);
		}
		public void remove()	
		{
                    throw new UnsupportedOperationException("error detected");
		}
			
                
  	}

	public Iterator iterator()
	{
	        /* Returning a new instance linkedListIterator*/
		return new linkedListIterator(this);
	}

 	private class DSAlistNode
	{
		private DSAlistNode next;
		private DSAlistNode prev;
		private Object val;
		
		
		public DSAlistNode(Object inVal)
		{
	            val = inVal;
		    next = null;
		    prev = null;
		}
		//Accessors
		public Object getValue()
		{
			return val;
		}
		public DSAlistNode getNext()
		{
			return next;
		}
		public DSAlistNode getPrev()
		{ 
			return prev;
		}
		//Mutators
		public void setPrev(DSAlistNode newNode)
		{
			DSAlistNode node = head;
			while(node.next != null)
			{
			    node = node.getNext();
			}
			newNode.prev = node;
		}
		public void setPrev()
		{
		     prev = null;
		}
                
		public void setVal(Object inVal)
		{
		       val = inVal;
		}
		public void setNext(DSAlistNode newNext)
		{
                      next = newNext;
		}
		public void setNext()
		{
			next = null;
		}
       }
        /* isEmpty() checks if the list is empty or not */
	public boolean isEmpty()
	{
		boolean notFull = false;
		if(head == null)
		{
			notFull = true;
		}
		return notFull;
	}
	//peekFirst() - check the front item but don't take it off
	public Object peekFirst()
	{
		Object nodeVal = null;
		if(!isEmpty())
		{
 	
			nodeVal = head.getValue();
		}
		else
		{
                        nodeVal = "is empty";
		
		}
		return nodeVal;
	}
    
        // peekLast method - check the last value but don't take it off
	public Object peekLast()
	{
		Object nodeVal;
		if(!isEmpty())
                 {
			DSAlistNode currentNode = head;
			while(currentNode.getNext() != null)
			{
				currentNode = currentNode.getNext();
			}
			nodeVal = currentNode.getValue();
                 }
		else
		 {
		     nodeVal = "is empty";
	         }
		return nodeVal;		
	}
        
        // remove first
	public Object removeFirst()
	{
		Object nodeVal = head.getValue();
		if(isEmpty())
		{
                     head =  null;
		}
                else
		{
			head = head.getNext();
			if (head != null)
			  head.setPrev();
		}
		counter--;
		return nodeVal;
	}
	// removeLast 
	public Object removeLast()
	{
		Object firstVal = null;
		DSAlistNode currentNode = head;
		if (isEmpty ())
		{
		     firstVal = "Empty";
		}
		else if (head.getNext() == null )
		{
		     firstVal  = head.getValue();
		     head =  null;
		}
		else
		{
		
		  DSAlistNode previousNode = null;
		  currentNode = head;
		   do
		   {
		  
		     previousNode = currentNode;
		     currentNode = currentNode.getNext();
		   }
		   while ( currentNode.getNext() != null);
		   
		  previousNode.setNext();
		  tail = currentNode.getPrev();
		  firstVal  = currentNode.getValue();
		  
		 }
		 counter--;
		 return firstVal;
	   }   
        
            public int getCounter()
            {
            
               return counter;
            }
        
        
         //insertFirst()			
	public void insertFirst(String newVal)
	{
		DSAlistNode newNode = new DSAlistNode(newVal);
		if(isEmpty ())
		{
                    head = newNode;
		    tail = newNode;
		}
		else 
		{
		    DSAlistNode currentNode = head;
		    do
		    {
		       
		        currentNode = currentNode.getNext();
		        
		    }while(currentNode.getNext() != null);
		    
		     tail = newNode;
		     tail.setPrev(currentNode);
		     currentNode.setNext(tail); 
		}
		counter++;
	}
        
        //insertLast()
	public void insertLast(String newVal)
	{
	 
              DSAlistNode newNode = new DSAlistNode(newVal);
	      if(isEmpty())
               {

                    head = newNode;
		    tail = newNode;
	       }
	      else
	       {       
                        DSAlistNode currentNode = head;
         		while(currentNode.getNext() != null) 
		        {
		             currentNode = currentNode.getNext();
			}
			tail = newNode;
			tail.setPrev(currentNode);
			currentNode.setNext(newNode);
	       }
	}
	
	public void setHead()
	{
	
	     head = null;
	}
	
	public Object getHead()
	{
	
	     return head;
	}     
        /*  method to find value in a linked list */
	public String find (String value)
	{
             String str = "";
             DSAlistNode currentNode = head;
	     boolean found = false;
	     while ((!found) && ( currentNode.getNext() != null))
	     {
                 
 		if( currentNode.getValue() == value)
		{

			found = true;
		}
		else
		{
			currentNode = currentNode.getNext();

		}
             }
             if (found) 
	     {
 			str = currentNode.getValue() + "is found";
	     }
	    else
	     {
		       str = "not found";
	     }
             return str;
	}
        /* display the list of the linked list method */
        public void displayList()
	{
 	
		DSAlistNode  currentNode = head;
	        if (currentNode != tail)
		{
                    do
		    {
 		       System.out.println(currentNode.getValue());
		       currentNode = currentNode.getNext();
		    }while(currentNode != null);
                }
		else
		{
			System.out.println(currentNode.getValue());
		}
        }
}		
