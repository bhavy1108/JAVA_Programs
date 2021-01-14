import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Graph implements Serializable
{
  private int numOfVertex;
  LinkedList graph = new LinkedList();

  private class Edge implements Serializable
  {
    private GraphVertex from;
    private GraphVertex destination;

    public Edge(GraphVertex f, GraphVertex d)
    {
      from = f;
      destination = d;
    }
    public GraphVertex getFrom()
    {
      return from;
    }
    public GraphVertex getDest()
    {
      return destination;
    }
  }

  private class GraphVertex implements Serializable
  {
    private Object value;
    private GraphVertex next;
    private LinkedList edges;
    private boolean visited;

    public Object getValue()
    {
      return value;
    }
    public void addEdge(Edge edge)
    {
      edges.insertNew(edge);
    }
    public boolean getVisit()
    {
      return visited;
    }
    public GraphVertex getNext()
    {
      return next;
    }
    public LinkedList getEdges()
    {
      return edges;
    }
    public void setVisit(Boolean visit)
    {
      visited = visit;
    }
    public GraphVertex(Object o)
    {
      visited = false;
      numOfVertex++;
      edges = new LinkedList();
      value = o;
      next = null;
    }
    public void setNext(GraphVertex nxt)
    {
      next = nxt;
    }
  }

  public int getVertexCount()
  {
    return graph.getCount();
  }

  public Graph()
  {
    numOfVertex = 0;
  }

  public void addNewEdge(Object source, Object destination)
  {
    GraphVertex from = getVertex(source);
    GraphVertex to = getVertex(destination);

    if (from == null)
    {
      from = new GraphVertex(source);
      graph.insertNew(from);
    }

    if (to == null)
    {
      to = new GraphVertex(destination);
      graph.insertNew(to);
    }

    from.addEdge(new Edge(from, to));

    to.addEdge(new Edge(to, from));
  }

  public void addVertex(Object vertex)
  {
    graph.insertNew(vertex);
  }

  public void printGraph()
  {
    if (graph.getHead() != null)
    {
      LinkedList.ListNode node = (LinkedList.ListNode)(graph.getHead());
      TradeDetails td = (TradeDetails)(node.getValue());

      while (node.getNext() != null)
      {
        System.out.println(td.toString());
        node = node.getNext();
        td = (TradeDetails)(node.getValue());
      }
    }
    else
    {
      System.out.println("Graph is empty");
    }
  }

  public GraphVertex getVertex(Object val)
  {
		GraphVertex returnString = null;
    LinkedList.ListNode vertex = (LinkedList.ListNode)graph.getHead(); //Get the vertices
    boolean found = false;
    if (vertex != null)
    {
      GraphVertex v = (GraphVertex)(vertex.getValue());

      while ((vertex != null) && (!found))
      {
        v = (GraphVertex)(vertex.getValue());
        if (v.getValue() == val)
        {
          found = true;
        }
        else
        {
          vertex = vertex.getNext();
        }
      }
      if (found)
      {
        returnString = v;
      }
    }
    return returnString;
  }

  public void BreadthFirstSearch(Object val)
  {
    Queue queue = new Queue();
    GraphVertex vertex = getVertex(val);
    LinkedList list = vertex.getEdges();
    LinkedList.ListNode edges = (LinkedList.ListNode)(list.getHead());
    Edge edgesConnection = (Edge)(edges.getValue());
    GraphVertex to = edgesConnection.getDest();

    System.out.print(vertex.getValue() + " : ");
    vertex.setVisit(true);
    GraphVertex vertexQueue = getVertex(vertex.getValue());
    queue.enQueue(vertexQueue.getValue());

    while (!queue.isEmpty())
    {
      System.out.print(queue.deQueue() + " ");

      while (edges != null)
      {
        edgesConnection = (Edge)(edges.getValue());
        to = (GraphVertex)(edgesConnection.getDest());
        if (!to.getVisit())
        {
          to.setVisit(true);
          queue.enQueue(to.getValue());
        }
        edges = edges.getNext();
      }
    }

    System.out.print("\n");
    vertex.setVisit(false);
    edges = (LinkedList.ListNode)(list.getHead());
    while (edges != null)
    {
      edgesConnection = (Edge)(edges.getValue());
      to = edgesConnection.getDest();
      to.setVisit(false);
      edges = edges.getNext();
    }
  }

  public LinkedList allElements() //Return all elements
  {
    return graph;
  }
}
