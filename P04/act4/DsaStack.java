import java.util.*;
import java.io.*;

public class DsaStack implements iterable
{
	DSAlinkedL stac;
	
	/* Default constructor -  Allocating linked list */
	public DsaStack()
	{
		stac = new DSAlinkedL();
	}

	/* pop() method performs an removeFirst in linkedlist
        ** removeFirst method - remove value from the start of 
        ** the linkedlist
        */
	public void pop()
	{
		stac.removeFirst();
	}

	/* push() method performs an insertFirst in linkedlist
	** insertFirst method - adding value at the start of
	** the linkedlist
	*/
	public void push(String value)
	{
		stac.insertFirst(value);
	}
	/* top() method performs peekFirst in the linked list
	** peekFirst method - take the head value in the linked list
        */
        public String top()
	{
		String firstVal;
		firstVal = stac.peekFirst();
		return firstVal;
	}

	/* implementing iterator */
	/*public class DsaStack implements Iterable
	{
		private DSAlinkedL listing;
		
		public Iterator iterator()
		{
			return listing.iterator();
		}
		private class linkedLIterator implements Iterator
		{
			private DSAlistNode iterableNext;
                        public linkedLIterator(DSAlinkedL listing)
			{
				iterableNext = listing.head;
			}
			public boolean hasNext()
			{
				return (iterableNext != null);
			}
                        public String next()
			{
				String val;
				if(iterableNext == null)
				{
				    val = null;
				}
				else
				{
					val = iterableNext.getVal();
				iterableNext = iterableNext.getNext();
				}
                                return val;
			}
	         }
            }*/
 }
