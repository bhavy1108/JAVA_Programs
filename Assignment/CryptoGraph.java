import java.util.*;
import java.io.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.Serializable;

public class CryptoGraph
{
  static Graph cryptograph;
  public static void main(String[] args)
  {
    cryptograph = new Graph();
    //Usage information
    if (args.length == 0)
    {
      System.out.println("\t\t\tUsage information - Crypto Graph\n");
      System.out.println("\t\t\tRun with these commands:\n\n");
      System.out.println("Usage info\t-\tjava .:json-20200518.jar CryptoGraph\n\n");
      System.out.println("Report mode\t-\tjava .:json-20200518.jar CryptoGraph -r asset_FileName TradeInfo_FileName");
      System.out.println("\tWhere :-");;
      System.out.println("\t\t-   Arg1 - Asset File Name");
      System.out.println("\t\t-   Arg2 - Trade File Name\n\n");
      System.out.println("Interactive mode\t-\tjava .:json-20200518.jar CryptoGraph -i\n\n");
    }
    //Report mode
    else if (args.length == 3 && args[0].compareTo("-r") == 0)
    {
      String assetFile = args[1];
      String tradeFile = args[2];

      cryptograph = extractValues(assetFile, tradeFile, cryptograph); //Extract values and save to Graph
      cryptograph.printGraph();
      saveToSerializedFile(cryptograph);
    }
    //Interactive mode
    else if (args.length == 1 && args[0].compareTo("-i") == 0)
    {
      String assetFileName = "";
      String tradeDetails = "";
      Scanner sc = new Scanner(System.in);
      int choice = 0;
      while (choice != 10)
      {
        try
        {
          while (choice < 1 || choice > 11)
          {
            choice = menuInteractive();
          }
          switch (choice)
          {
            case 1:
              System.out.print("Enter file name : ");
              assetFileName = sc.nextLine();
              try
              {
                if (assetFileName.toLowerCase().contains("asset"))
                {
                  FileInputStream fileStream = new FileInputStream(assetFileName);
                  InputStreamReader rdr = new InputStreamReader(fileStream);
                  rdr.close();
                  System.out.println("Asset file loaded successfully");
                }
                else
                {
                  System.out.println("Asset file not loaded");
                }
              }
              catch (Exception ex)
              {
                System.out.println(ex.getMessage());
              }
              choice = 0;
              break;
            case 2:
              System.out.print("Enter file name : ");
              tradeDetails = sc.nextLine();
              try
              {
                if (tradeDetails.toLowerCase().contains("trade"))
                {
                  FileInputStream fileStream = new FileInputStream(tradeDetails);
                  InputStreamReader rdr = new InputStreamReader(fileStream);
                  rdr.close();
                  System.out.println("Trade details file loaded successfully");
                }
                else
                {
                  System.out.println("Trade file not loaded");
                }
              }
              catch (Exception ex)
              {
                System.out.println(ex.getMessage());
              }
              choice = 0;
              break;
            case 3:
              //Display Graph
              if (assetFileName != "" && tradeDetails != "")
              {
                cryptograph = extractValues(assetFileName, tradeDetails, cryptograph); //Extract values and save to Graph
                cryptograph.printGraph();
              }
              choice = 0;
              break;
            case 4:
              readFromSerializedFile();
              choice = 0;
              break;
            case 5:
              if (assetFileName != "" && tradeDetails != "")
              {
                saveToSerializedFile(cryptograph);
              }
              choice = 0;
              break;
            case 6:
              if (assetFileName != "" && tradeDetails != "")
              {
                System.out.print("Enter an asset symbol : ");
                String asset1 = sc.nextLine();
                asset1 = asset1.toUpperCase();
                findAsset(asset1, assetFileName);
              }
              else
              {
                System.out.println("Asset file or trade details file not loaded");
              }
              choice = 0;
              break;
            case 7:
              if (assetFileName != "" && tradeDetails != "")
              {
                System.out.print("Enter a trade symbol : ");
                String tradeDetails1 = sc.nextLine();
                tradeDetails1 = tradeDetails1.toUpperCase();
                findTradeDetails(tradeDetails1, tradeDetails);
              }
              else
              {
                System.out.println("Asset file or trade details file not loaded");
              }
              choice = 0;
              break;
            case 8:
              //Not implemented
              choice = 0;
              break;
            case 9:
              if (assetFileName != "" && tradeDetails != "")
              {
                System.out.print("Enter an asset to find : ");
                String asset2 = sc.nextLine();
                asset2 = asset2.toUpperCase();
                overviewAsset(asset2, assetFileName);
              }
              else
              {
                System.out.println("Asset file or trade details file not loaded");
              }
              choice = 0;
              break;
            case 10:
              if (assetFileName != "" && tradeDetails != "")
              {
                System.out.print("Enter a trade detail to find : ");
                String tradeDetails2 = sc.nextLine();
                tradeDetails2 = tradeDetails2.toUpperCase();
                overviewTrade(tradeDetails2, tradeDetails);
              }
              else
              {
                System.out.println("Asset file or trade details file not loaded");
              }
              choice = 0;
              break;
          }
        }
        catch (Exception ex)
        {
          System.out.println("Enter a number from 1-10");
        }
        System.out.println("\n\n");
      }
    }
    //Invalid
    else
    {
      System.out.println("Invalid number of arguments");
    }
  }

  public static void saveToSerializedFile(Object obj)
  {
		try
		{
			FileOutputStream fos = new FileOutputStream("serializedObjectFile.txt", false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
      System.out.println("Saved to serialized file successfully");
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
  }

  public static void readFromSerializedFile()
  {
		try
		{
			FileInputStream fis = new FileInputStream("serializedObjectFile.txt");
			ObjectInputStream obj = new ObjectInputStream(fis);

			cryptograph = (Graph)obj.readObject();
			System.out.println("Object read from file successfully");
			obj.close();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
  }

  public static int menuInteractive()
  {
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    System.out.println("1. Asset Data");
    System.out.println("2. Trade Data");
    System.out.println("3. Display Graph");
    System.out.println("4. Load Serialised data");
    System.out.println("5. Save Serialized data");
    System.out.println("6. Display Asset");
    System.out.println("7. Display trade details");
    System.out.println("8. Display potential trade paths");
    System.out.println("9. Asset otherview");
    System.out.println("10. Trade overview");
    System.out.println("11. Exit");
    System.out.print("Enter a choice : ");
    choice = sc.nextInt();
    return choice;
  }

  public static Graph extractValues(String assetFile, String tradeInfo, Graph cryptograph)
  {
    //extract values from the trade info file
    LinkedList ll = new LinkedList();
    try
    {
      JSONTokener jsonTokener = new JSONTokener(new FileReader(assetFile));
      JSONObject obj = new JSONObject(jsonTokener);
      JSONArray symbols = obj.getJSONArray("symbols");
      LinkedList objects = new LinkedList();

      for (int i = 0; i < symbols.length(); i++)
      {
        JSONObject symbol = (JSONObject)symbols.get(i);
        String tradeSymbol = symbol.getString("symbol");
        String base = symbol.getString("baseAsset");
        String quote = symbol.getString("quoteAsset");

        TradeDetails td = new TradeDetails(tradeSymbol, base, quote, 0, 0);
        ll.insertNew(td);
      }

      //Extract values from the trade details file
			FileInputStream fileStream = new FileInputStream(tradeInfo); //Open file
			InputStreamReader rdr = new InputStreamReader(fileStream); //Create reader to read from file
			BufferedReader bufRdr = new BufferedReader(rdr); //Read one line at a time
      String line = bufRdr.readLine();
      String jsonObject;
      int position = 0;

      while (line != null)
      {
        while (position < line.length())
        {
          //Extract a json object
          jsonObject = "";
          while (line.charAt(position) != '{' && line.charAt(position) != ']')
          {
            position++;
          }
          if (line.charAt(position) != ']')
          {
            while (line.charAt(position) != '}')
            {
              jsonObject += line.charAt(position);
              position++;
            }
            jsonObject += '}';
            objects.insertNew(jsonObject);
          }
          position++;
        }
        line = bufRdr.readLine();
      }
      //Exctract values from that json object
      try
      {
        LinkedList.ListNode llhead = (LinkedList.ListNode)objects.getHead();
        String jsonObj = (String)llhead.getValue();

        while (llhead.getNext() != null)
        {
          JSONObject jsobj = new JSONObject(jsonObj);
          String sym = jsobj.getString("symbol");
          double bidPrice = jsobj.getDouble("bidPrice");
          double volume = jsobj.getDouble("volume");
          boolean replaced = false;

          LinkedList.ListNode head = (LinkedList.ListNode)ll.getHead();
          TradeDetails td = (TradeDetails)head.getValue();

          while (head != null && !replaced)
          {
            if (sym.compareTo(td.getSymbol()) == 0)
            {
              td.setBid(bidPrice);
              td.setVolume(volume);
              replaced = true;
            }
            else
            {
              head = head.getNext();
              td = (TradeDetails)head.getValue();
            }
          }

          cryptograph.addVertex(td);
          llhead = llhead.getNext();
          jsonObj = (String)llhead.getValue();
        }
      }
      catch (Exception ex)
      {
        System.out.println(ex.getMessage());
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
    return cryptograph;
  }

  public static void findAsset(String value, String filename)
  {
    try
    {
      JSONTokener jsonTokener = new JSONTokener(new FileReader(filename));
      JSONObject obj = new JSONObject(jsonTokener);
      JSONArray symbols = obj.getJSONArray("symbols");
      boolean found = false;

      for (int i = 0; i < symbols.length() && !found; i++)
      {
        JSONObject symbol = (JSONObject)symbols.get(i);
        String tradeSymbol = symbol.getString("symbol");
        if (tradeSymbol.compareTo(value) == 0)
        {
          found = true;
          System.out.println("Symbol : " + found);
        }
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }

  public static void findTradeDetails(String value, String filename)
  {
    LinkedList ll = cryptograph.allElements();
    LinkedList.ListNode node = (LinkedList.ListNode)ll.getHead();
    TradeDetails td = (TradeDetails)node.getValue();
    boolean found = false;

    while (!found && node.getNext() != null)
    {
      if (value.compareTo(td.getSymbol()) == 0)
      {
        System.out.println(td.toString());
        found = true;
      }
      else
      {
        node = node.getNext();
        td = (TradeDetails)node.getValue();
      }
    }
  }

  public static void overviewAsset(String value, String filename)
  {
    try
    {
      JSONTokener jsonTokener = new JSONTokener(new FileReader(filename));
      JSONObject obj = new JSONObject(jsonTokener);
      JSONArray symbols = obj.getJSONArray("symbols");

      for (int i = 0; i < symbols.length(); i++)
      {
        JSONObject symbol = (JSONObject)symbols.get(i);
        String tradeSymbol = symbol.getString("symbol");
        String status = symbol.getString("status");
        String baseAsset = symbol.getString("baseAsset");
        String quoteAsset = symbol.getString("quoteAsset");
        if (tradeSymbol.contains(value))
        {
          System.out.println("Symbol: " + tradeSymbol + " -- Status: " + status +
                            "\nBase asset: " + baseAsset + " -- Quote Asset: " + quoteAsset + "\n\n");
        }
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }

  public static void overviewTrade(String value, String filename)
  {
    try
    {
      //Extract values from the trade details file
      FileInputStream fileStream = new FileInputStream(filename); //Open file
      InputStreamReader rdr = new InputStreamReader(fileStream); //Create reader to read from file
      BufferedReader bufRdr = new BufferedReader(rdr); //Read one line at a time
      String line = bufRdr.readLine();
      String jsonObject;
      int position = 0;

      while (line != null)
      {
        while (position < line.length())
        {
          //Extract a json object
          jsonObject = "";
          while (line.charAt(position) != '{' && line.charAt(position) != ']')
          {
            position++;
          }
          if (line.charAt(position) != ']')
          {
            while (line.charAt(position) != '}')
            {
              jsonObject += line.charAt(position);
              position++;
            }
            jsonObject += '}';


            JSONObject jsobj = new JSONObject(jsonObject);
            String sym = jsobj.getString("symbol");
            if (value.compareTo(sym) == 0)
            {
              double bidPrice = jsobj.getDouble("bidPrice");
              double volume = jsobj.getDouble("volume");
              int count = jsobj.getInt("count");

              System.out.println("Symbol: " + sym + " -- Bid Price: " + bidPrice +
              "\nVolume: " + volume + " -- Count: " + count + "\n\n");
            }
          }
          position++;
        }
        line = bufRdr.readLine();
      }
    }
    catch (Exception ex)
    {
      System.out.println(ex.getMessage());
    }
  }
}
