import java.io.Serializable;

public class Queue implements Serializable
{
	private LinkedList queue;

	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	public Queue()
	{
		queue = new LinkedList();
	}

	public void enQueue(Object val)
	{
		queue.insertNew(val);
	}

	public Object peek()
	{
		Object topVal = queue.peekFirst();
		return topVal;
	}

	public int getCount()
	{
		return queue.getCount();
	}

	public Object deQueue()
	{
		return queue.removeFirst();
	}
}
