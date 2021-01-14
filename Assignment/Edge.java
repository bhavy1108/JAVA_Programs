import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Edge implements Serializable
{
  private String name;
  private GraphVertex from;
  private GraphVertex destination;

  public GraphVertex getFrom()
  {
    return from;
  }
  public Edge(String n, GraphVertex f, GraphVertex d)
  {
    name = n;
    from = f;
    destination = d;
  }
  public GraphVertex getDest()
  {
    return destination;
  }
  public String getName()
  {
    return name;
  }
}
