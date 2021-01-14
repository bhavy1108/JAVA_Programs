import java.util.*;
import java.io.*;

public class DsaGraph
{
	  private int numVertex;
	  //use linked list 
  	  DSAlinkedL graph = new DSAlinkedL();

  	public int getVertexCounter()
  	{
   		 return graph.getCounter();
  	}
	
	//implementing edge of the graph
  	private class DsaEdge
  	{      
  	             private DsaGraphVertex destination;
   		     private DsaGraphVertex source;
    		
    		public DsaEdge(DsaGraphVertex s, DsaGraphVertex d)
    		{
    
    			  source = s;
     			 destination = d;
    		}
   	 	public DsaGraphVertex getSource()
    	 	{
      
      			return source;
         	}
    		public DsaGraphVertex getDestination()
        	{
      
              		 return destination;
        	}
	
  	}
   
   
	// implementing graph vertex 
	private class DsaGraphVertex
  	{
   		 private Object value;
    		 private DSAlinkedL edge;
    		 private DsaGraphVertex next;
   		 private boolean joined;
 
    	       public void setJoin(Boolean join)
    	       {
			 joined = join;
	       }
		
		
		public boolean getJoin()
		{
			return joined;
		}
		public void addEdge(DsaEdge e)
		{
			edge.insertFirst(e);
		}
		public DsaGraphVertex(Object vertex)
		{
			joined  = false;
			numVertex++;
			edge = new DSAlinkedL();
			value = vertex;
			next = null;
		}
		public DSAlinkedL getEdge()
     		{
     		
     		        return edge;
     		}

                public DsaGraphVertex getNext()
                {
                
                      return next;
                }
                public void setNext(DsaGraphVertex n)
                {
                
                       next = n;
                }
                public Object getValue()
                {
                
                    return value;
                    
                }

             }

                public DsaGraph()
                {
                       numVertex=0;
                       
                }
                public void addEdge(Object s , Object d )
                {
                
                    DsaGraphVertex source = getVertex(s);
                    DsaGraphVertex destination = getVertex(d);
                     
                     if ( source == null)
                     {
                         source = new DsaGraphVertex(s);
                         graph.insertFirst(source);
                         
                     }
                     if ( destination == null)
                     {
                         destination = new DsaGraphVertex(d);  
                         graph.insertFirst(destination);
                     }
                     
                     //undirected graph
                     destination.addEdge(new DsaEdge(source ,destination));
                     
                     //direct graph
                     source.addEdge(new DsaEdge(destination, source));
                     
                     
                 }
                 
                 public DsaGraphVertex getVertex( Object Value )
                 {
     			 DsaGraphVertex returnstr = null;
     			 
     			 //get the vertices  
     			 DSAlinkedL.DSAlistNode vertex =  (DSAlinkedL.DSAlistNode)graph.getHead();
     			 
     			 boolean flag = false;
     			 
     			 if ( vertex != null )
     			 {
     			 
     			   DsaGraphVertex vertex = (DsaGraphVertex)(vertex.getValue());
     			   
     			   while (( vertex != null) && (! flag))
     			   {
     			   
     			        vertex = (DsaGraphVertex)(vertex.getValue());
     			        
     			        if ( vertex.getValue() == val)
     			        {
     			        
     			        
     			            flag = true;
     			            
     			        }
     			        
     			        else
     			        {
     			        
     			           vertex = vertex.getNext();
     			           
     			        }
     			        
     			   }
     			   if (flag)
     			   {
     			   
     			      returnstr = vertex ;
     			      
     			   }
     			   
     			 }
     			 return returnstr;
     			 
     		      }
     		      
     		      	   
                 
                 
                 //method to display graph
                 public void displayGraph()
                 {
                 
                   if (graph.getHead() != null )
                   {
                      //get vertex from graph 
                      DSAlinkedL.DSAlistNode n = (DSAlinkedL.DSAlistNode)( graph.getHead());
                      //receive value of node extracted
                      DsaGraphVertex v = (DsaGraphVertex)(n.getValue());
                      
                      //getting ll of edges
                      DSAlinkedL vEdge = v.getEdge();
                      
                      // extraction of edges
                       DSAlinkedL.DSAlistNode meet =  (DSAlinkedL.DSAlistNode)(vEdge.getHead());
                      
                      
                      while(n != null)
                      {
                         // ll edge for vertex
                         meet = (DSAlinkedL.DSAlistNode)(vEdge.getHead());
                         
                         if (meet != null) // see if any  edges exists 
                          { 
                          
                              // get edge
                               DsaEdge Edgval =  (DsaEdge)(meet.getValue());
                               
                               // get vertex from which it connects
                                DsaGraphVertex v1 = Edgval.getSource();
                                
                                 DsaGraphVertex v1 = Edgval.getDestination();
                                 
                                 System.out.println("Node connection" + v1.getValue() + "");
                               while(meet != null)
                               {
                                 
                                   System.out.println(v2.getValue() + "");
                                   meet = meet.getNext();
                                   if ( meet != null)
                                   {
                                   
                                         Edgval = (DsaEdge) ( meet.getValue());
                                      
                                         v2 = Edgval.getDestination();
                                      
                                    }
                                 }
                                    System.out.println("\n");
                                    n = n.getNext();
                                    
                                    if (n !=  null)
                                    {
                                    
                                    
                                        v = ( DsaGraphVertex  )(n.getValue());
                                        vEdge = v.getEdge();
                                    }
                                 }                                 
                            }
                            
                       }
                     else
                     {
                     
                     
                         System.out.println("The graph is empty.");
                       
                     } 
                     
                  }
                  
                  // breadthFirstSearch
                  
                  public void Bfs(Object value)
                  {
                  
                     DsaQ q = new DsaQ();
                     DsaGraphVertex v = getVertex(value);
                     DSAlinkedL vList =  v.getEdge();
                     DSAlinkedL.DSAlistNode edge = (DSAlinkedL.DSAlistNode)(vList.getHead());
                     DsaEdge edgeMeet = ( DsaEdge) (edge.getValue());
                     DsaGraphVertex source = edgeMeet.getDestination();
                      
                      
                      System.out.println("BFS " + v.getValue() + ":");
                      v.setJoin(true); 
                      DsaGraphVertex vQueue = getVertex(v.getValue());
                      q.enQueue(vQueue.getValue());
                      
                      
                      
                      while (!q.isEmpty())
                      {
                         System.out.println(q.deQueue() + " ");

                          while (edge != null)
                          {
                          
                             edgeMeet = (DsaEdge)(edge.getValue());
                           destination = (DsaGraphVertex)(edgeMeet.getDestination());
                             if (!destination.getJoin())
                             {
                             
                                  destination.setJoin(true);
                                  q.enQueue(destination.getValue());
                                  
                             }
                             edge = edge.getNext();
                             
                            }
                           }
                           
                           System.out.println("/n");
                           v.setJoin(false);
                       edge =  (DSAlinkedL.DSAlistNode)(vList.getHead());
                            
                   while (edge != null)
                   {
     
                       edgeMeet = (DsaEdge)(edge.getValue());
                       destination = edgeMeet.getDestination();
                       destination.setJoin(false);
                       edge = edge.getNext();
                       
                    }
                  
                 }
                 
                 
                 //dfs implementation
                 
                 private void DFS (Object value)
                 {
                 
                    DsaGraphVertex v = getVertex(value);
                     DSAlinkedL vList =  v.getEdge();
                      DSAlinkedL.DSAlistNode edge = (DSAlinkedL.DSAlistNode)(vList.getHead());
                       DsaEdge edgeMeet = (DsaEdge)(edge.getValue());
                          DsaGraphVertex destination  = edgeMeet.getDestination();
                          
                             v.setJoin(true);
                             
                             System.out.println(v.getValue() + " ");
                             
                            while ( edge.getNext() != null)
                            {
                                 DSAlinkedL.DSAlistNode v = edge.getNext();
                                  DsaEdge e = (DsaEdge)(v.getValue());
                                  
                                     DsaGraphVertex tex = e.getDestination();
                                     
                                     if ( !tex.getJoin())
                                     {
                                     
                                        DFS(tex.getValue());
                                        
                                     }
                                     
                                   }
                                 }
                                 
                               public void DepthFSearch(Object v )
                               {
                               
                                     DFS(v);
                                  
                               }     
                                  
}   
                
                             
                             
                             
                             
                             
                              
                          
                                
                            
                                  
                                   
                      
                      
                      
                      
                      
                  
                     
                        

