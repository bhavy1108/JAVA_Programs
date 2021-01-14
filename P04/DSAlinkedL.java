import java.util.*;
import java.io.*;

public class DSAlinkedL implements Iterable, Serializable
{
	private DSAlistNode head;
	private DSAlistNode tail;

        // Default constructor
	public DSAlinkedL ()
	{
	
	    head = null;
	    tail =  null;
	}
	private class linkedListIterator implements Iterator, Serializable
	{
		private DSAlistNode iterableNext;
		
		public linkedListIterator(DSAlinkedL listing)
		{

                     iterableNext = listing.head;
		}
		public String next()
		{

                    String val;
		    if(iterableNext != null)
		    {
			val = iterableNext.getVal();
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

 	private class DSAlistNode implements Serializable
	{
		private DSAlistNode next;
		private DSAlistNode prev;
		private String val;
		
		
		public DSAlistNode(String inVal)
		{
	            val = inVal;
		    next = null;
		    prev = null;
		}
		//Accessors
		public String getVal()
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
                
		public void setVal(String inVal)
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
	public String peekFirst()
	{
		String nodeVal = "";
		if(!isEmpty())
		{
 	
			nodeVal = head.getVal();
		}
		else
		{
                        nodeVal = "is empty";
		
		}
		return nodeVal;
	}
    
        // peekLast method - check the last value but don't take it off
	public String peekLast()
	{
		String nodeVal;
		if(!isEmpty())
                 {
			DSAlistNode currentNode = head;
			while(currentNode.getNext() != null)
			{
				currentNode = currentNode.getNext();
			}
			nodeVal = currentNode.getVal();
                 }
		else
		 {
		     nodeVal = "is empty";
	         }
		return nodeVal;		
	}
        
        // remove first
	public String removeFirst()
	{
		String nodeVal;
		if(isEmpty())
		{
                   nodeVal = " is empty";
		}
                else
		{
			nodeVal =  head.getVal();
			head = head.getNext();
			head.setPrev();
		}
		return nodeVal;
	}
	// removeLast 
	public String removeLast()
	{
		String firstVal;
		DSAlistNode currentNode = head;
		if (isEmpty ())
		{
		     firstVal = "Empty";
		}
		else if (head.getNext() == null )
		{
		     firstVal  = head.getVal();
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
		  firstVal  = currentNode.getVal();
		  
		 }
		 return firstVal;
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
		    newNode.setNext(head);
		    head = newNode;
		}
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
        /*  method to find value in a linked list */
	public String find (String value)
	{
             String str = "";
             DSAlistNode currentNode = head;
	     boolean found = false;
	     while ((!found) && ( currentNode.getNext() != null))
	     {
                 
 		if( currentNode.getVal() == value)
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
 			str = currentNode.getVal() + "is found";
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
 		       System.out.println(currentNode.getVal());
		       currentNode = currentNode.getNext();
		    }while(currentNode != null);
                }
		else
		{
			System.out.println(currentNode.getVal());
		}
        }
}		
