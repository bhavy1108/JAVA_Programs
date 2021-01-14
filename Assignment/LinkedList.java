import java.util.*;
import java.io.Serializable;

public class LinkedList implements Serializable
{
	private ListNode head;
	private ListNode tail;
  private int count;

	public LinkedList()
	{
    count = 0;
		head = null;
		tail = null;
	}

	public class ListNode implements Serializable
	{
		private ListNode previous;
		private ListNode next;
		private Object value;

		public ListNode getNext()
		{
			return next;
		}

		public ListNode(Object inValue)
		{
			value = inValue;
			next = null;
			previous = null;
		}

		public Object getValue()
		{
			return value;
		}

		public void setPrevious(ListNode newNode)
		{
			ListNode node = head;
			while (node.next != null)
			{
				node = node.getNext();
			}
			newNode.previous = node;
		}

		public void setPrevious()
		{
			previous = null;
		}

		public ListNode getPrevious()
		{
			return previous;
		}

		public void setValue(Object inValue)
		{
			value = inValue;
		}

		public void setNext(ListNode newNext)
		{
			next = newNext;
		}

		public void setNext()
		{
			next = null;
		}
	}

	public Object peekFirst()
	{
		Object nodeValue = null;
		if (isEmpty())
		{
			nodeValue = "Empty";
		}
		else
		{
			nodeValue = head.getValue();
		}
		return nodeValue;
	}

  public Object getHead()
  {
    return head;
  }

  public int getCount()
  {
    return count;
  }

  public void setHead()
  {
    head = null;
  }

	public Object removeFirst()
	{
		Object nodeValue = head.getValue();
		if (!isEmpty())
		{
			head = head.getNext();
			if (head != null)
				head.setPrevious();
		}
		else
		{
			head = null;
		}
    count--;
		return nodeValue;
	}

	public void insertNew(Object newValue)
	{
		ListNode newNd = new ListNode(newValue);
		if (isEmpty())
		{
			head = newNd;
			tail = newNd;
		}
		else
		{
			ListNode currNd = head;
			while (currNd.getNext() != null)
			{
				currNd = currNd.getNext();
			}
			tail = newNd;
			tail.setPrevious(currNd);
			currNd.setNext(tail);
		}
    count++;
	}

	public boolean isEmpty()
	{
		boolean empty = true;
		if (head != null)
		{
			empty = false;
		}
		return empty;
	}

	public Object peekLast()
	{
		Object nodeValue;
		if (isEmpty())
		{
			nodeValue = "Empty";
		}
		else
		{
			ListNode currNd = head;
			while (currNd.getNext() != null)
			{
				currNd = currNd.getNext();
			}
			nodeValue = currNd.getValue();
		}
		return nodeValue;
	}

	public Object removeLast()
	{
		Object nodeValue = null;
		ListNode currNode = head;
		if (isEmpty())
		{
			nodeValue = "Empty";
		}
		else if (head.getNext() == null)
		{
			nodeValue = head.getValue();
			head = null;
		}
		else
		{
			ListNode prevNode = null;
			currNode = head;
			while (currNode.getNext() != null)
			{
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext();
			tail = currNode.getPrevious();
			nodeValue = currNode.getValue();
		}
    count--;
		return nodeValue;
	}
}
