import java.util.*;
import java.io.*;

public class FileIO
{


	private FA_Graph graph;
	
	public FileIO()
	{
	
		graph = null;
	}
	
	public FA_Graph extractGraphFile(String FileName)
	{
		try
		{
		
			String line;
			FileInputStream fileStream = new FileInputStream(FileName);
			InputStreamReader rdr =  new InputStreamReader(fileStream);
			BufferedReader bufRdr = new BufferedReader(rdr);
			
			graph = new FA_Graph();
			line = bufRdr.readLine();
			
			while(line != null)
			{
			
			     addGraph ( line , graph);
			}  
			
		}
		catch (Exception ex)
		{
		
			System.out.println(ex.getMessage());
			
		}
		return graph;
	}
	
	
	// extract 
	private void addGraph (String line, FA_Graph graph)
	{
	
		String[] token  = line.split("");
		char v1 = token[0].charAt(0);
		char v2 = token[1].charAt(0);
		graph.addEdge(v1,v2);
	}
}	
					
