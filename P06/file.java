import java.util.*;
import java.io.*;

public class file
{
	private DsaGraph graph;

	public file()
	{	
	        // graph equals to null
		g = null;
	}

	//Extract data from the file
	public DSAGraph extractGraphFromFiles(String FileName)
	{
	
		try
		{
      
			String line; //Line from file
			FileInputStream fileStream = new FileInputStream(FileName); //Open file
			InputStreamReader rdr = new InputStreamReader(fileStream); //Create reader to read from file
      			BufferedReader bufRdr = new BufferedReader(rdr); //Read one line at a time
      			g = new DsaGraph();
      			lines = bufRdr.readLine(); //Read first line from file
      			
      			while (lines != null)
     		        {
     		        
        			addingToG(lines, g);
        			lines = bufRdr.readLine(); //Read next line from file
     			 }
   		 }
   
 		catch (Exception ex)
   	        {
     			 System.out.println(ex.getMessage());
   		}
   		return g;
	 }

	//Extract lines from the current line, creates a new edge and add to graph
		private void addingToG(String line, DSAGraph graph)
  		{
			String[] token = line.split(" ");
			char v1 = token[0].charAt(0);
			char v2 = token[1].charAt(0);
			g.addNewEdge(v1, v2);
  		}
	}
