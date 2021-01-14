/**
 * DSA Final Assessment Question 2 - DSAGraph.java                        
 *
 * Name : Bhavyattaa Seenarain
 * ID   : 19871253
 *
 **/
import java.util.*;

public class DSAGraph 
{
    private DSALinkedList vertices;
    private int vertexCount;
    private int edgeCount;

    public DSAGraph() 
    {
        vertices = new DSALinkedList();
        vertexCount = 0;
        edgeCount = 0;
    }

    public void addVertex(String label, Object value) 
    {
        GraphVertex vertex = new GraphVertex(label, value); 
        if (!(hasVertex(label))) 
        {
            vertices.insertLast(vertex);
            vertexCount++;
        }
    }

    public void addEdge(String label1, String label2)
    {
        GraphVertex v1, v2; 
        
        v1 = getVertex(label1); 
        v2 = getVertex(label2);   

        v1.addEdge(v2); 

        edgeCount++;
    }

    public boolean hasVertex(String label) 
    {
        boolean has = false;
        for (Object v : vertices) 
        {
		   GraphVertex vg = (GraphVertex) v;
           if (vg.getLabel().equals(label))
			   has = true;
        }
        return has;
    }

    public GraphVertex getVertex(String label) 
    {
        GraphVertex theVertex = null;
        for (Object v : vertices) 
        {
		   GraphVertex vg = (GraphVertex) v;
           if (vg.getLabel().equals(label))
			   theVertex = vg;
        }
		return theVertex;    
	}

    public void displayAsList() 
    {
		System.out.println("Adjacency List display");
		// put your code here
		ListNode node_head = vertices.getHead();
		
		for ( int i = 0; i< vertexCount; i++)
		{
		
			// typecast object top GraphVertex
			GraphVertex vertex = (GraphVertex)node_head.getValue();
			
			System.out.println(vertex.getValue() + " | ");
			
			DSALinkedList links = vertex.getLinks();
			
			// first node from the list - that is the head
			
			ListNode currNd = links.getHead();
			
			
			for (int j = 0; j < links.getSize(); j++ )
			{
				// get vertex of currentNode
				GraphVertex currVertex = (GraphVertex) currNd.getValue();
				
				System.out.println(currVertex.getValue() + " ");
				
				currNd = currNd.getNext();
			}
	
			
				node_head = node_head.getNext();
				//System.out.println("\n");	
                  }

        }
          
            public void displayAsMatrix()
            {
            
            	System.out.println("\n Matrix display");
            	
            	if(vertexCount != 0)
            	{
            	
            		// get the values of all the vertices 
            	   GraphVertex[] allVertex = getVertexArray();
            	   //Retrieve current node to retrieve vertex
            	   ListNode node;
            	   // Retrieve vertex to display and retrieve the Linkedlist of links
            	   GraphVertex vertex;
            	   DSALinkedList links;
            	   
            	   
            	   System.out.println(" ");
            	   
            	   for(int i = 0; i < vertexCount; i++)
            	   {
            	   
            	   	System.out.println(" " + allVertex[i].getValue() + "");
            	   }
            	   System.out.println("\n+++++");	
            	   
            	   for (int i = 0; i < vertexCount - 1; i++ )
            	   {
            	   
            	      System.out.println("+++");
            	      
            	   }  
            	   
            	   node = vertices.getHead();
            	   
            	   for (int i = 0; i < vertexCount; i++)
            	   {
            	   
            	   	vertex = (GraphVertex)node.getValue();
            	   	links = vertex.getLinks();
            	   	System.out.println("\n" + allVertex[i].getValue() + " | ");
            	   	
            	
        
        
}  
