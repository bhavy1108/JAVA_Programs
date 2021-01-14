public class DsaQ
{
	private DSAlinkedL queue;

	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	public DsaQ()
	{
		queue = new DSAlinkedL();
	}

	public void enQueue(Object val)
	{
  		queue.insertFirst(val);
	}

	public Object peek()
	{
		Object topVal = queue.peekFirst();
		return topVal;
	}

	public int getCounter()
	{
		return queue.getCounter();
	}

	public Object deQueue()
	{
		return queue.removeFirst();
	}
}
