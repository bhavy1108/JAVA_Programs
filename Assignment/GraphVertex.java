import java.util.*;
import java.io.*;
import java.io.Serializable;

public class GraphVertex implements Serializable
{
  private Object value;
  private GraphVertex next;
  private LinkedList edges;
  private boolean visited;

  public void setVisit(Boolean visit)
  {
    visited = visit;
  }
  public LinkedList getEdges()
  {
    return edges;
  }
  public boolean getVisit()
  {
    return visited;
  }
  public void addEdge(Edge edge)
  {
    edges.insertNew(edge);
  }
  public GraphVertex getNext()
  {
    return next;
  }
  public void setNext(GraphVertex nxt)
  {
    next = nxt;
  }
  public GraphVertex(Object v)
  {
    visited = false;
    edges = new LinkedList();
    value = v;
    next = null;
  }
}
