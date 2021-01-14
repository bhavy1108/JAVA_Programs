public class DsaQ
{
        private DSAlinkedL q;
	
	/* Default constructor -  Allocating linked list */
	public DsaQ()
	{
	        q = new DSAlinkedL();
	}

	/* peek() method performs an peekFirst in linkedlist
        ** peekFirst method - checks if the front item and do  
        ** not take it off
        */
	public String peek()
	{
		String firstVal;
		firstVal = q.peekFirst();
		return firstVal;
	}

	/* enqueue() method performs an insertLast in linkedlist
	** insertLast method - inserting value at the end of
	** the linkedlist
	*/
	public void enqueue(String value)
	{
		q.insertLast(value);
	}
	/* dequeue() method performs removeFirst in the linked list
	** removeFirst method - remove value from the start of the linked list
        */
        public void dequeue()
	{
		q.removeFirst();
	}
}
